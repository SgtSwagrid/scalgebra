package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Seq]] forms a [[NormedAdditiveMonoid]] under concatenation,
  * with norm given by the sequence length.
  */
trait SeqIsNormedAdditiveMonoid:

  given [X] => NormedAdditiveMonoid[Seq[X], Int]:

    override def zero: Seq[X] = Seq.empty

    extension (x: Seq[X])

      override def add(y: Seq[X]): Seq[X] = x ++ y
      override def length: Int            = x.length
