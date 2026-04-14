package io.github.sgtswagrid.structures.connector.breeze

/**
  * Introduces compatibility between "Breeze" type classes and our own.
  *
  * Import as:
  * ```scala
  * import io.github.sgtswagrid.structures.connector.breeze.BreezeConversions.given
  * ```
  */
object BreezeConversions
  extends SemiringBreezeConversions,
          RingBreezeConversions,
          FieldBreezeConversions
