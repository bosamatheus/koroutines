import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // Creates a coroutine that blocks the current main thread
    println("Main program starts: ${Thread.currentThread().name}") // Main thread

    GlobalScope.launch { // Thread: T1
        println("Fake work starts: ${Thread.currentThread().name}") // Thread: T1
        delay(1000) // Coroutine is suspended but Thread: T1 is free (not blocked)
        println("Fake work finished: ${Thread.currentThread().name}") // Either T1 or some other thread
    }

    delay(2000) // Main thread: wait for coroutine to finish
    println("Main program ends: ${Thread.currentThread().name}") // Main thread
}
