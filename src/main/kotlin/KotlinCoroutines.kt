import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() { // Executes in main thread
    println("Main program starts: ${Thread.currentThread().name}") // Main thread

    GlobalScope.launch { // Thread: T1
        println("Fake work starts: ${Thread.currentThread().name}") // Thread: T1
        delay(1000) // Coroutine is suspended but Thread: T1 is free (not blocked)
        println("Fake work finished: ${Thread.currentThread().name}") // Either T1 or some other thread.
    }

    // Blocks the current main thread & wait for coroutine to finish (practically not a right way to wait)
    Thread.sleep(2000)
    println("Main program ends: ${Thread.currentThread().name}") // Main thread
}
