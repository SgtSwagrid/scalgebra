package com.alecdorrington.scalgebra
package ordered.builder

import com.alecdorrington.scalgebra.evidence.tuple.TupleIsOrderedMultiplicativeIdentity
import com.alecdorrington.scalgebra.ordered.OrderedMultiplicativeIdentity

/** Methods for constructing [[OrderedMultiplicativeIdentity]] type classes. */
trait OrderedMultiplicativeIdentityBuilder
  extends OrderedMultiplicativeMonoidBuilder,
          TupleIsOrderedMultiplicativeIdentity
