val buu = "abracadabra".toList
val tree1 = createCodeTree(buu)
val enc1 = encode(tree1)(buu)
println(enc1)
println(getLetter(tree1,enc1))