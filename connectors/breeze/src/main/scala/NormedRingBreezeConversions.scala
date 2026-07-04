package com.alecdorrington.scalgebra.connector.breeze

import breeze.math
import com.alecdorrington.scalgebra.normed.NormedRing
import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversion from [[breeze.math.Ring]] to
  * [[scalgebra.normed.NormedRing]].
  *
  * @note
  *   [[breeze.math.Ring]] carries a norm ([[breeze.math.Ring.normImpl]]), so
  *   the derived instance is a [[scalgebra.normed.NormedRing]] over [[Double]]
  *   rather than a plain [[scalgebra.arithmetic.Ring]].
  *
  * @note
  *   Only the [[breeze.math.Ring]] → [[scalgebra.normed.NormedRing]] direction
  *   is provided. The reverse requires a remainder operation
  *   ([[breeze.math.Ring.%]]), which has no counterpart in
  *   [[scalgebra.normed.NormedRing]].
  */
trait NormedRingBreezeConversions:

  /**
    * Derives a [[scalgebra.normed.NormedRing]] over [[Double]] from a
    * [[breeze.math.Ring]].
    */
  given normedRingFromBreeze: [X : math.Ring as S] => NormedRing[X, Double]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X   = S.+(x, y)
      override def negate: X      = S.negate(x)
      override def mul(y: X): X   = S.*(x, y)
      override def length: Double = S.sNorm(x)
