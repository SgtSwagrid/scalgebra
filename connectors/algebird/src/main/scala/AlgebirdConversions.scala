package com.alecdorrington.scalgebra.connector.algebird

/**
  * Introduces compatibility between "Algebird" type classes and our own.
  *
  * Import as:
  * ```scala
  * import com.alecdorrington.scalgebra.connector.cats.CatsConversions.given
  * ```
  */
object AlgebirdConversions
  extends AdditiveSemigroupAlgebirdConversions,
          AdditiveMonoidAlgebirdConversions,
          AdditiveGroupAlgebirdConversions,
          RingAlgebirdConversions,
          FieldAlgebirdConversions
