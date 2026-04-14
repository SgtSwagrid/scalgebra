package io.github.sgtswagrid.structures
package evidence
package collection

import scala.collection.immutable.Queue

/** Evidence that [[Queue]] forms an [[AdditiveMonoid]] under concatenation. */
trait QueueIsAdditiveMonoid:

  given [X]: AdditiveMonoid[Queue[X]] with

    override def zero: Queue[X]                                 = Queue.empty
    override inline def add(x: Queue[X], y: Queue[X]): Queue[X] = x ++ y
