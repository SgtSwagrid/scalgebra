# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Directory description

- Contains connectors that have conversions between our type classes and those of other libraries.
- Each subdirectory corresponds to a single external library and a distinct sbt subproject.
- For a connector to "Library X", the subdirectory here is called "library-x", and the sbt subproject is called "not-enough-structures-connector-library-x".

## Instructions

- Only include conversions that are clear and unambiguous. Skip things that are missing, but notify the user if an omission might be unexpected.
- Follow the example of the existing connector subprojects when adding a new one.
- Make sure to keep all connectors subprojects up-to-date when adding a new type class to the main project.
  - For each connector, check if the new type class has an equivalent in the corresponding library.
- Use explicit names for all objects, including (part of) the package prefix (e.g. `spire.algebra.Field` instead of just `Field`).
  - This is because name clashes between our types and the external types are expected.
  - Be consist and always use the same prefix for a given library.
  - You don't necessarily need to include the entire package name, especially if it is long. Just include enough to avoid ambiguity and make it clear from which library something originates.
  - Example 1: Don't use `algebra.Field` for `spire.algebra.Field` because from `algebra` alone we have no idea that the thing comes from Spire.
  - Example 2: Don't use `io.github.sgtswagrid.structures` for this library, because it is excessively verbose.
- If asked to add a connector for a new library, start with a search of the docs (or source) of the latest version of that library to identity which type classes are available.
- The connector subprojects should be listed in alphabetical order in `build.sbt`.
