
class Day01 : puzzle<Int>("Day01", 24000, 45000) {

    override fun part1(input: Input) = input.split { it.isBlank() }.map { it.sumOf { it.toInt() } }.max()

    override fun part2(input: Input) = input.split { it.isBlank() }.map { it.sumOf { it.toInt() } }.sorted().takeLast(3).sumOf { it }

    fun <T> List<T>.split(predicate: (T) -> Boolean): List<List<T>> =
        fold(mutableListOf(mutableListOf<T>())) { acc, t ->
            if (predicate(t)) acc.add(mutableListOf())
            else acc.last().add(t)
            acc
        }.filterNot { it.isEmpty() }
}