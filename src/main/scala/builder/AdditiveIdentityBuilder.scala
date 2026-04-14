package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveIdentity
import io.github.sgtswagrid.structures.evidence.function.FunctionIsAdditiveIdentity
import io.github.sgtswagrid.structures.evidence.future.FutureIsAdditiveIdentity
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsAdditiveIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveIdentityBuilder

/** Methods for constructing [[AdditiveIdentity]] type classes. */
trait AdditiveIdentityBuilder
  extends OrderedAdditiveIdentityBuilder,
          AdditiveMonoidBuilder,
          TupleIsAdditiveIdentity,
          FutureIsAdditiveIdentity,
          FunctionIsAdditiveIdentity
