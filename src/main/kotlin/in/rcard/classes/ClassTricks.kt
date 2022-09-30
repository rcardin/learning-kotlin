package `in`.rcard.classes

object ClassTricks {

    class Rectangle(val height: Int, val width: Int) {
        // Custom property
        val isSquare: Boolean
            get() {
                return height == width
            }
    }

    enum class Color {
        RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
    }

    // Use of the `when` expression with enums
    fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

    fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.YELLOW) ||
                (c1 == Color.YELLOW && c2 == Color.RED) ->
                Color.ORANGE

            (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                (c1 == Color.BLUE && c2 == Color.YELLOW) ->
                Color.GREEN

            (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE) ->
                Color.INDIGO

            else -> throw Exception("Dirty color")
        }

    // Tripled quoted strings can be multiline and they don't need escaping
    val html = """
        <html>
            <body>
                <p>Hello, world!</p>
            </body>
        </html>
    """.trimIndent()

    // Methods in classes are "final" by default
    // Also classes are defined as "final" by default

    // Classes visibility in Kotlin is public by default
    // -------------------------------------------------
    // public (default) | Visible everywhere
    // internal         | Visible inside the same module (in Java compiles into "public" 🤷‍)
    // protected        | Visible inside the same class and subclasses
    // private          | Visible inside the same file

    // sealed classes are used to restrict the inheritance of a class
    // All subclasses of a sealed class must be declared in the same file
    // Interesting reading about sealed interfaces: https://jorgecastillo.dev/sealed-interfaces-kotlin

    // Private constructors
    class Secretive private constructor()

    // Data classes has a built-in copy method, since they are immutable by default
    data class User(val name: String, val age: Int)

    val rcardin = User("Rcardin", 26)
    val rcardinWithRealAge = rcardin.copy(age = 40) // :(

    // Decorators/Delegation is a first-class citizen in Kotlin
    interface Base {
        fun print()
        // And many other methods
    }

    class BaseImpl(val x: Int) : Base {
        override fun print() {
            print(x)
        }
        // And many other methods implemented
    }

    class Decorated(val b: BaseImpl) : Base by b {
        override fun print() {
            print("Decorated: ${b.x}")
        }
    }

    // We use the object keyword to create an anonymous inner class
    // window.addMouseListener(object : MouseAdapter() {
    //     override fun mouseClicked(e: MouseEvent) {
    //        // ...
    //     }
    //     override fun mouseEntered(e: MouseEvent) {
    //        // ...
    //     }
    // })

    // Kotlin has deconstruction
    // val (name, age) = rcardin
    // Under the hood, the compiler generates the following code:
    // val name = rcardin.component1()
    // val age = rcardin.component2()

    // Delegated properties
    class Person(val name: String) {
        val emails by lazy { loadEmails(this) }

        private fun loadEmails(person: Person) {
            TODO("Not yet implemented")
        }
    }
}
