package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.archimedean.ArchimedeanField

/**
  * Evidence that [[BigDecimal]] forms an [[ArchimedeanField]] under
  * arbitrary-precision decimal arithmetic.
  *
  * @note
  *   Strictly speaking, [[BigDecimal]] is not a field, as exact division is not
  *   closed (e.g. `1 / 3` has no finite decimal representation). Division is
  *   instead rounded according to the operand's `MathContext` (`34` significant
  *   digits by default), so `(x / y) * y` only approximately recovers `x`. Use
  *   [[remainder]] and friends for integer-quotient remainders.
  */
trait BigDecimalIsArchimedeanField:

  given ArchimedeanField[BigDecimal]:

    override def zero: BigDecimal = BigDecimal(0)
    override def one: BigDecimal  = BigDecimal(1)

    override def compare(x: BigDecimal, y: BigDecimal): Int = x.compare(y)

    extension (x: BigDecimal)

      override def add(y: BigDecimal): BigDecimal = x + y
      override def negate: BigDecimal             = -x
      override def mul(y: BigDecimal): BigDecimal = x * y
      override def reciprocal: BigDecimal         = BigDecimal(1) / x

      override def floor: BigDecimal =
        x.setScale(0, BigDecimal.RoundingMode.FLOOR)
