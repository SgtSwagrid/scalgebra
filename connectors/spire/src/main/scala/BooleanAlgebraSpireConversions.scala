package com.alecdorrington.scalgebra.connector.spire

import com.alecdorrington.scalgebra as scalgebra
import spire.algebra

/**
  * Implicit conversions between [[scalgebra.lattice.BooleanAlgebra]] and
  * [[spire.algebra.Bool]].
  */
trait BooleanAlgebraSpireConversions:

  /**
    * Derives a [[spire.algebra.Bool]] from a
    * [[scalgebra.lattice.BooleanAlgebra]].
    */
  given booleanAlgebraToSpire
    : [X : scalgebra.lattice.BooleanAlgebra as S] => algebra.Bool[X]:

    def or(x: X, y: X): X   = x | y
    def and(x: X, y: X): X  = x & y
    def complement(x: X): X = x.not
    def zero: X             = S.bottom
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BooleanAlgebra]] from a
    * [[spire.algebra.Bool]].
    */
  given booleanAlgebraFromSpire
    : [X : algebra.Bool as S] => scalgebra.lattice.BooleanAlgebra[X]:

    override def bottom: X = S.zero
    override def top: X    = S.one

    extension (x: X)

      override def or(y: X): X  = S.or(x, y)
      override def and(y: X): X = S.and(x, y)
      override def not: X       = S.complement(x)
