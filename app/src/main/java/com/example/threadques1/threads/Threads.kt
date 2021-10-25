package com.example.threadques1.threads

import java.lang.Exception

fun main(args :Array<String>){
    var th1 : Thread = Thread(Threads())
    println("This is thread1 : "+ th1.start())

    var th2 : Thread = Thread(Threads())
    println("This is thread1 : "+ th2.start())

    var th3 : Thread = Thread(Threads())
    println("This is thread1 : "+ th3.start())

    try {
        th1.join()
        th2.join()
        th3.join()
    }
    catch (e:Exception){}


}
class Threads: Runnable {
    public override fun run() {
        println("${Thread.currentThread()} has run.")

        try {
            for (i in 1..5)
            {
                println("Hi, I am "+i)
                Thread.sleep(300)
            }
            println("End")
        }
        catch (e:Exception)
        {}
    }


}
