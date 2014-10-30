val str = "cocoon".toList
val tree = createCodeTree(str)
val encoded = encode(tree)(str)
val decoded = decode(tree)(encoded)
val codeta = convert(tree)
println(str)
println(tree)
println(codeta)
println(encoded)
println(edTest(str))

def edTest(str: List[Char]) = {
    val tree = createCodeTree(str)
    val encoded = encode(tree)(str)
    str == decode(tree)(encoded)
  }