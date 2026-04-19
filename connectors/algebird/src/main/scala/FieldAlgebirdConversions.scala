package com.alecdorrington.scalgebra.connector.algebird

import com.twitter.algebird
import com.alecdorrington.{scalgebra as structures}

/** Implicit conversions between [[structures.Field]] and [[algebird.Field]]. */
trait FieldAlgebirdConversions:

  /** Derives an [[algebird.Field]] from a [[structures.Field]]. */
  given fieldToAlgebird[X : structures.Field as S]: algebird.Field[X] with

    def plus(x: X, y: X): X  = S.add(x, y)
    def zero: X              = S.zero
    def negate(x: X): X      = S.negate(x)
    def one: X               = S.one
    def times(x: X, y: X): X = S.multiply(x, y)
    def div(x: X, y: X): X   = S.divide(x, y)

  /** Derives a [[structures.Field]] from an [[algebird.Field]]. */
  given fieldFromAlgebird[X : algebird.Field as S]: structures.Field[X] with

    def add(x: X, y: X): X      = S.plus(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def one: X                  = S.one
    def multiply(x: X, y: X): X = S.times(x, y)
    def reciprocate(x: X): X    = S.reciprocal(x)
