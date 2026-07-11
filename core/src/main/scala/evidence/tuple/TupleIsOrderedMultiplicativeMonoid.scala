package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeMonoid

/**
  * Evidence that tuples of any arity up to 6 form an
  * [[OrderedMultiplicativeMonoid]] under componentwise multiplication and
  * lexicographic ordering, provided all element types have
  * [[OrderedMultiplicativeMonoid]] instances.
  */
trait TupleIsOrderedMultiplicativeMonoid:

  given [X : OrderedMultiplicativeMonoid as X]
    => OrderedMultiplicativeMonoid[X *: EmptyTuple]:

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

  given [
    X : OrderedMultiplicativeMonoid as X,
    Y : OrderedMultiplicativeMonoid as Y,
  ] => OrderedMultiplicativeMonoid[(X, Y)]:

    override def one: (X, Y) = (X.one, Y.one)

    override def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

    extension (x: (X, Y))

      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))

  given [
    X : OrderedMultiplicativeMonoid as X,
    Y : OrderedMultiplicativeMonoid as Y,
    Z : OrderedMultiplicativeMonoid as Z,
  ] => OrderedMultiplicativeMonoid[(X, Y, Z)]:

    override def one: (X, Y, Z) = (X.one, Y.one, Z.one)

    override def compare(x: (X, Y, Z), y: (X, Y, Z)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c
      else
        val c2 = Y.compare(x(1), y(1))
        if c2 != 0 then c2 else Z.compare(x(2), y(2))

    extension (x: (X, Y, Z))

      override def mul(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2))

  given [
    X1 : OrderedMultiplicativeMonoid as X1,
    X2 : OrderedMultiplicativeMonoid as X2,
    X3 : OrderedMultiplicativeMonoid as X3,
    X4 : OrderedMultiplicativeMonoid as X4,
  ] => OrderedMultiplicativeMonoid[(X1, X2, X3, X4)]:

    override def one: (X1, X2, X3, X4) = (X1.one, X2.one, X3.one, X4.one)

    override def compare(x: (X1, X2, X3, X4), y: (X1, X2, X3, X4)): Int =
      val c1 = X1.compare(x(0), y(0))
      if c1 != 0 then c1
      else
        val c2 = X2.compare(x(1), y(1))
        if c2 != 0 then c2
        else
          val c3 = X3.compare(x(2), y(2))
          if c3 != 0 then c3 else X4.compare(x(3), y(3))

    extension (x: (X1, X2, X3, X4))

      override def mul(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3))

  given [
    X1 : OrderedMultiplicativeMonoid as X1,
    X2 : OrderedMultiplicativeMonoid as X2,
    X3 : OrderedMultiplicativeMonoid as X3,
    X4 : OrderedMultiplicativeMonoid as X4,
    X5 : OrderedMultiplicativeMonoid as X5,
  ] => OrderedMultiplicativeMonoid[(X1, X2, X3, X4, X5)]:

    override def one: (X1, X2, X3, X4, X5) =
      (X1.one, X2.one, X3.one, X4.one, X5.one)

    override def compare
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : Int =
      val c1 = X1.compare(x(0), y(0))
      if c1 != 0 then c1
      else
        val c2 = X2.compare(x(1), y(1))
        if c2 != 0 then c2
        else
          val c3 = X3.compare(x(2), y(2))
          if c3 != 0 then c3
          else
            val c4 = X4.compare(x(3), y(3))
            if c4 != 0 then c4 else X5.compare(x(4), y(4))

    extension (x: (X1, X2, X3, X4, X5))

      override def mul(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) * y(0), x(1) * y(1), x(2) * y(2), x(3) * y(3), x(4) * y(4))

  given [
    X1 : OrderedMultiplicativeMonoid as X1,
    X2 : OrderedMultiplicativeMonoid as X2,
    X3 : OrderedMultiplicativeMonoid as X3,
    X4 : OrderedMultiplicativeMonoid as X4,
    X5 : OrderedMultiplicativeMonoid as X5,
    X6 : OrderedMultiplicativeMonoid as X6,
  ] => OrderedMultiplicativeMonoid[(X1, X2, X3, X4, X5, X6)]:

    override def one: (X1, X2, X3, X4, X5, X6) =
      (X1.one, X2.one, X3.one, X4.one, X5.one, X6.one)

    override def compare
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : Int =
      val c1 = X1.compare(x(0), y(0))
      if c1 != 0 then c1
      else
        val c2 = X2.compare(x(1), y(1))
        if c2 != 0 then c2
        else
          val c3 = X3.compare(x(2), y(2))
          if c3 != 0 then c3
          else
            val c4 = X4.compare(x(3), y(3))
            if c4 != 0 then c4
            else
              val c5 = X5.compare(x(4), y(4))
              if c5 != 0 then c5 else X6.compare(x(5), y(5))

    extension (x: (X1, X2, X3, X4, X5, X6))

      override def mul(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) * y(0),
          x(1) * y(1),
          x(2) * y(2),
          x(3) * y(3),
          x(4) * y(4),
          x(5) * y(5),
        )
