package io.github.sgtswagrid.structures.connector.spire

/**
  * Introduces compatibility between "Spire" type classes and our own.
  *
  * Import as:
  * ```scala
  * import io.github.sgtswagrid.structures.connector.spire.SpireConversions.given
  * ```
  */
object SpireConversions
  extends AdditiveSemigroupSpireConversions,
          AdditiveMonoidSpireConversions,
          AdditiveGroupSpireConversions,
          MultiplicativeSemigroupSpireConversions,
          MultiplicativeMonoidSpireConversions,
          MultiplicativeGroupSpireConversions,
          SemiringSpireConversions,
          RingSpireConversions,
          EuclideanRingSpireConversions,
          FieldSpireConversions
