package com.alecdorrington.scalgebra.connector.breeze

import breeze.math
import com.alecdorrington.scalgebra.normed.NormedField
import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversion from [[breeze.math.Field]] to
  * [[scalgebra.normed.NormedField]].
  *
  * @note
  *   [[breeze.math.Field]] carries a norm ([[breeze.math.Ring.normImpl]]), so
  *   the derived instance is a [[scalgebra.normed.NormedField]] over [[Double]]
  *   rather than a plain [[scalgebra.arithmetic.Field]].
  *
  * @note
  *   Only the [[breeze.math.Field]] → [[scalgebra.normed.NormedField]]
  *   direction is provided. The reverse requires an arbitrary-exponent power
  *   function ([[breeze.math.Field.pow]]), which has no counterpart in
  *   [[scalgebra.normed.NormedField]].
  */
trait NormedFieldBreezeConversions:

  /**
    * Derives a [[scalgebra.normed.NormedField]] over [[Double]] from a
    * [[breeze.math.Field]].
    */
  given normedFieldFromBreeze: [X : math.Field as S] => NormedField[X, Double]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X   = S.+(x, y)
      override def negate: X      = S.negate(x)
      override def mul(y: X): X   = S.*(x, y)
      override def reciprocal: X  = S.inverse(x)
      override def length: Double = S.sNorm(x)
