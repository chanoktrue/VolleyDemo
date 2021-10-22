package com.trueddns.homenano.volleydemo.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trueddns.homenano.volleydemo.models.Posts
import com.trueddns.homenano.volleydemo.services.GetJson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostsViewModel: ViewModel() {

    var posts = mutableStateListOf<Posts>()

    init {
        viewModelScope.launch {
            kotlin.runCatching {
                GetJson.getJson {
                    posts.clear()
                    posts.addAll(it)
                }
            }
        }
    }


}