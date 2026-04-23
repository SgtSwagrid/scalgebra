# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- Read the [README.md](README.md) from this package before proceeding.
- This package contains type classes for algebraic structures.
- Extension methods for each type class are defined directly in the trait body using `extension (x: X)` blocks.
  Do NOT create separate `*Ops` traits — all operator syntax lives in the type class trait itself.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.

### Companion object structure

Each companion object has exactly this shape:

```scala
object Foo extends Foo.Ops:
  trait Ops extends ParentFoo.Ops  // covariant — same direction as the type class
  export com.alecdorrington.scalgebra.Foo
  inline def foo[X : Foo as foo]: Foo[X] = foo
```

### Inheritance directions

- **Type classes (covariant):** `B extends A` if B is more specific than A.
- **`Ops` (covariant):** same direction as type classes.
  `B.Ops extends A.Ops` if B is more specific than A (i.e. if `B extends A`).

Ops inheritance does NOT cross the ordered/unordered boundary:
- `OrderedFoo extends Foo` (ordered is more specific) →
  `Foo.Ops` does NOT extend `OrderedFoo.Ops` (Ops is covariant only within each hierarchy)

- For each new type class added here, check:
  - the [connectors](../../../connectors) to see if compatibility with other libraries is needed, and
  - the [evidence](evidence) to see if compatibility with the Scala standard library is needed.
