package io.github.sgtswagrid.structures.connector.cats

/**
  * Introduces compatibility between "Cats Algebra" type classes and our own.
  *
  * Import as:
  * ```scala
  * import io.github.sgtswagrid.structures.connector.cats.CatsConversions.given
  * ```
  */
object CatsConversions
  extends AdditiveSemigroupCatsConversions,
          AdditiveMonoidCatsConversions,
          AdditiveGroupCatsConversions,
          MultiplicativeSemigroupCatsConversions,
          MultiplicativeMonoidCatsConversions,
          MultiplicativeGroupCatsConversions,
          SemiringCatsConversions,
          RingCatsConversions,
          EuclideanRingCatsConversions,
          FieldCatsConversions
