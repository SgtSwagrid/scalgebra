package com.alecdorrington.scalgebra.connector.breeze

/**
  * Introduces compatibility between "Breeze" type classes and our own.
  *
  * Import as:
  * ```scala
  * import com.alecdorrington.scalgebra.connector.breeze.BreezeConversions.given
  * ```
  */
object BreezeConversions
  extends SemiringBreezeConversions,
          RingBreezeConversions,
          FieldBreezeConversions
