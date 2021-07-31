import org.junit.Test
/**
 * Define an interface for creating a single object, but let subclasses decide which class to instantiate.
 * Factory Method lets a class defer instantiation to subclasses.
 */

interface sushiInterface {
    fun getIngredients(): List<String>
}

enum class SushiType {
    SASHIMI,
    NIGIRI
}

class Nigiri : sushiInterface {
    override fun getIngredients(): List<String> {
        return arrayListOf("rice", "avocado")
    }
}

class Sashimi : sushiInterface {
    override fun getIngredients(): List<String> {
        return arrayListOf("salmon")
    }
}

object SushiRestaurantFactory {
    fun getSushi(type: SushiType): sushiInterface {
        return when (type) {
            SushiType.SASHIMI -> {
                Nigiri()
            }
            SushiType.NIGIRI -> {
                Sashimi()
            }
        }
    }
}

class FactoryMethodKotlin {

    @Test
    fun factoryMethod() {
        println("Factory pattern applied to sushi")
        val order1 = SushiRestaurantFactory.getSushi(SushiType.NIGIRI)
        println(order1.getIngredients().toString())

        val order2 = SushiRestaurantFactory.getSushi(SushiType.SASHIMI)
        println(order2.getIngredients().toString())
    }

}