def codeBits(table: CodeTable)(char: Char): List[Bit] = (
		table.getOrElse(char,Nil)
	)