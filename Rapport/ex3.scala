 def frequencies(chars: List[Char]): List[(Char, Int)] = (
		chars.groupBy(w=>w).mapValues(_.size).toList	)