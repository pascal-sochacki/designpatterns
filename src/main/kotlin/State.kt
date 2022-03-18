fun main(args: Array<String>) {
    var test = Document()
    test.publish()
    test.publish()
    test.goBack()
    test.goBack()

    test.publish()
    test.publish()

    test.printStates()

}

class Document {
    private var state: State = Draft(this)
    private var states: List<State> = mutableListOf(this.state)

    fun review(isUser: Boolean) {
        state.review()
    }

    fun publish () {
        state.publish()
    }

    fun printStates() {
        states.forEach {
            println(it.toString())
        }
    }

    fun goBack() {
        if (states.size > 1) {
            this.states = states.dropLast(1)
            state = states.last()
        }
    }

    fun changeState(state: State) {
        this.state = state
        this.states += this.state
    }
}

interface State {

    fun review()
    fun publish()
}

class Draft(private val document: Document) : State {

    override fun review() {
        println("Draft.review()")
    }

    override fun publish() {
        println("Draft.publish()")
        this.document.changeState(Moderation(this.document))
    }
}

class Moderation(private val document: Document) : State {

    override fun review() {
        println("Moderation.review()")
    }

    override fun publish() {
        println("Moderation.publish()")
        this.document.changeState(Published(this.document))
    }
}

class Published(private val document: Document) : State {

    override fun review() {
        println("Published.review()")
    }

    override fun publish() {
        println("Published.publish()")
    }
}
