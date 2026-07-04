package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.arithmetic.MultiplicativeGroup

/**
  * Evidence that tuples of arity 1 form a [[MultiplicativeGroup]] under
  * componentwise reciprocation and multiplication, provided the element type
  * (if any) has a [[MultiplicativeGroup]] instance.
  */
trait TupleIsMultiplicativeGroup:

  given [X : MultiplicativeGroup as X] => MultiplicativeGroup[X *: EmptyTuple]:

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple
      override def reciprocal: X *: EmptyTuple = x.head.reciprocal *: EmptyTuple
