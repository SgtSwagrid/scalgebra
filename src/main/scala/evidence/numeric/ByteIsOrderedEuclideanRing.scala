package io.github.sgtswagrid.structures
package evidence
package numeric

import io.github.sgtswagrid.structures.ordered.OrderedEuclideanRing

/**
  * Evidence that [[Byte]] forms an [[OrderedEuclideanRing]] under standard
  * 8-bit integer arithmetic.
  */
trait ByteIsOrderedEuclideanRing:

  given OrderedEuclideanRing[Byte] with

    override inline def negate(x: Byte): Byte            = (-x).toByte
    override inline def add(x: Byte, y: Byte): Byte      = (x + y).toByte
    override inline def divide(x: Byte, y: Byte): Byte   = (x / y).toByte
    override inline def multiply(x: Byte, y: Byte): Byte = (x * y).toByte
    override def one: Byte                               = 1
    override def zero: Byte                              = 0
    override def compare(x: Byte, y: Byte): Int          = x.compareTo(y)
