# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- Read the [README.md](README.md) from this package before proceeding.
- This package contains _normed_ variants of each type class from the parent package,
  plus `Normed[X, S]` — the base type class for norms.
- Extension methods for normed-specific operations (e.g. `length`, `distanceTo`)
  are defined directly in the normed type class trait body using `extension (x: X)` blocks.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.
- The curried type alias `type Over[S] = [X] =>> NormedFoo[X, S]` must be defined in each companion object.
- Normed type classes have two type parameters `[X, S]`. Use `(using ev: NormedFoo[X, S])` syntax
  in Ops methods rather than context bounds, since context bounds don't support two type parameters.

### Companion object structure

Each companion object has exactly this shape:

```scala
object NormedFoo extends NormedFoo.Ops:
  trait Ops extends Foo.Ops, Normed.Ops  // covariant
  type Over[S] = [X] =>> NormedFoo[X, S]
  export com.alecdorrington.scalgebra.normed.NormedFoo
  inline def normedFoo[X, S](using ev: NormedFoo[X, S]): NormedFoo[X, S] = ev
```

### Inheritance directions

Since `NormedFoo extends Foo` (normed is more specific):

- **Type classes (covariant):** `NormedFoo extends Foo`. The root normed type classes extend `Normed[X, S]`.
- **`Ops` (covariant):** `NormedFoo.Ops extends Foo.Ops` and `NormedFoo.Ops extends Normed.Ops`.
