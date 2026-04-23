package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedDifference

/**
  * Evidence that tuples of any arity up to 6 form an [[OrderedDifference]]
  * under componentwise subtraction and lexicographic ordering, provided all
  * element types have [[OrderedDifference]] instances.
  */
trait TupleIsOrderedDifference:

  given [X : OrderedDifference as X]: OrderedDifference[X *: EmptyTuple] with

    override inline def subtract
      (x: X *: EmptyTuple, y: X *: EmptyTuple)
      : X *: EmptyTuple = X.subtract(x.head, y.head) *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

  given [
    X : OrderedDifference as X,
    Y : OrderedDifference as Y,
  ]: OrderedDifference[(X, Y)] with

    override inline def subtract(x: (X, Y), y: (X, Y)): (X, Y) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)))

    override inline def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

  given [
    X : OrderedDifference as X,
    Y : OrderedDifference as Y,
    Z : OrderedDifference as Z,
  ]: OrderedDifference[(X, Y, Z)] with

    override inline def subtract(x: (X, Y, Z), y: (X, Y, Z)): (X, Y, Z) =
      (X.subtract(x(0), y(0)), Y.subtract(x(1), y(1)), Z.subtract(x(2), y(2)))

    override inline def compare(x: (X, Y, Z), y: (X, Y, Z)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c
      else
        val c2 = Y.compare(x(1), y(1))
        if c2 != 0 then c2 else Z.compare(x(2), y(2))

  given [
    X1 : OrderedDifference as X1,
    X2 : OrderedDifference as X2,
    X3 : OrderedDifference as X3,
    X4 : OrderedDifference as X4,
  ]: OrderedDifference[(X1, X2, X3, X4)] with

    override inline def subtract
      (x: (X1, X2, X3, X4), y: (X1, X2, X3, X4))
      : (X1, X2, X3, X4) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
    )

    override inline def compare(x: (X1, X2, X3, X4), y: (X1, X2, X3, X4)): Int =
      val c1 = X1.compare(x(0), y(0))
      if c1 != 0 then c1
      else
        val c2 = X2.compare(x(1), y(1))
        if c2 != 0 then c2
        else
          val c3 = X3.compare(x(2), y(2))
          if c3 != 0 then c3 else X4.compare(x(3), y(3))

  given [
    X1 : OrderedDifference as X1,
    X2 : OrderedDifference as X2,
    X3 : OrderedDifference as X3,
    X4 : OrderedDifference as X4,
    X5 : OrderedDifference as X5,
  ]: OrderedDifference[(X1, X2, X3, X4, X5)] with

    override inline def subtract
      (x: (X1, X2, X3, X4, X5), y: (X1, X2, X3, X4, X5))
      : (X1, X2, X3, X4, X5) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
      X5.subtract(x(4), y(4)),
    )

    override inline def compare
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

  given [
    X1 : OrderedDifference as X1,
    X2 : OrderedDifference as X2,
    X3 : OrderedDifference as X3,
    X4 : OrderedDifference as X4,
    X5 : OrderedDifference as X5,
    X6 : OrderedDifference as X6,
  ]: OrderedDifference[(X1, X2, X3, X4, X5, X6)] with

    override inline def subtract
      (
        x: (X1, X2, X3, X4, X5, X6),
        y: (X1, X2, X3, X4, X5, X6),
      )
      : (X1, X2, X3, X4, X5, X6) = (
      X1.subtract(x(0), y(0)),
      X2.subtract(x(1), y(1)),
      X3.subtract(x(2), y(2)),
      X4.subtract(x(3), y(3)),
      X5.subtract(x(4), y(4)),
      X6.subtract(x(5), y(5)),
    )

    override inline def compare
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
