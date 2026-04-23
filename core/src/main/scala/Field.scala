package com.alecdorrington.scalgebra

/** For algebraic structures with addition, multiplication, and inverses. */
trait Field[X] extends EuclideanRing[X], DifferenceSemifield[X]:

  override inline def mod(x: X, y: X): X = zero

/** The companion object for [[Field]]. */
object Field extends Field.Ops:

  trait Ops extends EuclideanRing.Ops, DifferenceSemifield.Ops:

    /** Computes the signed remainder between two values [[x]] and [[y]]. */
    inline def mod[X : Field as X](x: X, y: X): X = X.mod(x, y)

  export com.alecdorrington.scalgebra.Field

  /** The [[Field]] instance describing the current algebra system. */
  inline def field[X : Field as field]: Field[X] = field

trait Thing
