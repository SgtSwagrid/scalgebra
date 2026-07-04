## com.alecdorrington.scalgebra.evidence

This package contains evidence that assorted in-built types conform
to the requirements of the provided algebraic structures.

### Scope

The scope is limited to types which:
- are in the Scala standard library, and
- have a single obvious and canonical implementation in this scheme.

This primarily includes numeric types (e.g. `Int`, `Long`, `Float`, `Double`).

### Intended usage

You don't need to import these givens directly.
Instead, they are always in implicit scope automatically, as they are all
provided by the companion object of the root type class (`Algebra`).
