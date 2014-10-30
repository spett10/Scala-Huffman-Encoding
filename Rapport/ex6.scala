def convert(tree: HuffTree, acc: List[Bit] = Nil): CodeTable = tree match {
	case Leaf(char1,int) => 
		Map(char1 -> (acc reverse) )
	case Node(w,left,right) =>
		 convert(left,0 :: acc) ++ convert(right, 1 :: acc)
	}