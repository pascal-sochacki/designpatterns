fun main(args: Array<String>) {
    val porsche = Fahrzeug()
    val krasserPorsche = ZeugUpgrade(porsche)
    val megaPorsche = MegaZeugUpgrade(porsche)

    krasserPorsche.goToTheMoon()
    megaPorsche.goToTheEndOfTheMilkyWay()
}

interface Zeug {
    fun move(distance: Int)
}

class Flugzeug : Zeug {
    override fun move(distance: Int) {
        println("flieg flieg $distance Lichtjahre")
    }

}

class Fahrzeug : Zeug {
    override fun move(distance: Int) {
        println("fahr fahr ${distance*2} Meter")
    }

}

open class ZeugUpgrade(private val zeug: Zeug) {

    open fun goToTheMoon() {
        zeug.move(10)
    }

}

class MegaZeugUpgrade(private val zeug: Zeug) : ZeugUpgrade(zeug) {

    fun goToTheEndOfTheMilkyWay() {
        zeug.move(1000)
    }

}


