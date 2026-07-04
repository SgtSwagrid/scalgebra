# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- This package contains _normed_ variants of each type class from the
  [arithmetic](../arithmetic) package, plus `Normed[X, S]` — the base type
  class for norms.
- Extension methods for normed-specific operations (e.g. `length`, `distanceTo`)
  are defined directly in the normed type class trait body using `extension (x: X)` blocks.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.
- The curried type alias `type Over[S] = [X] =>> NormedFoo[X, S]` must be defined in each companion object.

### Companion object structure

Same rules as the parent package (see [../CLAUDE.md](../CLAUDE.md)): no `Ops`
traits, no summoners, no `Canonical` machinery. The only companion content
specific to this package is the curried type alias:

```scala
object NormedRing:

  type Over[S] = [X] =>> NormedRing[X, S]
```

Note that the norm op is named `length`: a public extension method on the
type class trait.

### Inheritance directions

Since `NormedFoo extends Foo` (normed is more specific):

- **Type classes (covariant):** `NormedFoo extends Foo`. The root normed type classes extend `Normed[X, S]`.
