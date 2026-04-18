package com.alecdorrington.scalgebra
package evidence.tuple

import com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity

/**
  * Evidence that tuples of any arity up to 6 have an
  * [[OrderedAdditiveIdentity]] under lexicographic ordering, provided all
  * element types have [[OrderedAdditiveIdentity]] instances.
  */
trait TupleIsOrderedAdditiveIdentity:

  given [X : OrderedAdditiveIdentity as X]
    : OrderedAdditiveIdentity[X *: EmptyTuple] with

    override def zero: X *: EmptyTuple = X.zero *: EmptyTuple

    override inline def compare(x: X *: EmptyTuple, y: X *: EmptyTuple): Int = X
      .compare(x.head, y.head)

  given [
    X : OrderedAdditiveIdentity as X,
    Y : OrderedAdditiveIdentity as Y,
  ]: OrderedAdditiveIdentity[(X, Y)] with

    override def zero: (X, Y) = (X.zero, Y.zero)

    override inline def compare(x: (X, Y), y: (X, Y)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c else Y.compare(x(1), y(1))

  given [
    X : OrderedAdditiveIdentity as X,
    Y : OrderedAdditiveIdentity as Y,
    Z : OrderedAdditiveIdentity as Z,
  ]: OrderedAdditiveIdentity[(X, Y, Z)] with

    override def zero: (X, Y, Z) = (X.zero, Y.zero, Z.zero)

    override inline def compare(x: (X, Y, Z), y: (X, Y, Z)): Int =
      val c = X.compare(x(0), y(0))
      if c != 0 then c
      else
        val c2 = Y.compare(x(1), y(1))
        if c2 != 0 then c2 else Z.compare(x(2), y(2))

  given [
    X1 : OrderedAdditiveIdentity as X1,
    X2 : OrderedAdditiveIdentity as X2,
    X3 : OrderedAdditiveIdentity as X3,
    X4 : OrderedAdditiveIdentity as X4,
  ]: OrderedAdditiveIdentity[(X1, X2, X3, X4)] with

    override def zero: (X1, X2, X3, X4) = (X1.zero, X2.zero, X3.zero, X4.zero)

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
    X1 : OrderedAdditiveIdentity as X1,
    X2 : OrderedAdditiveIdentity as X2,
    X3 : OrderedAdditiveIdentity as X3,
    X4 : OrderedAdditiveIdentity as X4,
    X5 : OrderedAdditiveIdentity as X5,
  ]: OrderedAdditiveIdentity[(X1, X2, X3, X4, X5)] with

    override def zero: (X1, X2, X3, X4, X5) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero)

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
    X1 : OrderedAdditiveIdentity as X1,
    X2 : OrderedAdditiveIdentity as X2,
    X3 : OrderedAdditiveIdentity as X3,
    X4 : OrderedAdditiveIdentity as X4,
    X5 : OrderedAdditiveIdentity as X5,
    X6 : OrderedAdditiveIdentity as X6,
  ]: OrderedAdditiveIdentity[(X1, X2, X3, X4, X5, X6)] with

    override def zero: (X1, X2, X3, X4, X5, X6) =
      (X1.zero, X2.zero, X3.zero, X4.zero, X5.zero, X6.zero)

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
