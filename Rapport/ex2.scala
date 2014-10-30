def combine(left: HuffTree, right: HuffTree): HuffTree = 
  (Node((weight(left)+weight(right)),left,right))