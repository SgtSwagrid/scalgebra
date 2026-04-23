# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- Read the [README.md](README.md) from this package before proceeding.
- This package contains _ordered_ variants of each type class from the parent package,
  plus `Order[X]` — the base type class for total ordering.
- Extension methods for ordered-specific operations (e.g. `abs`, `sign`, `isPositive`)
  are defined directly in the ordered type class trait body using `extension (x: X)` blocks.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.

### Companion object structure

Each companion object has exactly this shape:

```scala
object OrderedFoo extends OrderedFoo.Ops:
  trait Ops extends Foo.Ops, OrderedParent.Ops  // covariant
  export com.alecdorrington.scalgebra.ordered.OrderedFoo
  inline def orderedFoo[X : OrderedFoo as orderedFoo]: OrderedFoo[X] = orderedFoo
```

### Inheritance directions

Since `OrderedFoo extends Foo` (ordered is more specific than unordered):

- **Type classes (covariant):** `OrderedFoo extends Foo`. The root ordered type classes also extend `Order[X]`.
- **`Ops` (covariant):** `OrderedFoo.Ops extends Foo.Ops`. Ordered `Ops` extends the unordered one.
