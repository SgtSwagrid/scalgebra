# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- Read the [README.md](README.md) from this package before proceeding.
- This package contains evidence that assorted in-built types conform to the requirements of the provided algebraic com.alecdorrington.scalgebra.
- After adding a new trait to this package, make sure to mix it into the companion object of `Root`.
- When adding a new type class, check to see if it can be reasonably defined for any standard library types. If so, add evidence here.
