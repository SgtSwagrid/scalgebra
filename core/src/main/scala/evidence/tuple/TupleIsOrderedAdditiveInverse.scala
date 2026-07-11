package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveInverse

/**
  * Evidence that tuples of any arity up to 6 have an [[OrderedAdditiveInverse]]
  * under componentwise negation and lexicographic ordering, provided all
  * element types have [[OrderedAdditiveInverse]] instances.
  */
trait TupleIsOrderedAdditiveInverse:

  given [X : OrderedAdditiveInverse as X]
    => OrderedAdditiveInverse[X *: EmptyTuple]:

    override def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

    extension (x: X *: EmptyTuple)

      override def negate: X *: EmptyTuple = x.head.negate *: EmptyTuple

  given [
    X : OrderedAdditiveInverse as X,
    Y : OrderedAdditiveInverse as Y,
  ] => OrderedAdditiveInverse[(X, Y)]:

    override def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

    extension (x: (X, Y))

      override def negate: (X, Y) = (x(0).negate, x(1).negate)

  given [
    X : OrderedAdditiveInverse as X,
    Y : OrderedAdditiveInverse as Y,
    Z : OrderedAdditiveInverse as Z,
  ] => OrderedAdditiveInverse[(X, Y, Z)]:

    override def compare(x: (X, Y, Z), y: (X, Y, Z)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c
      else
        val c2 = Y.compare(x(1), y(1))
        if c2 != 0 then c2 else Z.compare(x(2), y(2))

    extension (x: (X, Y, Z))

      override def negate: (X, Y, Z) = (x(0).negate, x(1).negate, x(2).negate)

  given [
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
  ] => OrderedAdditiveInverse[(X1, X2, X3, X4)]:

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

      override def negate: (X1, X2, X3, X4) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate)

  given [
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
    X5 : OrderedAdditiveInverse as X5,
  ] => OrderedAdditiveInverse[(X1, X2, X3, X4, X5)]:

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

      override def negate: (X1, X2, X3, X4, X5) =
        (x(0).negate, x(1).negate, x(2).negate, x(3).negate, x(4).negate)

  given [
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
    X5 : OrderedAdditiveInverse as X5,
    X6 : OrderedAdditiveInverse as X6,
  ] => OrderedAdditiveInverse[(X1, X2, X3, X4, X5, X6)]:

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

      override def negate: (X1, X2, X3, X4, X5, X6) = (
        x(0).negate,
        x(1).negate,
        x(2).negate,
        x(3).negate,
        x(4).negate,
        x(5).negate,
      )
