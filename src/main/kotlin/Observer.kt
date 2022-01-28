fun main(args: Array<String>) {
    val sensor1 = WeatherSensor()

    val monitor = Monitor()
    val alarm = FireAlarm()

    monitor.subscribeToSensor(sensor1)
    alarm.subscribeToSensor(sensor1)

    sensor1.changeTemperature(20)

    sensor1.changeTemperature(1000)
}

abstract class Observer {


    abstract fun update(temperature: Int);

    abstract fun somethingChangedDude(weatherSensor: WeatherSensor);

    fun subscribeToSensor(sensor: WeatherSensor) {
        sensor.subscribeObserver(this)
    }
}

class Monitor : Observer() {

    override fun update(temperature: Int) {
        println("Temperature is $temperature")
    }

    override fun somethingChangedDude(weatherSensor: WeatherSensor) {
        println("Something changed dude")
        println("Temperature is ${weatherSensor.temperature()}")
    }

}

class FireAlarm : Observer() {

    override fun update(temperature: Int) {

    }

    override fun somethingChangedDude(weatherSensor: WeatherSensor) {
        if (weatherSensor.temperature() > 100) {
            println("Fire alarm activated")
        }
    }

}

class WeatherSensor {
    private var subscribers: List<Observer> = listOf()
    private var temperature: Int = 0

    fun changeTemperature(temperature: Int) {
        this.temperature = temperature
        println("Temperature changed to $temperature")

        for (observer: Observer in subscribers) {
            observer.update(temperature)
        }
        //subscribers.forEach { monitor -> monitor.displayTemperature(temperature) }
    }

    fun subscribeObserver(observer: Observer) {
        subscribers = subscribers.plus(observer)
    }

    fun temperature(): Int {
        return temperature
    }
}
