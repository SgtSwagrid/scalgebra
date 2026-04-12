package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.MultiplicativeIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedMultiplicativeIdentityBuilder

/** Methods for constructing [[MultiplicativeIdentity]] type classes. */
trait MultiplicativeIdentityBuilder extends OrderedMultiplicativeIdentityBuilder, MultiplicativeMonoidBuilder
