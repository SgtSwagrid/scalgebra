package io.github.sgtswagrid.structures
package evidence
package collection

/**
  * Evidence that [[Option]] forms a [[Semiring]] by lifting a [[Semiring]],
  * with [[None]] as zero and `Some([[one]])` as one.
  *
  * Adding two [[Some]] values combines their contents; [[None]] is the additive
  * identity. Multiplying two [[Some]] values multiplies their contents;
  * [[None]] absorbs multiplication on either side.
  */
trait OptionIsSemiring:

  given [X : Semiring as X]: Semiring[Option[X]] with

    override def zero: Option[X] = None

    override def one: Option[X] = Some(X.one)

    override def add(x: Option[X], y: Option[X]): Option[X] = (x, y) match
      case (None, _)          => y
      case (_, None)          => x
      case (Some(a), Some(b)) => Some(X.add(a, b))

    override def multiply(x: Option[X], y: Option[X]): Option[X] = (x, y) match
      case (None, _)          => None
      case (_, None)          => None
      case (Some(a), Some(b)) => Some(X.multiply(a, b))
