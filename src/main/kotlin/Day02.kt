class Day02 : puzzle<Int>("Day02", 15, 12) {

    override fun part1(input: Input): Int {
        val mappedToPairs = input.map { combo -> Pair(combo.split(" ")[0], combo.split(" ")[1]) }
        return mappedToPairs.map { round ->
            calculateOutcome(round) + when (round.second) {
                "X" -> 1
                "Y" -> 2
                else -> 3
            }
        }.sum()
    }

    fun calculateOutcome(round: Pair<String, String>): Int {
        if (round.first == "A" && round.second == "Z" || round.first == "B" && round.second == "X" || round.first == "C" && round.second == "Y") {
            return 0
        } else if (round.first == "A" && round.second == "X" || round.first == "B" && round.second == "Y" || round.first == "C" && round.second == "Z") {
            return 3
        } else {
            return 6
        }
    }


    override fun part2(input: Input): Int {
        val mappedToPairs = input.map { combo -> Pair(combo.split(" ")[0], combo.split(" ")[1]) }

        return mappedToPairs.map{
                round -> calculatepcked(round) + when (round.second) {
                "X" -> 0
                "Y" -> 3
                else -> 6
            }
        }.sum()
    }

    fun calculatepcked(round : Pair<String,String>): Int {
        if (round.first == "A" && round.second == "Z" || round.first == "B" && round.second == "Y" || round.first == "C" && round.second == "X") {
            return 2
        } else if (round.first == "A" && round.second == "X" || round.first == "B" && round.second == "Z" || round.first == "C" && round.second == "Y") {
            return 3
        } else {
            return 1
        }
    }


}