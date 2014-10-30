 def combineTrees(trees: SortedSet[HuffTree]): HuffTree = trees match {
	case x if x.size < 2 => trees firstKey 
	case x if x.size > 1 => 
	combineTrees((trees drop 2)+
	(combine(trees firstKey, (trees drop 1) firstKey)))
	}