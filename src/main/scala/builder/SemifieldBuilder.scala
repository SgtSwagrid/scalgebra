package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.Semifield
import io.github.sgtswagrid.structures.ordered.builder.OrderedSemifieldBuilder

/** Methods for constructing [[Semifield]] type classes. */
trait SemifieldBuilder extends OrderedSemifieldBuilder, FieldBuilder
