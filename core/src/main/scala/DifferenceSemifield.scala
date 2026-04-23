package com.alecdorrington.scalgebra

/**
  * For algebraic structures with addition, subtraction, multiplication, and
  * reciprocation.
  */
trait DifferenceSemifield[X] extends DifferenceSemiring[X], Semifield[X]

/** The companion object for [[DifferenceSemifield]]. */
object DifferenceSemifield extends DifferenceSemifield.Ops:

  trait Ops extends DifferenceSemiring.Ops, Semifield.Ops

  export com.alecdorrington.scalgebra.DifferenceSemifield

  /**
    * The [[DifferenceSemifield]] instance describing the current algebra
    * system.
    */
  inline def differenceSemifield[X : DifferenceSemifield as differenceSemifield]
    : DifferenceSemifield[X] = differenceSemifield
