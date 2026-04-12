package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedOneBuilder

/** Methods for constructing [[MultiplicativeIdentity]] type classes. */
trait OneBuilder extends OrderedOneBuilder, MultiplicativeMonoidBuilder
