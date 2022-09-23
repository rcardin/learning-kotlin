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
}
