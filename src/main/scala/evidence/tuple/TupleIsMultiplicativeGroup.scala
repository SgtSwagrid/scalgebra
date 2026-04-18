package com.alecdorrington.scalgebra
package evidence.tuple

/**
  * Evidence that tuples of arity 0 and 1 form a [[MultiplicativeGroup]] under
  * componentwise reciprocation and multiplication, provided the element type
  * (if any) has a [[MultiplicativeGroup]] instance.
  */
trait TupleIsMultiplicativeGroup:

  given [X : MultiplicativeGroup as X]: MultiplicativeGroup[X *: EmptyTuple]
  with

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple
