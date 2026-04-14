package io.github.sgtswagrid.structures
package evidence
package collection

/**
  * Evidence that [[Option]] forms an [[AdditiveMonoid]] by lifting an
  * [[AdditiveSemigroup]], with [[None]] as zero.
  *
  * Adding two [[Some]] values combines their contents; adding [[None]] to
  * anything returns the other value unchanged.
  */
trait OptionIsAdditiveMonoid:

  given [X : AdditiveSemigroup as X]: AdditiveMonoid[Option[X]] with

    override def zero: Option[X] = None

    override def add(x: Option[X], y: Option[X]): Option[X] = (x, y) match
      case (None, _)          => y
      case (_, None)          => x
      case (Some(a), Some(b)) => Some(X.add(a, b))
