package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.archimedean.ArchimedeanField

/**
  * Evidence that [[Float]] forms an [[ArchimedeanField]] under single-precision
  * floating-point arithmetic.
  */
trait FloatIsArchimedeanField:

  given ArchimedeanField[Float]:

    override def zero: Float                      = 0.0F
    override def one: Float                       = 1.0F
    override def compare(x: Float, y: Float): Int = x.compareTo(y)

    extension (x: Float)

      override def add(y: Float): Float = x + y
      override def negate: Float        = -x
      override def mul(y: Float): Float = x * y
      override def reciprocal: Float    = 1.0F / x
      override def floor: Float         = math.floor(x.toDouble).toFloat
