package io.github.sgtswagrid.structures.connector.algebird

/**
  * Introduces compatibility between "Algebird" type classes and our own.
  *
  * Import as:
  * ```scala
  * import io.github.sgtswagrid.structures.connector.cats.CatsConversions.given
  * ```
  */
object AlgebirdConversions
  extends AdditiveSemigroupAlgebirdConversions,
          AdditiveMonoidAlgebirdConversions,
          AdditiveGroupAlgebirdConversions,
          RingAlgebirdConversions,
          FieldAlgebirdConversions
