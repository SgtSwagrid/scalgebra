package io.github.sgtswagrid.nonsense
package algebra.builder

import io.github.sgtswagrid.nonsense.algebra.AdditiveIdentity
import io.github.sgtswagrid.nonsense.algebra.ordered.builder.OrderedZeroBuilder

/** Methods for constructing [[AdditiveIdentity]] type classes. */
trait ZeroBuilder extends OrderedZeroBuilder, AdditiveMonoidBuilder
