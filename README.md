<div align="center">

  <h1>🌀 Scalgebra</h1>
  <p>Fine-grained algebraic type classes for Scala 3 library authors. </p>
  
  <span>
    <a href="https://github.com/SgtSwagrid/scalgebra/actions/workflows/build-integrity.yml"><img src="https://github.com/SgtSwagrid/scalgebra/actions/workflows/build-integrity.yml/badge.svg" alt="Build status" /></a>
    <a href="https://search.maven.org/artifact/com.alecdorrington/scalgebra_3"><img src="https://img.shields.io/maven-central/v/com.alecdorrington/scalgebra_3.svg" alt="Maven Central" /></a>
    <a href="https://alecdorrington.com/scalgebra"><img src="https://img.shields.io/badge/docs-latest-blue.svg" alt="Documentation" /></a>
  </span>
  
</div>

## 💡 Overview

**Scalgebra** provides a hierarchy of type classes for algebraic structures: semigroups, monoids, groups, rings, fields, and more, split cleanly along additive and multiplicative lines.

It is aimed at **library designers** rather than end users. If you are writing a generic algorithm and want to express the minimal algebraic requirements on your type parameters, rather than demanding an all-or-nothing `Numeric`, then this library gives you the tools to do so.

### Example

```scala 3
import com.alecdorrington.scalgebra.Ring.{*, given}

// Only requires addition, negation, and multiplication (not division).
def dot[X : Ring](xs: Seq[X], ys: Seq[X]): X =
  xs.zip(ys).map(_ * _).reduce(_ + _)
```

Your users can then call `dot` on any type for which a `Ring` is in scope, including all standard numeric types, without any additional imports on their end.

## ⬇️ Installation

Add the following dependency to your `build.sbt`:

```scala
libraryDependencies += "com.alecdorrington" %% "scalgebra" % "0.2.2"
```

Requires Scala 3.

## 📖 Usage

### Selecting a type class

Choose the weakest type class that covers the operations your code actually uses. The [type class reference](#-type-class-reference) below lists what each one requires.

```scala 3
// Too strong: you don't need division or a zero.
def double[X : Field](x: X): X = x + x

// Just right.
def double[X : AdditiveSemigroup](x: X): X = x + x
```

### Importing

Each type class exposes all necessary syntax through its companion object. Import it with:

```scala 3
import com.alecdorrington.scalgebra.<TypeClass>.{*, given}
```

You only need one import regardless of how many capabilities the type class bundles.

```scala 3
import com.alecdorrington.scalgebra.EuclideanRing.{*, given}

def gcdNorm[X : EuclideanRing as E](xs: Seq[X]): X =
  xs.reduce(E.gcd)  // gcd, +, -, *, /, % all available
```

### Providing evidence

To make your own type work with these type classes, provide a `given` instance:

```scala 3
import com.alecdorrington.scalgebra.AdditiveMonoid

case class Vec2(x: Double, y: Double)

given AdditiveMonoid[Vec2] with
  def add(a: Vec2, b: Vec2): Vec2 = Vec2(a.x + b.x, a.y + b.y)
  def zero: Vec2 = Vec2(0, 0)
```

For in-built types (`Int`, `Double`, etc.), evidence is already included; see [built-in instances](#-built-in-instances).

### Ordered variants

The `ordered` subpackage provides `Ordered`-prefixed variants that combine each type class with `Ordering[X]`. Use these when your algorithm needs both algebraic operations and comparisons under a single context bound.

```scala 3
import com.alecdorrington.scalgebra.ordered.OrderedField.{*, given}

def clamp[X : OrderedField](x: X, lb: X, ub: X): X = x.clamp(lb, ub)
```

The ordered variants go beyond merely combining their unordered counterpart with `Ordering` — they also add operations that require both capabilities simultaneously, such as `abs`, `sign`, and `clamp`. They are also useful in contexts where multiple context bounds cannot be expressed. Note that an `OrderedField[X]` instance must be provided explicitly and is not derived automatically from `Field[X]` and `Ordering[X]`.

## 🔌 Connectors

_Scalgebra_ provides, as separate dependencies, connectors to all major abstract algebra libraries in the Scala ecosystem.
These provide automatic conversion between the algebraic type classes found here and those from each of the other libraries, where equivalents exist.
Conversions are provided in both directions.

### Usage

Each connector is published under the name
`scalgebra-connector-<library-name>`
and can be installed using:
```scala
libraryDependencies += "com.alecdorrington" %% "scalgebra-connector-<library-name>" % "<scalgebra-version>"
```
The version of the connector always matches the version of the core _Scalgebra_ library.

The following import statement will then load all relevant conversions:
```scala
import com.alecdorrington.scalgebra.connector.<libraryname>.<LibraryName>Conversions.given
```

This could even be used to convert between algebra systems from multiple foreign libraries,
with no intention to ever use the intermediates that exist here.

### Supported projects

- [Algebird](https://twitter.github.io/algebird/)
- [Breeze](https://github.com/scalanlp/breeze)
- [Cats Algebra](https://typelevel.org/cats/algebra.html)
- [Scalaz](https://github.com/scalaz/scalaz)
- [Spire](https://spire-math.org/)
- [ZIO Prelude](https://zio.dev/zio-prelude/)

## 📐 Type class reference

The complete hierarchy is shown below. Each trait is in the package `com.alecdorrington.scalgebra`.

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
| `AdditiveSemigroup[X]` | - | `add(x, y)` | `x + y`, `n *: x`¹, `x :* n`¹, `sum(x, xs*)`, `sumOption(xs)` |
| `AdditiveMonoid[X]` | `AdditiveSemigroup`, `AdditiveIdentity` | - | + `n *: x`², `x :* n`², `sum(xs: Iterable)` |
| `DifferenceMonoid[X]` | `AdditiveMonoid` | `subtract(x, y)` | + `x - y` |
| `AdditiveGroup[X]` | `DifferenceMonoid`, `AdditiveInverse` | - | + `-x`, `n *: x`³, `x :* n`³, `x.abs`⁴ |

¹ Strictly positive `n` only. &nbsp; ² Non-negative `n` only. &nbsp; ³ Any integer `n`. &nbsp; ⁴ When `Ordering` is also available.

### Multiplicative structures

| Trait | Extends | Abstract members | Syntax |
|---|---|---|---|
| `MultiplicativeSemigroup[X]` | - | `multiply(x, y)` | `x * y`, `x pow n`¹, `product(x, xs*)`, `productOption(xs)` |
| `MultiplicativeMonoid[X]` | `MultiplicativeSemigroup`, `MultiplicativeIdentity` | - | + `x pow n`², `product(xs: Iterable)` |
| `EuclideanMonoid[X]` | `MultiplicativeMonoid` | `divide(x, y)` | + `x / y` |
| `MultiplicativeGroup[X]` | `EuclideanMonoid`, `MultiplicativeInverse` | - | + `x pow n`³, `x.reciprocal` |

¹ Strictly positive `n` only. &nbsp; ² Non-negative `n` only. &nbsp; ³ Any integer `n`.

### Combined structures

| Trait | Extends | Key additions |
|---|---|---|
| `Semiring[X]` | `AdditiveMonoid`, `MultiplicativeMonoid` | `two` |
| `DifferenceSemiring[X]` | `Semiring`, `DifferenceMonoid` | - |
| `Ring[X]` | `AdditiveGroup`, `DifferenceSemiring` | `negativeOne`, `x.sign`¹ |
| `EuclideanRing[X]` | `Ring`, `EuclideanMonoid` | `x % y`, `E.gcd(x, y)`, `E.lcm(x, y)` |
| `Semifield[X]` | `Semiring`, `MultiplicativeGroup` | - |
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

The ordered variants add the comparison operators `<`, `<=`, `>`, `>=`, `min`, `max`, `clamp`, and `compare` from `Ordering`. They also make `abs` available on `OrderedAdditiveGroup` and `sign` available on `OrderedRing`.

## 🔢 Built-in instances

`given` instances for many types from the standard library are provided out-of-the-box. They are available automatically; no import is required at call sites, as they are placed in the companion objects of the corresponding type class hierarchies.
Included are all numeric types, tuples of algebraic structures, many collections, functions, etc.

## ⚖️ Comparison to other libraries

### What sets this library apart

- **Scala 3 native.** Built from the ground up with `given`/`using`, new-style context bounds, and significant indentation. No legacy implicit machinery.
- **Fine-grained hierarchy.** The type class ladder spans from `AdditiveSemigroup` all the way up through `Semiring`, `Ring`, `EuclideanRing`, `Semifield`, and `Field`, with many intermediate structures (e.g. `DifferenceMonoid`, `EuclideanMonoid`) that other libraries skip over. You can express precisely the capabilities you need.
- **Additive/multiplicative split.** Addition and multiplication are tracked as distinct capabilities via separate inheritance hierarchies, mirroring standard mathematical convention and enabling constraints like `Semiring` that are inexpressible in libraries with a single abstract binary operation.
- **First-class ordered variants.** `OrderedRing`, `OrderedField`, etc. are proper type classes, not just a convention for pairing a structure with `Ordering`. They expose additional operations (`abs`, `sign`, `clamp`) that require both capabilities simultaneously.
- **Zero-import evidence.** Instances for in-built types (`Int`, `Double`, etc.) are propagated through the companion object hierarchy, so call sites need no extra imports.
- **Minimal footprint.** No number types, no approximate data structures, no lattices. Just the structural layer.
- **Compatibility.** Integrates seamlessly with the competition.

### Standard library (`Numeric`, `Integral`, `Fractional`)

The standard library's numerical type classes are monolithic: `Numeric` bundles addition, subtraction, multiplication, absolute value, sign, and conversions all at once, with no way to express a weaker requirement. `Ordering` is a separate, unrelated type class with no connection to the numeric hierarchy.

### Cats / Cats-kernel (`Semigroup`, `Monoid`, `Group`)

Cats treats addition and multiplication as the same abstract operation, with no syntactic or semantic distinction between `+` and `*`. There is no `Ring`, `Field`, or equivalent, and no way to express a constraint like "has both addition and multiplication with compatible identities". It is a good fit for purely additive aggregation but is not designed for numeric abstractions.

### Algebra (typelevel/algebra / cats-algebra)

Originally a standalone attempt to unify the algebraic type classes from Spire and Algebird, algebra is now maintained as the `algebra-core` subproject of Cats. It provides `Ring`, `Field`, `EuclideanRing`, and an additive/multiplicative split, and depends only on `cats-kernel`. It targets Scala 2 and 3. Scalgebra is a Scala 3-native alternative in the same spirit: a self-contained algebraic-structure layer with no dependencies to speak of.

### Algebird (twitter/algebird)

Algebird provided some of the input to typelevel/algebra. Its own focus is aggregation in distributed and streaming systems, with higher-level combinators like approximate data structures (HyperLogLog, Count-Min Sketch) and MapReduce-friendly accumulators on top of a basic `Semigroup`/`Monoid`/`Group` foundation. It is not designed as a general algebraic-structure layer for numeric code.

### Spire (typelevel/spire)

Spire is a comprehensive numerical library that includes algebraic structures alongside number types (`Rational`, `Complex`), interval arithmetic, polynomial rings, and more. It is the right choice when you need the full numerical stack rather than just the structural layer.

## 👁️ See also

- Check out [Abstract Nonsense](https://github.com/SgtSwagrid/abstract-nonsense) for some different abstractions with a more category-theoretic focus.
- This library was made using [Scala Library Template](https://github.com/SgtSwagrid/scala-library-template).
