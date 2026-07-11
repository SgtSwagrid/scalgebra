package com.alecdorrington.scalgebra
package evidence
package numeric

import com.alecdorrington.scalgebra.ordered.OrderedField

/**
  * Evidence that any type with a [[scala.math.Fractional]] instance forms an
  * [[OrderedField]] under standard fractional arithmetic.
  *
  * @note
  *   [[scala.math.Fractional]] provides no rounding operations, so this cannot
  *   be an [[archimedean.ArchimedeanField ArchimedeanField]].
  */
trait FractionalIsOrderedField:

  given [A : Fractional as num] => OrderedField[A]:

    override def zero: A                  = num.zero
    override def one: A                   = num.one
    override def compare(x: A, y: A): Int = num.compare(x, y)

    extension (x: A)

      override def add(y: A): A  = num.plus(x, y)
      override def negate: A     = num.negate(x)
      override def mul(y: A): A  = num.times(x, y)
      override def reciprocal: A = num.div(num.one, x)
