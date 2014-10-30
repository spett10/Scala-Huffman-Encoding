val buu = "abracadabra".toList
val tree1 = createCodeTree(buu)
val test1 = convert(tree1)
val code1 = codeBits(test1)('r')
val code2 = codeBits(test1)('d')
println("")
println(code1)
println("")
println(code2)