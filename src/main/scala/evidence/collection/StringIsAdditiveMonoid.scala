package com.alecdorrington.scalgebra
package evidence
package collection

/** Evidence that [[String]] forms an [[AdditiveMonoid]] under concatenation. */
trait StringIsAdditiveMonoid:

  given AdditiveMonoid[String] with

    override def zero: String                             = ""
    override inline def add(x: String, y: String): String = s"$x$y"
