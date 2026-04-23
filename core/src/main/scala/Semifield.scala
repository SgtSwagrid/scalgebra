package com.alecdorrington.scalgebra

/** For algebraic structures with addition, multiplication, and reciprocation. */
trait Semifield[X] extends Semiring[X], MultiplicativeGroup[X]

/** The companion object for [[Semifield]]. */
object Semifield extends Semifield.Ops:

  trait Ops extends Semiring.Ops, MultiplicativeGroup.Ops

  export com.alecdorrington.scalgebra.Semifield

  /** The [[Semifield]] instance describing the current algebra system. */
  inline def semifield[X : Semifield as semifield]: Semifield[X] = semifield
