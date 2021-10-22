package com.trueddns.homenano.volleydemo.services

import android.content.Context
import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.trueddns.homenano.volleydemo.models.Posts
import com.trueddns.homenano.volleydemo.shared.Shared
import org.json.JSONObject

object GetJson {

    suspend fun getJson(completion: (List<Posts>) -> Unit)  {

        val url = "https://jsonplaceholder.typicode.com/posts"

        var models: List<Posts> =  ArrayList<Posts>()

        var queue = Volley.newRequestQueue(Shared.context)

        var request = JsonArrayRequest(Request.Method.GET, url, null, { resonse ->

            val gson = GsonBuilder().create()
            models = gson.fromJson(resonse.toString(), Array<Posts>::class.java).toList()

            completion(models)

        }, { error ->

        })

        queue.add(request)

    }

}