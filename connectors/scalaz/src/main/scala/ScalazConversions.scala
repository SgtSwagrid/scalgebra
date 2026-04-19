package com.alecdorrington.scalgebra.connector.scalaz

/**
  * Introduces compatibility between "Scalaz" type classes and our own.
  *
  * Import as:
  * ```scala
  * import com.alecdorrington.scalgebra.connector.scalaz.ScalazConversions.given
  * ```
  *
  * @note
  *   Only [[scalaz.Semigroup]] and [[scalaz.Monoid]] are covered, as Scalaz
  *   does not provide group, ring, or field type classes.
  */
object ScalazConversions
  extends AdditiveSemigroupScalazConversions, AdditiveMonoidScalazConversions
