fun main(args: Array<String>) {
    var store = PizzaStore(SimplePizzaFactory())

    var pizza = store.createPizza("cheese")
    println(pizza.name)

}

interface PizzaFactory {
    fun createPizza(type: String): Pizza
}

class NYStylePizza() : Pizza() {

    init {
        name = "NY Style Sauce and Cheese Pizza"
        dough = "Thin Crust Dough"
        sauce = "Marinara Sauce"
        toppings.plus("Grated Reggiano Cheese");
    }

}

class PizzaStore(factory: PizzaFactory) {

    private var factory: PizzaFactory = factory

    fun createPizza(type: String): Pizza {
        val pizza = factory.createPizza(type)
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
        return pizza
    }
}

class SimplePizzaFactory: PizzaFactory {

    override fun createPizza(type: String): Pizza {
        return when (type) {
            "cheese" -> NYStylePizza()
            else -> ChicagoStylePizza()
        }
    }
}

class ChicagoStylePizza() : Pizza() {
    init {
        name = "Chicago Style Deep Dish Cheese Pizza"
        dough = "Extra Thick Crust Dough"
        sauce = "Plum Tomato Sauce"
        toppings.plus("Shredded Mozzarella Cheese");
    }
}


open class Pizza {
    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    var toppings: List<String> = listOf();

    fun prepare() {
        println("Preparing $name")
        println("Tossing dough...")
        println("Adding sauce...")
        println("Adding toppings:")
        for (topping in toppings) {
            println("   $topping")
        }
    }

    fun bake() {
        println("Bake for 25 minutes at 350")
    }

    fun cut() {
        println("Cutting the pizza into diagonal slices")
    }

    fun box() {
        println("Place pizza in official PizzaStore box")
    }


}
