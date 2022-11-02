package com.siksin.countdownex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.selects.select
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

val counterContext = newSingleThreadContext("CounterContext")
var counter = 0

suspend fun massiveRun(context: CoroutineContext, action: suspend ( ) -> Unit) {
    val n = 1000
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n) {
            GlobalScope.launch(context) {
                repeat(k) {action( )}
            }
        }
        jobs.forEach{ it.join() }
    }
    println("Completed ${n * k} actions in $time ms")
}

fun main( ) = runBlocking<Unit> {
    massiveRun(counterContext) {
            counter++
    }
    println("Counter = $counter")
}