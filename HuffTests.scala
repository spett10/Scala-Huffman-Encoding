import Huffman._
import scala.collection.immutable.SortedSet
object HuffTests {

  def main(args: Array[String]) = {
	
   val str = "abbcccddddeeeee".toList
    val tree = createCodeTree(str)
    val encoded = encode(tree)(str)
    val decoded = decode(tree)(encoded)
    val codeta = convert(tree)
	println(str)
	println("")
	println(tree)
	println("")
	println(codeta)
	println("")
	println(encoded)
    println("")
	println(edTest(str))
    
	/* 
	//val x = Huffman.weight(Node(9,Node(7,Leaf('c',3),Leaf('b',4)),Leaf('c',2)))
	//println(x)
	
	val y = Node(9,Node(7,Leaf('c',3),Leaf('b',4)),Leaf('c',2))
	val z = Node(9,Node(7,Leaf('c',3),Leaf('b',4)),Leaf('c',2))
	val a = Node(4,Node(2,Leaf('c',1),Leaf('b',1)),Leaf('y',2))
	val tree1 = Huffman.combine(y,z)
	val tree2 = Huffman.combine(a,a)
	println(tree1)
	println("")
	println(tree2)
	println("")
	val t = SortedSet[HuffTree]()+tree1+tree2
	println("combineTrees:")
	println(combineTrees(t))
	println("")
	
	
	println(createCodeTree(buu))
	println("")
	val str = "ratata".toList
	println(createCodeTree(str))
	println("")
	val str1 = "r".toList
	println(createCodeTree(str1))
	val test1 = convert(tree1)
	val code1 = codeBits(test1)('r')
	val code2 = codeBits(test1)('d')
	//println(tree1)
	//println("")
	//println(test1)
	println("")
	println(code1)
	println("")
	println(code2)
	
	
	val buu = "abracadabra".toList
	val tree1 = createCodeTree(buu)
	val enc1 = encode(tree1)(buu)
	println(enc1)
	println(getLetter(tree1,enc1))
	
	*/
	//println(treebuu)
	//println("")
	
	//println(test1)

	//println("")
	
	//println(decode(treebuu)(enc1))
  }

  def edTest(str: List[Char]) = {
    val tree = createCodeTree(str)
    val encoded = encode(tree)(str)
    str == decode(tree)(encoded)
  }

}