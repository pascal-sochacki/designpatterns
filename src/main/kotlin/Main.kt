fun main(args: Array<String>) {

    val milk = Milk(Coffee())
    milk.expire()

    val doubleMilk = Milk(milk)

    print(doubleMilk.cost())

    doubleMilk.ingredients().map { it.getDescription() }.forEach { println(it) }


}

interface Beverage {
    fun ingredients(): List<Beverage>
    fun getDescription(): String
    fun cost(): Double
}

class Coffee : Beverage {
    override fun ingredients(): List<Beverage> {
        return listOf(this)
    }

    override fun getDescription(): String {
        return "Coffee"
    }

    override fun cost(): Double {
        return 1.5
    }

}

interface BeverageDecorator : Beverage {

    override fun getDescription(): String
    override fun cost(): Double
}

class Milk(val beverage: Beverage) : BeverageDecorator {

    var expired = false

    override fun ingredients(): List<Beverage> {
        return beverage.ingredients().plus(this)
    }

    override fun getDescription(): String {
        return "Milk"
    }

    override fun cost(): Double {
        return if (expired) {
            0.0
        } else {
            beverage.cost() + 0.5
        }
    }

    fun expire() {
        println("Milk is expire")
        expired = true
    }
}

class CoffeeMachine {
    fun makeCoffee(beverage: Beverage) {
        println("Making a cup of ${beverage.getDescription()}")
        println("It will cost ${beverage.cost()}")
    }
}
