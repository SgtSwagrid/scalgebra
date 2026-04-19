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
    : OrderedAdditiveInverse[X *: EmptyTuple] with

    override inline def negate(x: X *: EmptyTuple): X *: EmptyTuple =
      X.negate(x.head) *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

  given [
    X : OrderedAdditiveInverse as X,
    Y : OrderedAdditiveInverse as Y,
  ]: OrderedAdditiveInverse[(X, Y)] with

    override inline def negate(x: (X, Y)): (X, Y) =
      (X.negate(x(0)), Y.negate(x(1)))

    override inline def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

  given [
    X : OrderedAdditiveInverse as X,
    Y : OrderedAdditiveInverse as Y,
    Z : OrderedAdditiveInverse as Z,
  ]: OrderedAdditiveInverse[(X, Y, Z)] with

    override inline def negate(x: (X, Y, Z)): (X, Y, Z) =
      (X.negate(x(0)), Y.negate(x(1)), Z.negate(x(2)))

    override inline def compare(x: (X, Y, Z), y: (X, Y, Z)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c
      else
        val c2 = Y.compare(x(1), y(1))
        if c2 != 0 then c2 else Z.compare(x(2), y(2))

  given [
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
  ]: OrderedAdditiveInverse[(X1, X2, X3, X4)] with

    override inline def negate(x: (X1, X2, X3, X4)): (X1, X2, X3, X4) =
      (X1.negate(x(0)), X2.negate(x(1)), X3.negate(x(2)), X4.negate(x(3)))

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
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
    X5 : OrderedAdditiveInverse as X5,
  ]: OrderedAdditiveInverse[(X1, X2, X3, X4, X5)] with

    override inline def negate(x: (X1, X2, X3, X4, X5)): (X1, X2, X3, X4, X5) =
      (
        X1.negate(x(0)),
        X2.negate(x(1)),
        X3.negate(x(2)),
        X4.negate(x(3)),
        X5.negate(x(4)),
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
    X1 : OrderedAdditiveInverse as X1,
    X2 : OrderedAdditiveInverse as X2,
    X3 : OrderedAdditiveInverse as X3,
    X4 : OrderedAdditiveInverse as X4,
    X5 : OrderedAdditiveInverse as X5,
    X6 : OrderedAdditiveInverse as X6,
  ]: OrderedAdditiveInverse[(X1, X2, X3, X4, X5, X6)] with

    override inline def negate
      (x: (X1, X2, X3, X4, X5, X6))
      : (X1, X2, X3, X4, X5, X6) = (
      X1.negate(x(0)),
      X2.negate(x(1)),
      X3.negate(x(2)),
      X4.negate(x(3)),
      X5.negate(x(4)),
      X6.negate(x(5)),
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
