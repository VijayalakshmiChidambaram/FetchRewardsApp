package com.example.fetchrewardsapp.data

import android.util.Log
import com.example.fetchrewardsapp.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getItems(): List<Item> {
        return try {
            val response = apiService.getItems()
            if (response.isSuccessful) {
                val items = response.body()?.filter { !it.name.isNullOrBlank() }
                    ?.sortedWith(compareBy({ it.listId }, { it.name })) ?: emptyList()
                items
            } else {
                emptyList()
            }
        } catch (e : Exception)
        {
            emptyList()
        }
    }
}