package io.github.sgtswagrid.structures
package evidence
package trivial

import io.github.sgtswagrid.structures.ordered.OrderedField

/**
  * Evidence that any singleton type forms an [[OrderedField]] as the trivial
  * single-element algebra, provided a [[ValueOf]] instance exists.
  *
  * All operations return the unique value, and comparison always returns `0`.
  */
trait SingletonIsOrderedField:

  given [X : ValueOf as Val]: OrderedField[X] with

    override def negate(x: X): X          = Val.value
    override def add(x: X, y: X): X       = Val.value
    override def reciprocate(x: X): X     = Val.value
    override def multiply(x: X, y: X): X  = Val.value
    override def one: X                   = Val.value
    override def zero: X                  = Val.value
    override def compare(x: X, y: X): Int = 0
