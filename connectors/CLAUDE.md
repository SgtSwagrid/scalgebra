# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Directory description

- Contains connectors that have conversions between our type classes and those of other libraries.
- Each subdirectory corresponds to a single external library and a distinct sbt subproject.
- For a connector to "Library X", the subdirectory here is called "library-x", and the sbt subproject is called "scalgebra-connector-library-x".

## Instructions

- Only include conversions that are clear and unambiguous. Skip things that are missing, but notify the user if an omission might be unexpected.
- Follow the example of the existing connector subprojects when adding a new one.
- Make sure to keep all connectors subprojects up-to-date when adding a new type class to the main project.
  - For each connector, check if the new type class has an equivalent in the corresponding library.
- Beyond the base type classes, the variant hierarchies are covered where a clean counterpart exists:
  cats-kernel's `Order` ↔ `ordered.Ordered`, Spire's `IsReal` → `archimedean.Archimedean` (one-way:
  the reverse needs `toDouble`), and Breeze's `Ring`/`Field` → `normed.NormedRing`/`NormedField`
  over `Double` (Breeze rings carry a norm). ZIO Prelude's `Inverse` maps to `arithmetic.DifferenceMonoid`
  (its `inverse` is binary subtraction with no group laws), not `arithmetic.AdditiveGroup`.
- The `lattice` spine maps two-way to `algebra.lattice` (cats connector) and to Spire's aliases of
  the same traits (`spire.algebra.lattice.*`, plus `spire.algebra.Bool`): the two semilattices,
  their bounded variants, `Lattice`, `BoundedLattice`, and `lattice.BooleanAlgebra` ↔ `Bool`.
- Known unmapped candidates (skipped deliberately): `algebra.ring.DivisionRing` (would create an
  ambiguous second `Field` derivation), `algebra.ring.Signed`/`TruncatedDivision` (no `floor`
  expressible without `one`), `GCDRing` (our `gcd` is derived, not primitive), Spire's
  `NormedVectorSpace`/`MetricSpace` (vector spaces out of scope), `scalaz.Order` and
  `zio.prelude.Ord` (not yet added), `cats.kernel.Semilattice`/`BoundedSemilattice` (unbiased —
  picking join or meet would be arbitrary, and offering both is ambiguous for lattices, as with
  `cats.kernel.Semigroup`), and `algebra.lattice.DistributiveLattice`/`Heyting`/`GenBool`/
  `DeMorgan`/`Logic` (no counterparts — `DistributiveLattice` and `HeytingAlgebra` were
  deliberately cut from the core `lattice` package).
- Use explicit names for all objects, including (part of) the package prefix (e.g. `spire.algebra.Field` instead of just `Field`).
  - This is because name clashes between our types and the external types are expected.
  - Be consistent and always use the same prefix for a given library.
  - You don't necessarily need to include the entire package name, especially if it is long. Just include enough to avoid ambiguity and make it clear from which library something originates.
  - Example 1: Don't use `algebra.Field` for `spire.algebra.Field` because from `algebra` alone we have no idea that the thing comes from Spire.
  - Example 2: Don't use `com.alecdorrington.scalgebra` for this library, because it is excessively verbose.
- If asked to add a connector for a new library, start with a search of the docs (or source) of the latest version of that library to identity which type classes are available.
- The connector subprojects should be listed in alphabetical order in `build.sbt`.
