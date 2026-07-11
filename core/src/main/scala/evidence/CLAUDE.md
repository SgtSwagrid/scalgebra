# CLAUDE.md

This file provides guidance to [Claude Code](https://claude.com/product/claude-code) when working with code in this directory.
It is not intended for human eyes.

## Instructions

- Read the [README.md](README.md) from this package before proceeding.
- This package contains evidence that assorted in-built types conform to the requirements of the provided algebraic type classes.
- After adding a new trait to this package, make sure to mix it into the companion object of `Algebra`.
- When adding a new type class, check to see if it can be reasonably defined for any standard library types. If so, add evidence here.
- Givens use new-style syntax with receiver ops as `extension (x: X)` overrides, e.g.:

```scala
given [X : Field as X] => ExecutionContext => Field[Future[X]]:
  override def zero: Future[X] = Future.successful(X.zero)
  override def one: Future[X] = Future.successful(X.one)
  extension (x: Future[X])
    override def add(y: Future[X]): Future[X] = x.zip(y).map(_ + _)
    override def negate: Future[X] = x.map(_.negate)
    override def mul(y: Future[X]): Future[X] = x.zip(y).map(_ * _)
    override def reciprocal: Future[X] = x.map(_.reciprocal)
```

- `compare` stays a binary method: `override def compare(x: T, y: T): Int`.
- `Double`, `Float`, and `BigDecimal` provide `ArchimedeanField` evidence
  (implementing the extra `floor` primitive). The `Fractional` derivation is
  deliberately ordered-only: `scala.math.Fractional` exposes no rounding, so
  do not "upgrade" it to Archimedean.
- Do not add Archimedean evidence for discretely-ordered types (`Int`,
  `BigInt`, etc.) where `floor` would be the identity.
