import java.awt.CardLayout
import java.text.BreakIterator

class Day05:puzzle<Int>("Day05",0,0) {
    override fun part1(input: Input): Int    {
        var stacks = createStacks(input)
        print(stacks)
        return 0
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


    override fun part2(input: Input): Int {
        return 0
    }

}