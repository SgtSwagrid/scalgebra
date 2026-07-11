package com.alecdorrington.scalgebra.connector.breeze

import breeze.math
import com.alecdorrington.scalgebra as scalgebra

/**
  * Implicit conversions between [[scalgebra.arithmetic.Semiring]] and
  * [[breeze.math.Semiring]].
  */
trait SemiringBreezeConversions:

  /**
    * Derives a [[breeze.math.Semiring]] from a
    * [[scalgebra.arithmetic.Semiring]].
    */
  given semiringToBreeze
    : [X : scalgebra.arithmetic.Semiring as S] => math.Semiring[X]:

    def zero: X                  = S.zero
    def one: X                   = S.one
    def + (a: X, b: X): X        = a + b
    def * (a: X, b: X): X        = a * b
    def == (a: X, b: X): Boolean = a == b
    def != (a: X, b: X): Boolean = a != b

  /**
    * Derives a [[scalgebra.arithmetic.Semiring]] from a
    * [[breeze.math.Semiring]].
    */
  given semiringFromBreeze
    : [X : math.Semiring as S] => scalgebra.arithmetic.Semiring[X]:

    override def zero: X = S.zero
    override def one: X  = S.one

    extension (x: X)

      override def add(y: X): X = S.+(x, y)
      override def mul(y: X): X = S.*(x, y)
