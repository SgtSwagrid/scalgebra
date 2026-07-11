package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[String]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the string length.
  */
trait StringIsNormedAdditiveMonoid:

  given NormedAdditiveMonoid[String, Int]:

    override def zero: String = ""

    extension (x: String)

      override def add(y: String): String = s"$x$y"
      override def length: Int            = x.length
