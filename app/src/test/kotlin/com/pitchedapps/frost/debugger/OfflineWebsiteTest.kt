package com.pitchedapps.frost.debugger

import com.pitchedapps.frost.facebook.FB_URL_BASE
import com.pitchedapps.frost.internal.COOKIE
import org.junit.Test
import java.io.File
import java.util.concurrent.CountDownLatch

/**
 * Created by Allan Wang on 05/01/18.
 */
class OfflineWebsiteTest {

    @Test
    fun basic() {
        val countdown = CountDownLatch(1)
        OfflineWebsite(FB_URL_BASE, COOKIE, File("app/build/offline_test"))
                .loadAndZip("test") {
                    println("Outcome $it")
                    countdown.countDown()
                }
        countdown.await()
    }

}