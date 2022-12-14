class Day05:puzzle<String>("Day05","CMZ","fas") {
    override fun part1(input: Input): String {
        var stacks = createStacks(input)
        val listOfMovesTrans = input.dropWhile { it != "" }.filter { it.isNotBlank() }
            .map { command -> command.split("move ", " from ", " to ").filter { it.isNotBlank() } }
        listOfMovesTrans.forEach {
            println(it)
            stacks = moveFromTo(stacks, it[0].toInt(), it[1].toInt() -1 , it[2].toInt() -1)
        }
        return stacks.map { it.first() }.joinToString()
    }

    fun moveFromTo(stacks: List<MutableList<Char>>, amount: Int, from : Int, to: Int): List<MutableList<Char>> {
        println(stacks)
        var stackNew = stacks.toMutableList()
        for (i in 1..amount) {
            val charFrom = stackNew[from].removeFirstOrNull()
            if (charFrom != null) {
                stackNew = stackNew.map{
                    if(stackNew.indexOf(it) == to) { print("here")
                        (mutableListOf<Char>(charFrom) + stackNew[to]).toMutableList()}
                else {it}
                }.toMutableList()
            }
        }
        println(stacks)
        return stacks
    }

    fun createStacks(input: List<String>): List<MutableList<Char>>{
        val stacks = mutableListOf<MutableList<Char>>()
        for(i in 0 .. 20){ stacks.add(mutableListOf())}
        var count= 0
        while (input[count+1].isNotBlank()){
            for (i in input[count].indices) {
                if ((i+3) % 4  == 0 && input[count][i].toString() != " "){ stacks[(i+3)/4].add(input[count][i])}
            }
            count +=1
        }
        return stacks.filter { it.isNotEmpty()}
    }


    override fun part2(input: Input): String{
        return " fas"
    }

}