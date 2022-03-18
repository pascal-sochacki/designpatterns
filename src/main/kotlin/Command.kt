fun main(args: Array<String>) {
    Remote(ConsolePrinter(), TurnOffConsolePrinter()).turnOn()
}

interface Command {

    fun execute()
}

class ConsolePrinter: Command {

    override fun execute() {
        println("turn_on")
    }
}

class TurnOffConsolePrinter: Command {

    override fun execute() {
        println("turn_off")
    }
}

class Remote(private var turn_on_command: Command, private var turn_off_command: Command) {

    fun turnOn() {
        turn_on_command.execute()
    }

    fun turnOff() {
        turn_off_command.execute()
    }

    fun executeCommand(command: Command) {
        command.execute()
    }

}
