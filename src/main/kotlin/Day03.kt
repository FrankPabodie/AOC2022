
class Day03 : puzzle<Int>("Day03", 157, 70) {

    override fun part1(input: Input): Int {
        val listOfStringPairs = input.map { item ->
            item.chunked(item.length / 2)
        }.map { Pair(it[0], "[${it[1]}]".toRegex()) }
        return listOfStringPairs.map {
            it.second.find(it.first)?.value?.get(0)
        }.sumOf {
            if (it!!.isLowerCase()) {
                it.code - 96
            } else {
                it.code - 38
            }
        }
    }

    override fun part2(input: Input): Int {
        val elfsGrouped = input.mapIndexed { index, s ->
            if ((index + 1) % 3 == 0) {
                  listOf(input[index - 2], input[index - 1],s)
            } else {null} }.filterNot { it.isNullOrEmpty() }
        return elfsGrouped.map { group ->
            var seq = ""
            "[${group!![0]}]".toRegex().findAll(group[1]).forEach { seq += it.value }
            "[$seq]".toRegex().find(group[2])?.value!![0]
        }.sumOf {
            if (it.isLowerCase()) {
                it.code - 96
            } else {
                it.code - 38
            }
        }
    }


}