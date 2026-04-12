package io.github.sgtswagrid.structures
package builder

import io.github.sgtswagrid.structures.AdditiveIdentity
import io.github.sgtswagrid.structures.ordered.builder.OrderedAdditiveIdentityBuilder

/** Methods for constructing [[AdditiveIdentity]] type classes. */
trait AdditiveIdentityBuilder extends OrderedAdditiveIdentityBuilder, AdditiveMonoidBuilder
