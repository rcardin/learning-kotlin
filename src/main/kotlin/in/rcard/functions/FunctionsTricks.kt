package `in`.rcard.functions

const val MAX = 100 // This is a constant

fun thisIsAStaticFunction() = println("This is a static function") // Available as a static function

object FunctionsTricks {
    fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ", // <-- This is a default value that avoids the overloading
        prefix: String = "",
        postfix: String = ""
    ): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    // This is an extension function
    // In Java, it is compiled as a static function taking an Int as the first argument.
    // WARN: We can't override an extension function
    private fun Int.isOdd(): Boolean = this % 2 != 0

    val odd = 2.isOdd()

    // We can also have extension properties
    var java.lang.StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value) {
            this.setCharAt(length - 1, value)
        }

    infix fun Int.sum(other: Int) = this + other // Infix extension function 🎉

    val three = 1 sum 2

    // Functions can be declared as local functions
    class User(val id: Int, val name: String, val address: String)
    fun saveUser(user: User) {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can't save user ${user.id}: empty $fieldName")
            }
        }
        validate(user.name, "Name")
        validate(user.address, "Address")

        // Save user to the database
    }

    class Person(val firstName: String, val lastName: String, val age: Int) {
        companion object {
            fun create(firstName: String, lastName: String, age: Int) = Person(firstName, lastName, age)
        }
    }

    // We can also have extension functions for companion objects
    fun Person.Companion.fromJSON(json: String): Person {
        TODO()
    }
}
