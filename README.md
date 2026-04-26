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

<br/>

> "Mathematics is the art of giving the same name to different things." — Henri Poincaré.

<br/>

**Scalgebra** provides a hierarchy of type classes for algebraic structures: semigroups, monoids, groups, rings, fields, and more, split cleanly along additive and multiplicative lines.

It is aimed at **library designers** rather than end users. If you are writing a generic algorithm and want to express the minimal algebraic requirements on your type parameters, rather than demanding an all-or-nothing `Numeric`, then this library gives you the tools to do so.

### Example

```scala 3
import com.alecdorrington.scalgebra.Ring

// Only requires addition, negation, and multiplication (not division).
def dot[X : Ring](xs: Seq[X], ys: Seq[X]): X =
  xs.zip(ys).map(_ * _).reduce(_ + _)
```

Your users can then call `dot` on any type for which a `Ring` is in scope,
including all standard numeric types, without any additional imports on their end.

## ⬇️ Installation

Add the following dependency to your `build.sbt`:

```scala
libraryDependencies += "com.alecdorrington" %% "scalgebra" % "0.4.1"
```

Requires Scala 3.

## 📖 Usage

### Selecting a type class

Choose the weakest type class that covers the operations your code actually uses.
The [type class reference](#-type-class-reference) below lists what each one requires/provides.

```scala 3
// Too strong: you don't need division or a zero.
def double[X : Field](x: X): X = x + x

// Just right.
def double[X : AdditiveSemigroup](x: X): X = x + x
```

### In-built types

`given` instances for many types from the standard library are provided out-of-the-box.
They are available automatically; no import is required at call sites,
as they are placed in the companion objects of the corresponding type class hierarchies.
Included are all numeric types, tuples of algebraic structures, many collections, functions, etc.

## 📋 Type class reference

The complete zoo of type classes is shown below.
Each trait can be found in the package `com.alecdorrington.scalgebra`.

| Structure                 | Capabilities                    |
|---------------------------|---------------------------------|
| `AdditiveIdentity`        | `0`                             |
| `AdditiveInverse`         | `-_`                            |
| `Difference`              | `-`                             |
| `AdditiveSemigroup`       | `+`                             |
| `DifferenceSemigroup`     | `+`, `-`                        |
| `AdditiveMonoid`          | `+`, `0`                        |
| `DifferenceMonoid`        | `+`, `-`, `0`                   |
| `AdditiveGroup`           | `+`, `-_`, `0`                  |
| `MultiplicativeIdentity`  | `1`                             |
| `MultiplicativeInverse`   | `^-1`                           |
| `Euclidean`               | `/`                             |
| `MultiplicativeSemigroup` | `*`                             |
| `EuclideanSemigroup`      | `*`, `/`                        |
| `MultiplicativeMonoid`    | `*`, `1`                        |
| `EuclideanMonoid`         | `*`, `/`, `1`                   |
| `MultiplicativeGroup`     | `*`, `^-1`, `1`                 |
| `Semiring`                | `+`, `*`, `0`, `1`              |
| `DifferenceSemiring`      | `+`, `-`, `*`, `0`, `1`         |
| `Pseudoring`              | `+`, `-_`, `*`, `0`             |
| `Ring`                    | `+`, `-_`, `*`, `0`, `1`        |
| `EuclideanRing`           | `+`, `-_`, `*`, `/`, `0`, `1`   |
| `Semifield`               | `+`, `*`, `^-1`, `0`, `1`       |
| `DifferenceSemifield`     | `+`, `-`, `*`, `^-1`, `0`, `1`  |
| `Field`                   | `+`, `-_`, `*`, `^-1`, `0`, `1` |

### Ordered variants

The `ordered` subpackage provides `Ordered`-prefixed variants that combine each type class with `Ordering`.
Use these when your algorithm needs both algebraic operations and comparisons under a single context bound.

```scala 3
import com.alecdorrington.scalgebra.ordered.OrderedField

def clamp[X : OrderedField](x: X, lb: X, ub: X): X = x.clamp(lb, ub)
```

The ordered variants go beyond merely combining their unordered counterpart with `Ordering`,
they also add operations that require both capabilities simultaneously, such as `abs`, `sign`, and `clamp`.
Note that an `OrderedField[X]` instance must be provided explicitly and is not derived automatically from `Field[X]` and `Ordering[X]`.

### Normed variants

The `normed` subpackage provides `Normed`-prefixed variants that combine each type class with `Normed[X, S]`,
where `S` is the scalar type that the norm maps into.
Use these when your algorithm needs both algebraic operations and a norm under a single context bound.

```scala 3
import com.alecdorrington.scalgebra.normed.NormedField

def normalize[X : NormedField.Over[X]](x: X): X = x / x.length
```

The `Over[S]` type alias on each companion (e.g. `NormedField.Over[Double]`) allows them to be used as
single-parameter context bounds.
Note that a `NormedField[X, S]` instance must be provided explicitly and is not derived automatically from `Field[X]` and `Normed[X, S]`.

### Providing evidence

To make your own type work with these type classes, provide a `given` instance:

```scala 3
import com.alecdorrington.scalgebra.AdditiveMonoid

case class Vec2(x: Double, y: Double)

given AdditiveMonoid[Vec2] with
  def add(a: Vec2, b: Vec2): Vec2 = Vec2(a.x + b.x, a.y + b.y)
  def zero: Vec2 = Vec2(0, 0)
```

For in-built types (`Int`, `Double`, etc.), evidence is already included.

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

Connectors currently exist for the following projects:

- [Algebird](https://twitter.github.io/algebird/)
- [Breeze](https://github.com/scalanlp/breeze)
- [Cats Algebra](https://typelevel.org/cats/algebra.html)
- [Scalaz](https://github.com/scalaz/scalaz)
- [Spire](https://spire-math.org/)
- [ZIO Prelude](https://zio.dev/zio-prelude/)

## ⚖️ What sets this library apart?

- **Scala 3 native.** Built from the ground up with `given`/`using`, new-style context bounds, and significant indentation. No legacy implicit machinery.
- **Fine-grained hierarchy.** The type class ladder spans from `AdditiveSemigroup` all the way up through `Semiring`, `Ring`, `EuclideanRing`, `Semifield`, and `Field`, with many intermediate structures (e.g. `DifferenceMonoid`, `DifferenceSemifield`, `EuclideanMonoid`) that other libraries skip over. You can express precisely the capabilities you need.
- **Additive/multiplicative split.** Addition and multiplication are tracked as distinct capabilities via separate inheritance hierarchies, mirroring standard mathematical convention and enabling constraints like `Semiring` that are inexpressible in libraries with a single abstract binary operation.
- **First-class ordered variants.** `OrderedRing`, `OrderedField`, etc. are proper type classes, not just a convention for pairing a structure with `Ordering`. They expose additional operations (`abs`, `sign`, `clamp`) that require both capabilities simultaneously.
- **Zero-import evidence.** Instances for in-built types (`Int`, `Double`, etc.) are propagated through the companion object hierarchy, so call sites need no extra imports.
- **Minimal footprint.** No number types, no approximate data structures, no lattices. Just the structural layer.
- **Compatibility.** Integrates seamlessly with the competition.

## 👁️ See also

- Check out [Abstract Nonsense](https://github.com/SgtSwagrid/abstract-nonsense) for some different abstractions with a more category-theoretic focus.
- This library was made using [Scala Library Template](https://github.com/SgtSwagrid/scala-library-template).
