package com.alecdorrington.scalgebra.connector.breeze

import breeze.math
import com.alecdorrington.scalgebra as structures

/** Implicit conversions between [[structures.Semiring]] and [[math.Semiring]]. */
trait SemiringBreezeConversions:

  /** Derives a [[math.Semiring]] from a [[structures.Semiring]]. */
  given semiringToBreeze[X : structures.Semiring as S]: math.Semiring[X] with

    def zero: X                  = S.zero
    def one: X                   = S.one
    def + (a: X, b: X): X        = S.add(a, b)
    def * (a: X, b: X): X        = S.multiply(a, b)
    def == (a: X, b: X): Boolean = a == b
    def != (a: X, b: X): Boolean = a != b

  /** Derives a [[structures.Semiring]] from a [[math.Semiring]]. */
  given semiringFromBreeze[X : math.Semiring as S]: structures.Semiring[X] with

    def add(x: X, y: X): X      = S.+(x, y)
    def zero: X                 = S.zero
    def multiply(x: X, y: X): X = S.*(x, y)
    def one: X                  = S.one
