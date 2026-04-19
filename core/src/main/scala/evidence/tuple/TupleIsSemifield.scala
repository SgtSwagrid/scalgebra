package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of arity 0 and 1 form a [[Semifield]] under
  * componentwise addition, multiplication, and reciprocation, provided the
  * element type (if any) has a [[Semifield]] instance.
  */
trait TupleIsSemifield:

  given [X : Semifield as X]: Semifield[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple
