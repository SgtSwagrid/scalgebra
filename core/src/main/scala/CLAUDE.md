# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- This package contains type classes for algebraic structures.
- Only `Algebra` (the root trait) lives at the top level. The base hierarchy
  (additive/multiplicative families through rings and fields, plus the
  difference and quotient variants) lives in [arithmetic](arithmetic).
- Variant hierarchies live in subpackages: [ordered](ordered) (total order),
  [archimedean](archimedean) (rounding to integer values), and [normed](normed)
  (norms). Each mirrors the [arithmetic](arithmetic) hierarchy with a prefix.
- The [lattice](lattice) subpackage is different: a standalone spine of
  lattice-like structures (semilattices through `BooleanAlgebra`), not a
  mirror of the base hierarchy.
- Extension methods for each type class are defined directly in the trait body using `extension (x: X)` blocks.
  Do NOT create separate `*Ops` traits — all operator syntax lives in the type class trait itself.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.

### Companion object structure

There are no `Ops` traits, no `inline def` summoners, and no `Canonical`
machinery (the latter was removed in 2026-07 — do not reintroduce it).
Companion objects contain only receiver-less convenience members where they
exist (e.g. `def zero[X : AdditiveIdentity as X]: X = X.zero`); companion
objects that would otherwise be empty are omitted entirely.

Gotchas:

- Instances implement only the primitive ops (`zero`, `one`, `add`, `negate`,
  `mul`, `reciprocal`, `compare`, `length` for `Normed`, `floor`/`ceil` for
  `Archimedean`, and `or`/`and`/`bottom`/`top`/`not` for lattice types) —
  never derived ops (`sub`, `div`, `pow`, etc.); `div` is a primitive only
  for non-field `Quotient` types (e.g. `Int`).
- `compare` stays a binary method `def compare(x: X, y: X): Int` (inherited
  from `scala.math.Ordering`), not an extension method.
- The multiplicative inverse op is named `reciprocal` (not `reciprocate`).

### Documenting laws

Algebraic laws follow a single convention (standardised 2026-07):

- Every law lives in a trait-level `@note` on the type class trait that
  *introduces* it — the most general trait where every operation in the law
  is in scope AND the law is required. Never on a method, never duplicated
  in companion objects.
  - E.g. the additive identity law sits on `AdditiveMonoid` (first trait
    with both `add` and `zero`), NOT on `AdditiveIdentity.zero`.
  - Laws needing both `+` and `×` (commutativity of `+`, distributivity)
    are deliberately duplicated on BOTH `Semiring` and `Pseudoring` — the
    two incomparable minimal combiners. Same for the multiplication
    monotonicity law on `OrderedSemiring`/`OrderedPseudoring`.
- Format: a single `@note` starting with the line "Laws, in addition to
  those inherited:" followed by one bullet per law, each as
  "Name: `formula`." (e.g. "- Associativity: `(x + y) + z == x + (y + z)`.").
  Laws are cumulative down the hierarchy; never restate inherited laws.
- Normed laws reference structure on the norm codomain `S` that the trait
  doesn't require; their header gains the clause "whenever [[S]] carries the
  corresponding structure:".
- Traits introducing no new laws (composite traits like `Ring`,
  `DifferenceMonoid`) get no laws `@note`.
- Laws constrain primitives (and law-forced overrides). Derived ops whose
  behaviour follows from the laws (e.g. `truncate`/`round` idempotence)
  don't get law notes.
- Method-level `@note` is reserved for behavioural *remarks* aimed at users
  (rounding direction, result ranges, canonical values) — e.g. `Quotient.div`,
  `mod`/`floorMod` ranges, `Field.gcd`. Don't put laws there.

### `inline` and `final` policy

Methods fall into three layers; apply modifiers by layer, not case-by-case:

- **Syntax layer** — pure forwarders with no algebraic content: symbolic
  aliases (`+`, `-`, `*`, `/`, `%`, `**`, `*:`, `:*`, `unary_-`, `<`, `<=`,
  `>`, `>=`, `|`, `&`, `unary_!`, `^`), predicates (`isZero`, `isPositive`,
  `isIntegral`, `isBottom`, …), `Option`/default wrappers (`divOption`,
  `sumOrZero`, …), and companion summoners (`Semiring.fromInt`,
  `AdditiveIdentity.zero`, …). Mark these `inline` (which also makes them
  effectively final). Their bodies must stay trivial and stable forever:
  inlined bodies are baked into downstream bytecode at *their* compile time.
- **Algebra layer** — derived ops with mathematical content (`scale`, `pow`,
  `mod`, `gcd`, `abs`, `sign`, `round`, `floorMod`, `min`/`max`/`clamp`, …).
  Plain `def`, overridable: subtraits refine them (`Field.mod`) and instances
  may legitimately supply faster/more precise primitives. Never `inline`
  (several are overridden, and inline implies final). Exception: mark a
  derived override `final` when its value is forced by the laws — currently
  `Field.mod`/`gcd`/`lcm`.
- **Primitives** — abstract ops; no modifier applies. Their dispatch (and
  boxing for primitive element types in generic code) is the inherent cost of
  the type class encoding; do not try to inline it away inside the library.

### Inheritance directions

- **Type classes (covariant):** `B extends A` if B is more specific than A.

- For each new type class added here, check:
  - the [connectors](../../../../connectors) to see if compatibility with other libraries is needed, and
  - the [evidence](evidence) to see if compatibility with the Scala standard library is needed.
