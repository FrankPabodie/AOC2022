class Day04 : puzzle<Int>("Day04", 2, 4) {

    fun createPairs(input :List<String>): List<Pair<Pair<String, String>, Pair<String, String>>>{
        return input.map { pairOfElves -> pairOfElves.split(",").zipWithNext()[0] }
            .map { elf ->
                Pair(
                    elf.first.split("-").zipWithNext()[0],
                    elf.second.split("-").zipWithNext()[0] )
            }
    }

    override fun part1(input: Input): Int {
        val pairsOfRanges = createPairs(input)
        var count = 0
        pairsOfRanges.forEach { elfPair ->
            if ( elfPair.first.contains(elfPair.second)) {
                count +=1
            }
        }
        return count

    }

    fun Pair<String,String>.contains(compareWith :Pair<String,String>) : Boolean{
        return (this.first.toInt() >= compareWith.first.toInt() &&
            this.second.toInt() <= compareWith.second.toInt()) ||
            (this.first.toInt() <= compareWith.first.toInt() &&
            this.second.toInt() >= compareWith.second.toInt())
    }


    override fun part2(input: Input): Int {
        val pairsOfRanges = createPairs(input)
        var count = 0
        pairsOfRanges.forEach{ elfPairs ->
            if(((elfPairs.first.first.toInt() >= elfPairs.second.first.toInt() &&
                elfPairs.first.first.toInt() <= elfPairs.second.second.toInt()) ||
               (elfPairs.first.second.toInt() >= elfPairs.second.first.toInt() &&
                elfPairs.first.second.toInt() <= elfPairs.second.second.toInt()))   ||
                ((elfPairs.second.first.toInt() >= elfPairs.first.first.toInt() &&
                elfPairs.second.first.toInt() <= elfPairs.first.second.toInt()) ||
                (elfPairs.second.second.toInt() >= elfPairs.first.first.toInt() &&
                elfPairs.second.second.toInt() <= elfPairs.first.second.toInt()))
            ){
                count +=1
            }
        }
        return count


    }
}