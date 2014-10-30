def encode(tree: HuffTree)(text: List[Char]): List[Bit] = {
	val blazeit = convert(tree) 
	text.flatMap(x =>codeBits(blazeit)(x))
}