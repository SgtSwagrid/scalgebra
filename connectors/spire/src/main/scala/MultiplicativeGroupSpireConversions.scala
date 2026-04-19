package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.{scalgebra as structures}
import spire.algebra

/**
  * Implicit conversions between [[structures.MultiplicativeGroup]] and
  * [[spire.algebra.MultiplicativeGroup]].
  */
trait MultiplicativeGroupSpireConversions:

  /**
    * Derives a [[spire.algebra.MultiplicativeGroup]] from a
    * [[structures.MultiplicativeGroup]].
    */
  given multiplicativeGroupToSpire[X : structures.MultiplicativeGroup as S]
    : algebra.MultiplicativeGroup[X] with

    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one
    def div(x: X, y: X): X   = S.divide(x, y)

  /**
    * Derives a [[structures.MultiplicativeGroup]] from a
    * [[spire.algebra.MultiplicativeGroup]].
    */
  given multiplicativeGroupFromSpire[X : algebra.MultiplicativeGroup as S]
    : structures.MultiplicativeGroup[X] with

    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def reciprocate(x: X): X    = S.reciprocal(x)
