package com.alecdorrington.scalgebra.connector.cats

import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.lattice.BooleanAlgebra]] and
  * [[algebra.lattice.Bool]].
  */
trait BooleanAlgebraCatsConversions:

  /**
    * Derives an [[algebra.lattice.Bool]] from a
    * [[scalgebra.lattice.BooleanAlgebra]].
    */
  given booleanAlgebraToCats
    : [X : scalgebra.lattice.BooleanAlgebra as S] => algebra.lattice.Bool[X]:

    def or(x: X, y: X): X   = x | y
    def and(x: X, y: X): X  = x & y
    def complement(x: X): X = x.not
    def zero: X             = S.bottom
    def one: X              = S.top

  /**
    * Derives a [[scalgebra.lattice.BooleanAlgebra]] from an
    * [[algebra.lattice.Bool]].
    */
  given booleanAlgebraFromCats
    : [X : algebra.lattice.Bool as S] => scalgebra.lattice.BooleanAlgebra[X]:

    override def bottom: X = S.zero
    override def top: X    = S.one

    extension (x: X)

      override def or(y: X): X  = S.or(x, y)
      override def and(y: X): X = S.and(x, y)
      override def not: X       = S.complement(x)
