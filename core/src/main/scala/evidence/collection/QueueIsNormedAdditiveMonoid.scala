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

  given [X] => NormedAdditiveMonoid[Queue[X], Int]:

    override def zero: Queue[X] = Queue.empty

    extension (x: Queue[X])

      override def add(y: Queue[X]): Queue[X] = x ++ y
      override def length: Int                = x.length
