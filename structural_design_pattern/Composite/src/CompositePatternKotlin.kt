import org.junit.Test

/**
 * Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
 */

class CompositePatternKotlin {

    @Test
    fun factoryMethod() {
        println("Composite pattern applied to genealogical tree")

        val a = Children("Alessandro")
        println(a.getGenealogicalTree())

        val b = Children("Francesco")
        println(b.getGenealogicalTree())

        val c = Children("Maria")
        println(c.getGenealogicalTree())

        val d = Father("Stefano", listOf(a,b,c))
        println(d.getGenealogicalTree())

        val e = Father( "Adamo", listOf(d))
        println(e.getGenealogicalTree())

    }

}

interface Human {
    fun getGenealogicalTree(): String
}

/** "Leaf" */
class Children constructor(private val name:String) : Human {
    //Prints the graphic.
    override fun getGenealogicalTree(): String {
        return name
    }
}

/** "Father" */

class Father constructor(private val name:String, private val sons:List<Human>) : Human {
    //Prints the graphic.
    override fun getGenealogicalTree(): String {
        var a = name
        a+=" { "
        sons.forEach{
            a+=" "+it.getGenealogicalTree()
        }
        a+=" } "
        return a
    }
}