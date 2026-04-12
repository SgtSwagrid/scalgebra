package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.EuclideanRing
import io.github.sgtswagrid.structures.ordered.builder.OrderedEuclideanRingBuilder

/** Methods for constructing [[EuclideanRing]] type classes. */
trait EuclideanRingBuilder extends OrderedEuclideanRingBuilder, FieldBuilder
