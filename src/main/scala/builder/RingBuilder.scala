package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Ring
import io.github.sgtswagrid.structures.ordered.builder.OrderedRingBuilder

/** Methods for constructing [[Ring]] type classes. */
trait RingBuilder extends OrderedRingBuilder, EuclideanRingBuilder
