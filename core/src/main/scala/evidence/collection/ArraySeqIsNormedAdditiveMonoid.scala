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

  given [X : ClassTag] => NormedAdditiveMonoid[ArraySeq[X], Int]:

    override def zero: ArraySeq[X] = ArraySeq.empty

    extension (x: ArraySeq[X])

      override def add(y: ArraySeq[X]): ArraySeq[X] = x ++ y
      override def length: Int                      = x.length
