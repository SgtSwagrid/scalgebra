package com.alecdorrington.scalgebra.connector.algebird

import com.twitter.algebird
import com.alecdorrington.{scalgebra as structures}

/** Implicit conversions between [[structures.Ring]] and [[algebird.Ring]]. */
trait RingAlgebirdConversions:

  /** Derives an [[algebird.Ring]] from a [[structures.Ring]]. */
  given ringToAlgebird[X : structures.Ring as S]: algebird.Ring[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def one: X               = S.one
    def times(x: X, y: X): X = S.multiply(x, y)

  /** Derives a [[structures.Ring]] from an [[algebird.Ring]]. */
  given ringFromAlgebird[X : algebird.Ring as S]: structures.Ring[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def one: X                  = S.one
    def multiply(x: X, y: X): X = S.times(x, y)
