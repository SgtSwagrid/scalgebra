package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.collection.immutable.ArraySeq
import scala.reflect.ClassTag

/**
  * Evidence that [[ArraySeq]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the sequence length.
  */
trait ArraySeqIsNormedAdditiveMonoid:

  given [X : ClassTag]: NormedAdditiveMonoid[ArraySeq[X], Int] with

    override def zero: ArraySeq[X] = ArraySeq.empty

    override inline def add(x: ArraySeq[X], y: ArraySeq[X]): ArraySeq[X] = x ++
      y

    override inline def norm(x: ArraySeq[X]): Int = x.length
