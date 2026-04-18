package com.alecdorrington.scalgebra.connector.zioprelude

/**
  * Introduces compatibility between "ZIO Prelude" type classes and our own.
  *
  * Import as:
  * ```scala
  * import com.alecdorrington.scalgebra.connector.zioprelude.ZioPreludeConversions.given
  * ```
  *
  * @note
  *   ZIO Prelude uses distinct names for its algebraic type classes:
  *   [[zio.prelude.Associative]] (semigroup), [[zio.prelude.Identity]]
  *   (monoid), and [[zio.prelude.Inverse]] (group). It does not provide ring
  *   or field type classes.
  */
object ZioPreludeConversions
  extends AdditiveSemigroupZioPreludeConversions,
          AdditiveMonoidZioPreludeConversions,
          AdditiveGroupZioPreludeConversions
