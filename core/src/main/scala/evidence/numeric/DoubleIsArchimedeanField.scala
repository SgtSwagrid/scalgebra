package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.archimedean.ArchimedeanField

/**
  * Evidence that [[Double]] forms an [[ArchimedeanField]] under
  * double-precision floating-point arithmetic.
  */
trait DoubleIsArchimedeanField:

  given ArchimedeanField[Double]:

    override def zero: Double                       = 0.0
    override def one: Double                        = 1.0
    override def compare(x: Double, y: Double): Int = x.compareTo(y)

    extension (x: Double)

      override def add(y: Double): Double = x + y
      override def negate: Double         = -x
      override def mul(y: Double): Double = x * y
      override def reciprocal: Double     = 1.0 / x
      override def floor: Double          = math.floor(x)
