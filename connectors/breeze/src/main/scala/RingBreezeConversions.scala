package com.alecdorrington.scalgebra.connector.breeze

import breeze.math
import com.alecdorrington.scalgebra as structures

/**
  * Implicit conversion from [[math.Ring]] to [[structures.Ring]].
  *
  * @note
  *   Only the [[math.Ring]] → [[structures.Ring]] direction is provided. The
  *   reverse requires a norm ([[math.Ring.normImpl]]), which has no counterpart
  *   in [[structures.Ring]].
  */
trait RingBreezeConversions:

  /** Derives a [[structures.Ring]] from a [[math.Ring]]. */
  given ringFromBreeze[X : math.Ring as S]: structures.Ring[X] with

    def add(x: X, y: X): X      = S.+(x, y)
    def zero: X                 = S.zero
    def negate(x: X): X         = S.negate(x)
    def multiply(x: X, y: X): X = S.*(x, y)
    def one: X                  = S.one
