fun main(args: Array<String>) {
    val bobTheBuilder = Bob.builder()
        .withName("Bob")
        .build()

    println(bobTheBuilder.job == "Builder")
    println("Name: " + bobTheBuilder.name)
    println("Job: " + bobTheBuilder.job)
}

class BobBuilder {

    private var name: String? = null
    private var job: String? = null

    fun withName(name: String): BobBuilder {
        this.name = name
        return this
    }

    fun withJob(job: String): BobBuilder {
        this.job = job
        return this
    }

    fun build(): Bob {
        return Bob(this.name, this.job)
    }
}

class Bob(var name: String?, var job: String?) {

    companion object {
        fun builder(): BobBuilder {
            return BobBuilder()
        }
    }

    fun salutation(): String {
        return "$name the $job"
    }

}
