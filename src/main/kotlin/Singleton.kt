fun main(args: Array<String>) {
    val instance = Singleton.getInstance()
    instance.count()
    instance.printState()
    val instance2 = Singleton.getInstance()
    instance2.count()
    instance2.printState()
}

class Singleton private constructor(){

    private var count = 0

    init {
        println("Singleton init")
    }

    fun count() {
        count += 1
    }

    fun printState() {
        println(count)
    }

    companion object {

        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }
            return instance!!
        }
    }


}
