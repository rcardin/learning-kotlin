package `in`.rcard.generics

object Generics {

    // Generic with a type parameter not allowing null values
    class Processor<T : Any> {
        fun process(value: T) {
            value.hashCode()
        }
    }

    // Generic with more than one type parameter constraint
    class Processor2<T> where T : Comparable<T>, T : Appendable {
        fun process(value: T) {
            value.append("!")
        }
    }

    // Reified type parameters on inline functions
    inline fun <reified T> isA(value: Any) = value is T
}
