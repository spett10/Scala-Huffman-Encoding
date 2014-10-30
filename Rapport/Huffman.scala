import scala.collection.immutable.SortedSet

object Huffman {

  def ??? = throw new RuntimeException("Method not implemented...")

  /**
   * **************************
   * Part 1: Basics
   */
  def weight(tree: HuffTree): Int = tree match {
		case Leaf(char,vaegt) => vaegt
		case Node(vaegt,left,right) => vaegt
  }

  //Combine two HuffTrees into a single HuffTree
  def combine(left: HuffTree, right: HuffTree): HuffTree = 
  (Node((weight(left)+weight(right)),left,right))


  /**
   * **************************
   * Part 2: Generating the HuffTree
   */

  //Generate a list of (char,frequency) pairs.
  def frequencies(chars: List[Char]): List[(Char, Int)] = (
		chars.groupBy(w=>w).mapValues(_.size).toList	)
  
   //We use 'SortedSet' in place of a PriorityQueue because Scala currently
  //does not support an immutable implementation of PQ's. 
  //This is okay since no two trees are equivalent.
  def orderedLeaves(freqs: List[(Char, Int)]): SortedSet[HuffTree] =
    SortedSet[HuffTree](freqs.map(Function.tupled(Leaf)): _*)

  //Repeatedly combine the 2 smallest elements and reinsert in the SortedSet
  //to produce the final HuffTree (du kan reduce/fold SortedSet)
  //overvej en case til empty, selvom det ser ud til at virke uden
  def combineTrees(trees: SortedSet[HuffTree]): HuffTree = trees match {
		case x if x.size < 2 => trees firstKey 
		case x if x.size > 1 => 
		combineTrees((trees drop 2)+(combine(trees firstKey, (trees drop 1) firstKey)))
	}

  //Using 'frequencies', 'orderedLeaves', and 'combineTrees', create the HuffTree 
  def createCodeTree(chars: List[Char]): HuffTree = (
		combineTrees(orderedLeaves(frequencies(chars)))
		)

  /**
   * **************************
   * Part 3: Encoding and Decoding
   */
  type Bit = Int
  val One = 1
  val Zero = 0

  //To speed up encoding, let's use a hash-table
  type CodeTable = Map[Char, List[Bit]]
  
  //Convert HuffTree recursively to a codetable
  def convert(tree: HuffTree, acc: List[Bit] = Nil): CodeTable = tree match {
		case Leaf(char1,int) => 
				Map(char1 -> (acc reverse) )
		case Node(w,left,right) =>
				 convert(left,0 :: acc) ++ convert(right, 1 :: acc)
		}

  //Given 'table', return the bit-representation of 'char'
  def codeBits(table: CodeTable)(char: Char): List[Bit] = (
		table.getOrElse(char,Nil)
	)
  
  //Given a tree and an encoded bit-string, return the first character along with 
  //the remaining part of the bit-string
  //this also works for a tree of just a single leaf, since then theres no encoding!
  def getLetter(tree: HuffTree, bits: List[Bit]): (Char, List[Bit]) = tree match{
		case Leaf(char,int) => 
			(char,bits)
		case Node(w,l,r) => 
			if(bits.head == 0)
				getLetter(l,bits.drop(1)) //read 0, go left, subtract 0 from bits
			else  
				getLetter(r,bits.drop(1))
  }
  
  //Use a CodeTable to encode a text
  def encode(tree: HuffTree)(text: List[Char]): List[Bit] = {
		val blazeit = convert(tree) 
		text.flatMap(x =>codeBits(blazeit)(x))
	}
  
  //Using 'getLetter', decode 'bits' using a HuffTree
  //brug getLetter indtil listen er tom. Pattern matching paa bits?
  def decode(tree: HuffTree)(bits: List[Bit]): List[Char] = bits match {
		case Nil => Nil
		case _ => 
			val (char,remain) = getLetter(tree,bits) //getletter returnerer tuple!
			char :: decode(tree)(remain)			//sidste evaluering er vores return
  }
  
  
  
}
