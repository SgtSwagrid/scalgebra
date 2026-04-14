package io.github.sgtswagrid.structures
package evidence
package collection

/** Evidence that [[Seq]] forms an [[AdditiveMonoid]] under concatenation. */
trait SeqIsAdditiveMonoid:

  given [X]: AdditiveMonoid[Seq[X]] with

    override def zero: Seq[X]                             = Seq.empty
    override inline def add(x: Seq[X], y: Seq[X]): Seq[X] = x ++ y
