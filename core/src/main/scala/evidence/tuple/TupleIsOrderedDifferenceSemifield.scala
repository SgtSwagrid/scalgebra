package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedDifferenceSemifield

/**
  * Evidence that tuples of arity 0 and 1 form an [[OrderedDifferenceSemifield]]
  * under componentwise addition, subtraction, multiplication, and reciprocation
  * and lexicographic ordering, provided the element type (if any) has an
  * [[OrderedDifferenceSemifield]] instance.
  */
trait TupleIsOrderedDifferenceSemifield:

  given [X : OrderedDifferenceSemifield as X]
    : OrderedDifferenceSemifield[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple
    override def one: X *: EmptyTuple  = X.one *: EmptyTuple

    override inline def add
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.add(x.head, y.head) *: EmptyTuple

    override inline def multiply
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.multiply(x.head, y.head) *: EmptyTuple

    override inline def subtract
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.subtract(x.head, y.head) *: EmptyTuple

    override inline def reciprocate(x: X *: EmptyTuple): X *: EmptyTuple = X
      .reciprocate(x.head) *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)
