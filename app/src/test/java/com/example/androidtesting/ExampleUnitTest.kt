package com.example.androidtesting

import com.example.androidtesting.network.RetrofitHttp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkStatusCode() {
        val response = RetrofitHttp.postService.listPost().execute()
        assertEquals(response.code(), 200)
    }

    @Test
    fun responseIsSuccessful() {
        val response = RetrofitHttp.postService.listPost().execute()
        assertTrue(response.isSuccessful)
    }

    @Test
    fun checkPostListNotNull() {
        val response = RetrofitHttp.postService.listPost().execute()
        assertNotNull(response.body())
    }
}