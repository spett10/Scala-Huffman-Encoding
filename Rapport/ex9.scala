def getLetter(tree: HuffTree, bits: List[Bit]): (Char, List[Bit]) = tree match{
	case Leaf(char,int) => 
		(char,bits)
	case Node(w,l,r) => 
		if(bits.head == 0)
			getLetter(l,bits.drop(1)) 
		else  
			getLetter(r,bits.drop(1))