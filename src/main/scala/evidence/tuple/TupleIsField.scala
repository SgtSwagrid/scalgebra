package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of arity 0 and 1 form a [[Field]] under componentwise
  * addition, negation, multiplication, division, and reciprocation, provided
  * the element type (if any) has a [[Field]] instance.
  */
trait TupleIsField:

  given [X : Field as X]: Field[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def negate(x: X *: EmptyTuple): X *: EmptyTuple =
      X.negate(x.head) *: EmptyTuple

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple
