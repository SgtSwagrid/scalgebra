package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.evidence.collection.{
  ArrayIsAdditiveMonoid, ArraySeqIsAdditiveMonoid, EitherIsAdditiveMonoid,
  IArrayIsAdditiveMonoid, LazyListIsAdditiveMonoid, ListIsAdditiveMonoid,
  MapIsAdditiveMonoid, OptionIsAdditiveMonoid, QueueIsAdditiveMonoid,
  SeqIsAdditiveMonoid, SetIsAdditiveMonoid, SortedMapIsAdditiveMonoid,
  SortedSetIsAdditiveMonoid, StringIsAdditiveMonoid, TryIsAdditiveMonoid,
  VectorIsAdditiveMonoid,
}
import io.github.sgtswagrid.structures.evidence.function.FunctionIsAdditiveMonoid
import io.github.sgtswagrid.structures.evidence.future.FutureIsAdditiveMonoid
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsAdditiveMonoid
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveMonoidBuilder

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
