fun main(args: Array<String>) {

    var turkey = WildTurkey()
    var duck = RubberDuck()
    var duckyTurkey = TurkeyAdapter(turkey)

    turkey.fly()
    duck.fly()
    duckyTurkey.fly()

    turkey.gobble()
    duck.quack()
    duckyTurkey.quack()

}

interface Duck {
    fun fly()
    fun quack()
}

interface Turkey {
    fun fly()
    fun gobble()
}

class WildTurkey: Turkey {

    override fun fly() {
        println("🦃 fly fly")
    }

    override fun gobble() {
        println("🐔gobble 🐔gobble")
    }
}

class TurkeyAdapter(var turkey: Turkey): Duck {

    override fun fly() {
        turkey.fly()
    }

    override fun quack() {
        turkey.gobble()
    }
}

class RubberDuck: Duck {

    override fun fly() {
        println("can not fly")
    }

    override fun quack() {
        println("🐥Quack 🐥Quack")
    }
}
