package com.alecdorrington.scalgebra
package builder

import com.alecdorrington.scalgebra.evidence.collection.{
  ArrayIsAdditiveMonoid, ArraySeqIsAdditiveMonoid, EitherIsAdditiveMonoid,
  IArrayIsAdditiveMonoid, LazyListIsAdditiveMonoid, ListIsAdditiveMonoid,
  MapIsAdditiveMonoid, OptionIsAdditiveMonoid, QueueIsAdditiveMonoid,
  SeqIsAdditiveMonoid, SetIsAdditiveMonoid, SortedMapIsAdditiveMonoid,
  SortedSetIsAdditiveMonoid, StringIsAdditiveMonoid, TryIsAdditiveMonoid,
  VectorIsAdditiveMonoid,
}
import com.alecdorrington.scalgebra.evidence.function.FunctionIsAdditiveMonoid
import com.alecdorrington.scalgebra.evidence.future.FutureIsAdditiveMonoid
import com.alecdorrington.scalgebra.evidence.tuple.TupleIsAdditiveMonoid
import com.alecdorrington.scalgebra.ordered.builder.OrderedAdditiveMonoidBuilder

/** Methods for constructing [[AdditiveMonoid]] type classes. */
trait AdditiveMonoidBuilder
  extends OrderedAdditiveMonoidBuilder,
          DifferenceMonoidBuilder,
          SemiringBuilder,
          StringIsAdditiveMonoid,
          SeqIsAdditiveMonoid,
          ListIsAdditiveMonoid,
          VectorIsAdditiveMonoid,
          ArrayIsAdditiveMonoid,
          ArraySeqIsAdditiveMonoid,
          IArrayIsAdditiveMonoid,
          LazyListIsAdditiveMonoid,
          SetIsAdditiveMonoid,
          SortedSetIsAdditiveMonoid,
          MapIsAdditiveMonoid,
          SortedMapIsAdditiveMonoid,
          OptionIsAdditiveMonoid,
          TupleIsAdditiveMonoid,
          QueueIsAdditiveMonoid,
          EitherIsAdditiveMonoid,
          TryIsAdditiveMonoid,
          FutureIsAdditiveMonoid,
          FunctionIsAdditiveMonoid
