package com.alecdorrington.scalgebra
package evidence
package trivial

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * Evidence that [[EmptyTuple]] forms an [[OrderedField]] trivially, as it has
  * exactly one value.
  */
trait EmptyTupleIsOrderedField:

  given OrderedField[EmptyTuple] with

    override def zero: EmptyTuple                                   = EmptyTuple
    override def one: EmptyTuple                                    = EmptyTuple
    override def add(x: EmptyTuple, y: EmptyTuple): EmptyTuple      = EmptyTuple
    override def negate(x: EmptyTuple): EmptyTuple                  = EmptyTuple
    override def multiply(x: EmptyTuple, y: EmptyTuple): EmptyTuple = EmptyTuple
    override def reciprocate(x: EmptyTuple): EmptyTuple             = EmptyTuple
    override def compare(x: EmptyTuple, y: EmptyTuple): Int         = 0
