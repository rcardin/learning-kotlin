package `in`.rcard.collections

object CollectionsTricks {
    val map = mapOf(1 to "one", 2 to "two", 3 to "three")
    // "to" is an infix function that creates a Pair, not a magical language construct

    // Sequences avoid intermediate collections and eager evaluation
    // Kotlin implements sequences because Java Streams are not available in Java versions
    // previous to 8
    val result = (1..1000000)
        .asSequence()
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .toList()
}
