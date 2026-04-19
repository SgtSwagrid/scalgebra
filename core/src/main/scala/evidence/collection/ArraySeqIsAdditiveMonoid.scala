package com.alecdorrington.scalgebra
package evidence
package collection

import scala.collection.immutable.ArraySeq
import scala.reflect.ClassTag

/** Evidence that [[ArraySeq]] forms an [[AdditiveMonoid]] under concatenation. */
trait ArraySeqIsAdditiveMonoid:

  given [X : ClassTag]: AdditiveMonoid[ArraySeq[X]] with

    override def zero: ArraySeq[X] = ArraySeq.empty

    override inline def add(x: ArraySeq[X], y: ArraySeq[X]): ArraySeq[X] = x ++
      y
