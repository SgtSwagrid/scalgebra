# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- This package contains type classes for lattice-like structures — a third
  standalone "spine" alongside the additive and multiplicative families in
  [arithmetic](../arithmetic), NOT a prefixed mirror of the base hierarchy like
  [ordered](../ordered)/[normed](../normed)/[archimedean](../archimedean).
  The same rules apply as in [../CLAUDE.md](../CLAUDE.md).
- Nomenclature: traits use mathematical names (`JoinSemilattice`,
  `BooleanAlgebra`); ops use logical names (`or`, `and`, `not`, `imp`) with
  symbolic aliases (`|`, `&`, `unary_!`; `imp` has no symbol — beware that
  Scala gives `=`-initial operators *higher* precedence than `&`/`|`, the
  reverse of the logical convention, so don't add one). The bounds are
  `bottom` (`⊥`, identity for `or`) and `top` (`⊤`, identity for `and`),
  living in the standalone `JoinIdentity`/`MeetIdentity` traits (mirroring
  `AdditiveIdentity`/`MultiplicativeIdentity`), which the bounded semilattices
  extend.
- Primitives: `or`, `and`, `bottom`, `top`, plus `not` for `BooleanAlgebra`.
  Everything else (`imp`, `xor`/`^`, `unary_!`) is derived.
- `DistributiveLattice` and `HeytingAlgebra` were deliberately cut
  (2026-07-11) to keep the hierarchy lean: `BooleanAlgebra` extends
  `BoundedLattice` directly, distributivity is stated as a law in its
  Scaladoc, and `imp` is a derived op (`!x | y`). Don't reintroduce them
  without asking.
- Lattices induce only a partial order, so these type classes deliberately
  define no `<=`/`<` ops — that syntax belongs to [ordered](../ordered)
  (total orders), and defining it here too would create ambiguous extension
  methods for types with both instances (e.g. `Boolean`).
- Do NOT add blanket givens bridging to the other spines (e.g.
  `BoundedLattice` → `Semiring` via `⊥ = zero, ⊤ = one`, or `Ordered` →
  min/max lattice). These correspondences are real but must be exposed as
  explicit constructors when needed, to avoid conflicting instances (e.g.
  `Int` bitwise vs arithmetic).
