package com.alecdorrington.scalgebra

import scala.annotation.tailrec

/** For algebraic structures with addition, multiplication, and division. */
trait EuclideanRing[X] extends Ring[X], EuclideanMonoid[X]:

  /** Computes the signed remainder between two values [[x]] and [[y]]. */
  def mod(x: X, y: X): X = subtract(x, multiply(divide(x, y), y))

  /** Computes the greatest common divisor of two values [[x]] and [[y]]. */
  @tailrec
  final def gcd(x: X, y: X): X = if y == zero then x else gcd(y, mod(x, y))

  /** Computes the least common multiple of two values [[x]] and [[y]]. */
  final inline def lcm(x: X, y: X): X =
    val g = gcd(x, y)
    if g == zero then g else multiply(divide(x, g), y)

  extension (x: X)

    /** Computes the signed remainder between [[x]] and [[y]]. */
    inline infix def % (y: X): X = mod(x, y)

/** The companion object for [[EuclideanRing]]. */
object EuclideanRing extends EuclideanRing.Ops:

  trait Ops extends Ring.Ops, EuclideanMonoid.Ops:

    /** Computes the signed remainder between two values [[x]] and [[y]]. */
    inline def mod[X : EuclideanRing as X](x: X, y: X): X = X.mod(x, y)

    /** Computes the greatest common divisor of two values [[x]] and [[y]]. */
    inline def gcd[X : EuclideanRing as X](x: X, y: X): X = X.gcd(x, y)

    /** Computes the least common multiple of two values [[x]] and [[y]]. */
    inline def lcm[X : EuclideanRing as X](x: X, y: X): X = X.lcm(x, y)

  export com.alecdorrington.scalgebra.EuclideanRing

  /** The [[EuclideanRing]] instance describing the current algebra system. */
  inline def euclideanRing[X : EuclideanRing as euclideanRing]
    : EuclideanRing[X] = euclideanRing
