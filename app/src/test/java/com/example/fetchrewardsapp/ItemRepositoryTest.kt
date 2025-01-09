package com.example.fetchrewardsapp

import com.example.fetchrewardsapp.data.ApiService
import com.example.fetchrewardsapp.data.ItemRepository
import com.example.fetchrewardsapp.model.Item
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

class ItemRepositoryTest {
    private val apiService: ApiService = mock()
    private val repository = ItemRepository(apiService)

    @Test
    fun `getItems filters null or empty names and sort by listID and name` () = runBlocking {
        val mockResponse = listOf(
            Item("ItemA", 1),
            Item("ItemB", 2),
            Item("ItemC", 2),
            Item("ItemD", 1),
            Item("ItemE", 2),
            Item(null, 1),
            Item("", 3),
            )
        whenever(apiService.getItems()).thenReturn(Response.success(mockResponse))

        val result = repository.getItems()

        val expected = listOf(
            Item("ItemA", 1),
            Item("ItemD", 1),
            Item("ItemB", 2),
            Item("ItemC", 2),
            Item("ItemE", 2))

        assertEquals(expected, result)
    }

    @Test(expected = Exception::class)
    fun `getItems throws exception when API response is unsuccessful` (): Unit = runBlocking {
        whenever(apiService.getItems()).thenReturn(Response.error(404, mock()))

        repository.getItems()
    }

}