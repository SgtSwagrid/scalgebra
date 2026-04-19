package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * Evidence that tuples of arity 0 and 1 form an [[OrderedField]] under
  * componentwise addition, negation, multiplication, division, and
  * reciprocation and lexicographic ordering, provided the element type (if any)
  * has an [[OrderedField]] instance.
  */
trait TupleIsOrderedField:

  given [X : OrderedField as X]: OrderedField[X *: EmptyTuple] with

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

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)
