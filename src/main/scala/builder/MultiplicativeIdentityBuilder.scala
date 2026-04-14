package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeIdentity
import io.github.sgtswagrid.structures.evidence.function.FunctionIsMultiplicativeIdentity
import io.github.sgtswagrid.structures.evidence.future.FutureIsMultiplicativeIdentity
import io.github.sgtswagrid.structures.evidence.tuple.TupleIsMultiplicativeIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeIdentityBuilder

/** Methods for constructing [[MultiplicativeIdentity]] type classes. */
trait MultiplicativeIdentityBuilder
  extends OrderedMultiplicativeIdentityBuilder,
          MultiplicativeMonoidBuilder,
          TupleIsMultiplicativeIdentity,
          FutureIsMultiplicativeIdentity,
          FunctionIsMultiplicativeIdentity
