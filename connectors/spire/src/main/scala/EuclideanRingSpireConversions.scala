package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra
import spire.algebra

/**
  * Implicit conversion from [[spire.algebra.EuclideanRing]] to
  * [[structures.EuclideanRing]].
  *
  * @note
  *   Only the [[spire.algebra.EuclideanRing]] → [[structures.EuclideanRing]]
  *   direction is provided. The reverse requires a `euclideanFunction`, which
  *   has no counterpart in [[structures.EuclideanRing]]. For
  *   [[structures.Field]], see [[FieldSpireConversions]].
  */
trait EuclideanRingSpireConversions:

  /**
    * Derives a [[structures.EuclideanRing]] from a
    * [[spire.algebra.EuclideanRing]].
    */
  given euclideanRingFromSpire[X : algebra.EuclideanRing as S]
    : structures.EuclideanRing[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
    def divide(x: X, y: X): X   = S.equot(x, y)
