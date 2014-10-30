 def orderedLeaves(freqs: List[(Char, Int)]): SortedSet[HuffTree] =
    SortedSet[HuffTree](freqs.map(Function.tupled(Leaf)): _*)

def createCodeTree(chars: List[Char]): HuffTree = (
		combineTrees(orderedLeaves(frequencies(chars)))
		)