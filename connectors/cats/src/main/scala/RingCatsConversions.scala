package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as structures

/** Implicit conversions between [[structures.Ring]] and [[algebra.ring.Ring]]. */
trait RingCatsConversions:

  /** Derives an [[algebra.ring.Ring]] from a [[structures.Ring]]. */
  given ringToCats[X : structures.Ring as S]: algebra.ring.Ring[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def times(x: X, y: X): X = S.multiply(x, y)
    def one: X               = S.one

  /** Derives a [[structures.Ring]] from an [[algebra.ring.Ring]]. */
  given ringFromCats[X : algebra.ring.Ring as S]: structures.Ring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.times(x, y)
    def one: X                  = S.one
