package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedQuotientMonoid

/**
  * Evidence that tuples of any arity up to 6 form an [[OrderedQuotientMonoid]]
  * under componentwise multiplication and division and lexicographic ordering,
  * provided all element types have [[OrderedQuotientMonoid]] instances.
  */
trait TupleIsOrderedQuotientMonoid:

  given [X : OrderedQuotientMonoid as X]
    => OrderedQuotientMonoid[X *: EmptyTuple]:

    override def one: X *: EmptyTuple = X.one *: EmptyTuple

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def mul(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head * y.head) *: EmptyTuple

      override def div(y: X *: EmptyTuple): X *: EmptyTuple =
        (x.head / y.head) *: EmptyTuple

  given [
    X : OrderedQuotientMonoid as X,
    Y : OrderedQuotientMonoid as Y,
  ] => OrderedQuotientMonoid[(X, Y)]:

    override def one: (X, Y) = (X.one, Y.one)

    override def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

    extension (x: (X, Y))

      override def mul(y: (X, Y)): (X, Y) = (x(0) * y(0), x(1) * y(1))

      override def div(y: (X, Y)): (X, Y) = (x(0) / y(0), x(1) / y(1))

  given [
    X : OrderedQuotientMonoid as X,
    Y : OrderedQuotientMonoid as Y,
    Z : OrderedQuotientMonoid as Z,
  ] => OrderedQuotientMonoid[(X, Y, Z)]:

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

      override def div(y: (X, Y, Z)): (X, Y, Z) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2))

  given [
    X1 : OrderedQuotientMonoid as X1,
    X2 : OrderedQuotientMonoid as X2,
    X3 : OrderedQuotientMonoid as X3,
    X4 : OrderedQuotientMonoid as X4,
  ] => OrderedQuotientMonoid[(X1, X2, X3, X4)]:

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

      override def div(y: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3))

  given [
    X1 : OrderedQuotientMonoid as X1,
    X2 : OrderedQuotientMonoid as X2,
    X3 : OrderedQuotientMonoid as X3,
    X4 : OrderedQuotientMonoid as X4,
    X5 : OrderedQuotientMonoid as X5,
  ] => OrderedQuotientMonoid[(X1, X2, X3, X4, X5)]:

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

      override def div(y: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
        (x(0) / y(0), x(1) / y(1), x(2) / y(2), x(3) / y(3), x(4) / y(4))

  given [
    X1 : OrderedQuotientMonoid as X1,
    X2 : OrderedQuotientMonoid as X2,
    X3 : OrderedQuotientMonoid as X3,
    X4 : OrderedQuotientMonoid as X4,
    X5 : OrderedQuotientMonoid as X5,
    X6 : OrderedQuotientMonoid as X6,
  ] => OrderedQuotientMonoid[(X1, X2, X3, X4, X5, X6)]:

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

      override def div(y: (X1, X2, X3, X4, X5, X6)): (X1, X2, X3, X4, X5, X6) =
        (
          x(0) / y(0),
          x(1) / y(1),
          x(2) / y(2),
          x(3) / y(3),
          x(4) / y(4),
          x(5) / y(5),
        )
