package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid

/**
  * Evidence that [[Seq]] forms a [[NormedAdditiveMonoid]] under concatenation,
  * with norm given by the sequence length.
  */
trait SeqIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[Seq[X], Int] with

    override def zero: Seq[X]                             = Seq.empty
    override inline def add(x: Seq[X], y: Seq[X]): Seq[X] = x ++ y
    override inline def norm(x: Seq[X]): Int              = x.length
