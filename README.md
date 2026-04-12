<div align="center">

  <h1>🌀 Not Enough Structures</h1>
  <p>A fine-grained collection of algebraic type classes for Scala 3 library authors.</p>
  
  <span>
    <a href="https://github.com/SgtSwagrid/not-enough-structures/actions/workflows/build-integrity.yml"><img src="https://github.com/SgtSwagrid/not-enough-structures/actions/workflows/build-integrity.yml/badge.svg" alt="Build status" /></a>
    <a href="https://search.maven.org/artifact/io.github.sgtswagrid/not-enough-structures_3"><img src="https://img.shields.io/maven-central/v/io.github.sgtswagrid/not-enough-structures_3.svg" alt="Maven Central" /></a>
  </span>
  
</div>

## Overview

**Not Enough Structures** provides a hierarchy of type classes for algebraic structures: semigroups, monoids, groups, rings, fields, and more, split cleanly along additive and multiplicative lines.

It is aimed at **library designers** rather than end users. If you are writing a generic algorithm and want to express the minimal algebraic requirements on your type parameters — rather than demanding an all-or-nothing `Numeric` — this library gives you the tools to do so.

```scala 3
import io.github.sgtswagrid.structures.Ring.{*, given}

// Only requires addition, negation, and multiplication — not division.
def dot[X : Ring](xs: Seq[X], ys: Seq[X]): X =
  xs.zip(ys).map(_ * _).reduce(_ + _)
```

Your users can then call `dot` on any type for which a `Ring` is in scope, including all standard numeric types, without any additional imports on their end.

## ⬇️ Installation

Add the following dependency to your `build.sbt`:

```scala
libraryDependencies += "io.github.sgtswagrid" %% "not-enough-structures" % "0.1.0"
```

Requires Scala 3.

## 📖 Usage

### Selecting a type class

Choose the weakest type class that covers the operations your code actually uses. The [type class reference](#-type-class-reference) below lists what each one requires.

```scala 3
// Too strong — you don't need division or a zero.
def double[X : Field](x: X): X = x + x

// Just right.
def double[X : AdditiveSemigroup](x: X): X = x + x
```

### Importing

Each type class exposes all necessary syntax through its companion object. Import it with:

```scala 3
import io.github.sgtswagrid.structures.<TypeClass>.{*, given}
```

You only need one import regardless of how many capabilities the type class bundles.

```scala 3
import io.github.sgtswagrid.structures.EuclideanRing.{*, given}

def gcdNorm[X : EuclideanRing](xs: Seq[X]): X =
  xs.reduce(_.gcd(_))  // gcd, +, -, *, /, % all available
```

### Providing evidence

To make your own type work with these type classes, provide a `given` instance:

```scala 3
import io.github.sgtswagrid.structures.AdditiveMonoid

case class Vec2(x: Double, y: Double)

given AdditiveMonoid[Vec2] with
  def add(a: Vec2, b: Vec2): Vec2 = Vec2(a.x + b.x, a.y + b.y)
  def zero: Vec2 = Vec2(0, 0)
```

For in-built types (`Int`, `Double`, etc.), evidence is already included — see [built-in instances](#-built-in-instances).

### Ordered variants

The `ordered` subpackage provides `Ordered`-prefixed variants that combine each type class with `Ordering[X]`. Use these when your algorithm needs both algebraic operations and comparisons under a single context bound.

```scala 3
import io.github.sgtswagrid.structures.ordered.OrderedField.{*, given}

def clamp[X : OrderedField](x: X, lo: X, hi: X): X = x.max(lo).min(hi)

def lerp[X : OrderedField](a: X, b: X, t: X): X = a + (b - a) * t
```

`[X : OrderedField]` is equivalent to `[X : {Field, Ordering}]` but is usable in contexts where multiple bounds cannot be expressed (e.g., as a type argument to another generic type class).

---

## 📐 Type class reference

The complete hierarchy is shown below. Each trait is in the package `io.github.sgtswagrid.structures`.

### Component traits

These are standalone mix-ins for individual capabilities. They are rarely used as context bounds directly, but they are extended by the composite structures below.

| Trait | Abstract members | Syntax |
|---|---|---|
| `AdditiveIdentity[+X]` | `zero: X` | `zero[X]`, `x.isZero` |
| `AdditiveInverse[X]` | `negate(x)` | `-x` |
| `MultiplicativeIdentity[+X]` | `one: X` | `one[X]`, `x.isOne` |
| `MultiplicativeInverse[X]` | `reciprocate(x)` | `x.reciprocal` |

### Additive structures

| Trait | Extends | Abstract members | Syntax |
|---|---|---|---|
| `AdditiveSemigroup[X]` | — | `add(x, y)` | `x + y`, `n *: x`¹, `x :* n`¹, `sum(x, xs*)`, `sumOption(xs)` |
| `AdditiveMonoid[X]` | `AdditiveSemigroup`, `AdditiveIdentity` | — | + `n *: x`², `x :* n`², `sum(xs: Iterable)` |
| `DifferenceMonoid[X]` | `AdditiveMonoid` | `subtract(x, y)` | + `x - y` |
| `AdditiveGroup[X]` | `DifferenceMonoid`, `AdditiveInverse` | — | + `-x`, `n *: x`³, `x :* n`³, `x.abs`⁴ |

¹ Strictly positive `n` only. &nbsp; ² Non-negative `n` only. &nbsp; ³ Any integer `n`. &nbsp; ⁴ When `Ordering` is also available.

### Multiplicative structures

| Trait | Extends | Abstract members | Syntax |
|---|---|---|---|
| `MultiplicativeSemigroup[X]` | — | `multiply(x, y)` | `x * y`, `x pow n`¹, `product(x, xs*)`, `productOption(xs)` |
| `MultiplicativeMonoid[X]` | `MultiplicativeSemigroup`, `MultiplicativeIdentity` | — | + `x pow n`², `product(xs: Iterable)` |
| `EuclideanMonoid[X]` | `MultiplicativeMonoid` | `divide(x, y)` | + `x / y` |
| `MultiplicativeGroup[X]` | `EuclideanMonoid`, `MultiplicativeInverse` | — | + `x pow n`³, `x.reciprocal` |

¹ Strictly positive `n` only. &nbsp; ² Non-negative `n` only. &nbsp; ³ Any integer `n`.

### Combined structures

| Trait | Extends | Key additions |
|---|---|---|
| `Semiring[X]` | `AdditiveMonoid`, `MultiplicativeMonoid` | `two` |
| `DifferenceSemiring[X]` | `Semiring`, `DifferenceMonoid` | — |
| `Ring[X]` | `AdditiveGroup`, `DifferenceSemiring` | `negativeOne`, `x.signum`¹ |
| `EuclideanRing[X]` | `Ring`, `EuclideanMonoid` | `x % y`, `gcd(x, y)`, `lcm(x, y)` |
| `Semifield[X]` | `Semiring`, `MultiplicativeGroup` | — |
| `Field[X]` | `EuclideanRing`, `Semifield` | (`mod` is always `zero`) |

¹ When `Ordering` is also available.

### Ordered variants

Every type class above has a corresponding `Ordered`-prefixed variant in the `ordered` subpackage that additionally extends `Ordering[X]`.

| Ordered variant | Extends |
|---|---|
| `OrderedAdditiveSemigroup[X]` | `AdditiveSemigroup[X]`, `Ordering[X]` |
| `OrderedAdditiveMonoid[X]` | `AdditiveMonoid[X]`, `Ordering[X]` |
| `OrderedDifferenceMonoid[X]` | `DifferenceMonoid[X]`, `Ordering[X]` |
| `OrderedAdditiveGroup[X]` | `AdditiveGroup[X]`, `Ordering[X]` |
| `OrderedMultiplicativeSemigroup[X]` | `MultiplicativeSemigroup[X]`, `Ordering[X]` |
| `OrderedMultiplicativeMonoid[X]` | `MultiplicativeMonoid[X]`, `Ordering[X]` |
| `OrderedEuclideanMonoid[X]` | `EuclideanMonoid[X]`, `Ordering[X]` |
| `OrderedMultiplicativeGroup[X]` | `MultiplicativeGroup[X]`, `Ordering[X]` |
| `OrderedSemiring[X]` | `Semiring[X]`, `Ordering[X]` |
| `OrderedDifferenceSemiring[X]` | `DifferenceSemiring[X]`, `Ordering[X]` |
| `OrderedRing[X]` | `Ring[X]`, `Ordering[X]` |
| `OrderedEuclideanRing[X]` | `EuclideanRing[X]`, `Ordering[X]` |
| `OrderedSemifield[X]` | `Semifield[X]`, `Ordering[X]` |
| `OrderedField[X]` | `Field[X]`, `Ordering[X]` |

The ordered variants add the comparison operators `<`, `<=`, `>`, `>=`, `min`, `max`, and `compare` from `Ordering`. They also unlock `abs` on `OrderedAdditiveGroup` and `signum` on `OrderedRing` unconditionally (rather than requiring a separate `Ordering` bound).

---

## 🔢 Built-in instances

The following `given` instances are provided out of the box. They are available automatically — no import is required at call sites, as they are placed in the companion objects of the corresponding type class hierarchies.

| Type | Instance |
|---|---|
| `Boolean` | `OrderedRing` |
| `Int` | `OrderedEuclideanRing` |
| `Long` | `OrderedEuclideanRing` |
| `BigInt` | `OrderedEuclideanRing` |
| `Float` | `OrderedField` |
| `Double` | `OrderedEuclideanRing` |
| `Unit` | `OrderedField` |
| `Nothing` | `OrderedField` |

---

## ⚖️ Comparison to other libraries

### Standard library (`Numeric`, `Integral`, `Fractional`)

Scala's built-in numerical type classes are monolithic: `Numeric` bundles addition, subtraction, multiplication, absolute value, sign, and conversions all at once. There is no way to say "I only need addition and multiplication". The `Ordering`-equivalent is a separate, unrelated type class (`scala.math.Ordering`).

Not Enough Structures gives you fine-grained control. Write `[X : Semiring]` when you only multiply and add; write `[X : AdditiveMonoid]` when you only add. This results in more reusable, less constrained APIs.

### Cats / Cats-kernel (`Semigroup`, `Monoid`, `Group`)

Cats provides abstract algebraic structures (semigroup, monoid, group, semilattice, etc.) but treats addition and multiplication as the same operation — they are both just "combine". There is no syntactic or semantic distinction between `+` and `*`.

Not Enough Structures uses the conventional mathematical naming split: additive structures (`AdditiveSemigroup`, `AdditiveGroup`, …) and multiplicative structures (`MultiplicativeSemigroup`, `MultiplicativeGroup`, …) are distinct hierarchies that combine in the mixed structures (`Semiring`, `Ring`, `Field`, …). This is the model familiar from abstract algebra textbooks, and it lets you express constraints like "has both `+` and `*` with compatible identities" that aren't expressible with cats alone.

### Algebra (typelevel/algebra)

`typelevel/algebra` is the closest analogue to this library. It also provides `Ring`, `Field`, `EuclideanRing`, etc. with an additive/multiplicative split. The primary differences are:

- **Scala 3 native.** Not Enough Structures uses `given`/`using`, new-style context bounds (`[X : Ring as r]`), and significant-indentation syntax throughout. Algebra targets Scala 2 and 3.
- **F-bounded inheritance with `-Ops` traits.** Extension methods are delivered through a dedicated `-Ops` hierarchy that mirrors the type class hierarchy, rather than standalone `implicit class` wrappers.
- **First-class ordered variants.** `OrderedRing`, `OrderedField`, etc. are proper type classes in their own subpackage, not just a convention for combining `Ring[X]` with `cats.kernel.Order[X]`.
- **Smaller scope.** This library is a pure algebraic-structure layer with no additional machinery (no lattices, no `Hash`, no `Eq`).

### Spire (typelevel/spire)

Spire is a comprehensive numerical library that includes algebraic structures as one part of a much larger whole (number types like `Rational` and `Complex`, interval arithmetic, polynomial rings, etc.). It is the right choice when you need the full numerical stack.

Not Enough Structures only provides the algebraic structure layer. It is intentionally minimal — if you just need the type class hierarchy and operator syntax without the associated numeric machinery, the smaller footprint may be preferable.

---

## 📢 Publishing workflow

GitHub releases are automatically published to [Maven Central](https://central.sonatype.com/) upon creation, using [`sbt-dynver`](https://github.com/sbt/sbt-dynver).

### Example

To release version `1.2.3`, go to **Releases → Draft a new release**, create the tag `v1.2.3`, and click **Publish release**.
Note the inclusion of `v` in the GitHub release name but not the resulting Maven version.

## 👁️ See also

Check out [Abstract Nonsense](https://github.com/SgtSwagrid/abstract-nonsense) for some different abstractions with a more category-theoretic focus.
