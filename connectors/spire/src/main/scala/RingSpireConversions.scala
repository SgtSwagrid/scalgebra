package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.{scalgebra as structures}
import spire.algebra

/**
  * Implicit conversions between [[structures.Ring]] and [[spire.algebra.Ring]].
  */
trait RingSpireConversions:

  /** Derives a [[spire.algebra.Ring]] from a [[structures.Ring]]. */
  given ringToSpire[X : structures.Ring as S]: algebra.Ring[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /** Derives a [[structures.Ring]] from a [[spire.algebra.Ring]]. */
  given ringFromSpire[X : algebra.Ring as S]: structures.Ring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
