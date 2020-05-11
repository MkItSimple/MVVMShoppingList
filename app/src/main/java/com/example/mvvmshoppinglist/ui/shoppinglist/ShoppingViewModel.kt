package com.example.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglist.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglist.repositories.ShoppingRepository
import kotlinx.coroutines.*

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel() {

    fun upsert(item: ShoppingItem) =
        CoroutineScope(Dispatchers.Main).launch {
            repository.upsert(item)
        }

    fun delete(item: ShoppingItem) =
        CoroutineScope(Dispatchers.Main).launch {
            repository.delete(item)
        }

    // no need to use coroutine because its  only a read operation
    fun getAllShoppingItems() = repository.getAllShoppingItems()

//    fun upsert(item: ShoppingItem) =
//        GlobalScope.launch {
//            repository.upsert(item)
//        }
//
//    fun delete(item: ShoppingItem) = GlobalScope.launch {
//        repository.delete(item)
//    }
//
//    fun getAllShoppingItems() = repository.getAllShoppingItems()

}