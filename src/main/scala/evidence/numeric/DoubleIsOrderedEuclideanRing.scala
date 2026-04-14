package io.github.sgtswagrid.structures
package evidence
package numeric

import io.github.sgtswagrid.structures.ordered.OrderedField

/**
  * Evidence that [[Double]] forms an [[OrderedField]] under double-precision
  * floating-point arithmetic.
  */
trait DoubleIsOrderedEuclideanRing:

  given OrderedField[Double] with

    override def negate(x: Double): Double              = -x
    override def add(x: Double, y: Double): Double      = x + y
    override def reciprocate(x: Double): Double         = 1.0 / x
    override def multiply(x: Double, y: Double): Double = x * y
    override def one: Double                            = 1.0
    override def zero: Double                           = 0.0
    override def compare(x: Double, y: Double): Int     = x.compareTo(y)
