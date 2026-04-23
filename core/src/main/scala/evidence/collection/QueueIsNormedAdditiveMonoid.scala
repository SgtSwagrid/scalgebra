package com.alecdorrington.scalgebra
package evidence
package collection

import com.alecdorrington.scalgebra.normed.NormedAdditiveMonoid
import scala.collection.immutable.Queue

/**
  * Evidence that [[Queue]] forms a [[NormedAdditiveMonoid]] under
  * concatenation, with norm given by the queue length.
  */
trait QueueIsNormedAdditiveMonoid:

  given [X]: NormedAdditiveMonoid[Queue[X], Int] with

    override def zero: Queue[X] = Queue.empty

    override inline def add(x: Queue[X], y: Queue[X]): Queue[X] = x ++ y

    override inline def norm(x: Queue[X]): Int = x.length
