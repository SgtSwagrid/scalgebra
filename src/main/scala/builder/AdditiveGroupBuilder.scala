package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveGroup
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveGroupBuilder

/** Methods for constructing [[AdditiveGroup]] type classes. */
trait AdditiveGroupBuilder extends OrderedAdditiveGroupBuilder, RingBuilder
