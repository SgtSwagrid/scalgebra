# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- This package contains _ordered_ variants of each type class from the
  [arithmetic](../arithmetic) package, plus `Ordered[X]` — the base type class
  for total ordering.
- The [archimedean](../archimedean) package builds on and fully mirrors this
  one; keep the two in sync when adding or changing type classes here.
- Extension methods for ordered-specific operations (e.g. `abs`, `sign`, `isPositive`)
  are defined directly in the ordered type class trait body using `extension (x: X)` blocks.
- Take care to ensure inheritance relations are followed in the correct direction.
  These are subtle and can be counterintuitive.

### Companion object structure

Same rules as the parent package (see [../CLAUDE.md](../CLAUDE.md)): no `Ops`
traits, no summoners, no `Canonical` machinery. Companion objects that would
be empty are omitted entirely.

Note that `compare` stays a binary method (from `scala.math.Ordering`), not
an extension method.

### Inheritance directions

Since `OrderedFoo extends Foo` (ordered is more specific than unordered):

- **Type classes (covariant):** `OrderedFoo extends Foo`. The root ordered type classes also extend `Ordered[X]`.
