package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedAdditiveIdentity
import com.alecdorrington.scalgebra.ordered.OrderedAdditiveIdentity

/** Methods for constructing [[OrderedAdditiveIdentity]] type classes. */
trait OrderedAdditiveIdentityBuilder
  extends OrderedAdditiveMonoidBuilder, TupleIsOrderedAdditiveIdentity
