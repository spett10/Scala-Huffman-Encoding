def weight(tree: HuffTree): Int = tree match {
		case Leaf(char,vaegt) => vaegt
		case Node(vaegt,left,right) => vaegt
  }