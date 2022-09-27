package `in`.rcard.lambdas

object Lambdas {

    // A lambda can be store in a variable (in Java, we can't)
    val plusOne = { x: Int -> x + 1 }
    val two = plusOne(1) // 2

    data class Person(val name: String, val age: Int)
    val people: List<Person> = listOf(Person("Alice", 29), Person("Bob", 31))

    // We can move lambdas outside the parentheses if the lambda is the last argument
    val joined = people.joinToString(separator = " ") { p: Person -> p.name } // "Alice Bob"
}
