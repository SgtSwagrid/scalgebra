package com.alecdorrington.scalgebra.connector.cats

/**
  * Introduces compatibility between "Cats Algebra" type classes and our own.
  *
  * Import as:
  * ```scala
  * import com.alecdorrington.scalgebra.connector.cats.CatsConversions.given
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
          SemifieldCatsConversions,
          PseudoringCatsConversions,
          RingCatsConversions,
          QuotientRingCatsConversions,
          FieldCatsConversions,
          OrderedCatsConversions,
          JoinSemilatticeCatsConversions,
          MeetSemilatticeCatsConversions,
          BoundedJoinSemilatticeCatsConversions,
          BoundedMeetSemilatticeCatsConversions,
          LatticeCatsConversions,
          BoundedLatticeCatsConversions,
          BooleanAlgebraCatsConversions
