def decode(tree: HuffTree)(bits: List[Bit]): List[Char] = bits match {
	case Nil => Nil
	case _ => 
		val (char,remain) = getLetter(tree,bits) 
		char :: decode(tree)(remain)			
  }