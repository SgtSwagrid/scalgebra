package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedZeroBuilder

/** Methods for constructing [[AdditiveIdentity]] type classes. */
trait ZeroBuilder extends OrderedZeroBuilder, AdditiveMonoidBuilder
