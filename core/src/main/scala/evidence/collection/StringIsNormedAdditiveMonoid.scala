package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[String]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the string length.
  */
trait StringIsNormedAdditiveMonoid:

  given NormedAdditiveMonoid[String, Int] with

    override def zero: String                             = ""
    override inline def add(x: String, y: String): String = s"$x$y"
    override inline def norm(x: String): Int              = x.length
