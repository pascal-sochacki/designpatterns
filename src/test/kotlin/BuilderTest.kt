import org.junit.jupiter.api.Test

class BuilderTest {

    @Test
    fun should_give_bob_a_name() {
        val bob = Bob.builder().withName("Bob").build()
        assert(bob.name == "Bob")
    }

    @Test
    fun should_give_bob_a_job() {
        val bob = Bob.builder().withJob("Builder").build()
        assert(bob.job == "Builder")
    }

    @Test
    fun should_give_bob_everything_he_needs_to_be_happy_for_the_rest_of_his_life() {
        val bob = Bob.builder().withName("Bob").withJob("Builder").build()
        assert(bob.salutation() == "Bob the Builder")
    }
}
