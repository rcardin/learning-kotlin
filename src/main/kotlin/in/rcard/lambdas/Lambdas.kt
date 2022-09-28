package `in`.rcard.lambdas

object Lambdas {

    // A lambda can be store in a variable (in Java, we can't)
    val plusOne = { x: Int -> x + 1 }
    val two = plusOne(1) // 2

    data class Person(val name: String, val age: Int)
    val people: List<Person> = listOf(Person("Alice", 29), Person("Bob", 31))

    // We can move lambdas outside the parentheses if the lambda is the last argument
    val joined = people.joinToString(separator = " ") { p: Person -> p.name } // "Alice Bob"

    // Lambda with receiver
    // with
    fun alphabet(): String {
        val sb = StringBuilder()
        return with(sb) {
            for (letter in 'A'..'Z') {
                this.append(letter)
            }
            append("\nNow I know the alphabet!")
            this.toString()
        }
    }

    // apply
    // Similar to the with function, but it returns the object itself
    fun alphabet2(): String {
        val sb = StringBuilder()
        return sb.apply {
            for (letter in 'A'..'Z') {
                append(letter)
            }
            append("\nNow I know the alphabet!")
        }.toString()
    }
}
