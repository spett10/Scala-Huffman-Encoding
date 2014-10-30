import Huffman._

abstract class HuffTree
case class Node(weight:Int,left: HuffTree, right: HuffTree) extends HuffTree
case class Leaf(char: Char, weight: Int) extends HuffTree

//Dirty hack to make HuffTrees comparable. Don't worry about it!
object HuffTree {
  implicit object HuffOrd extends Ordering[HuffTree] {
    def compare(a: HuffTree, b: HuffTree) = {
      val comp = weight(a) compare weight(b)
      if (comp == 0) -1 else comp
    }
  }
}