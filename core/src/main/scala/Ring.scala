package com.alecdorrington.scalgebra

/**
  * For algebraic structures with addition, negation, multiplication, and an
  * identity.
  */
trait Ring[X] extends Pseudoring[X], DifferenceSemiring[X]:

  /** The unique representation of `-1` in this algebra system. */
  def negativeOne: X = negate(one)

/** The companion object for [[Ring]]. */
object Ring extends Ring.Ops:

  trait Ops extends Pseudoring.Ops, DifferenceSemiring.Ops:
    inline def negativeOne[X : Ring as X]: X = X.negativeOne

  export com.alecdorrington.scalgebra.Ring

  /** The [[Ring]] instance describing the current algebra system. */
  inline def ring[X : Ring as ring]: Ring[X] = ring
