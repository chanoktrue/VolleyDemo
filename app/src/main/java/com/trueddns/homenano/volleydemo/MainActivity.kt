package com.trueddns.homenano.volleydemo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.trueddns.homenano.volleydemo.models.Posts
import com.trueddns.homenano.volleydemo.shared.Shared
import com.trueddns.homenano.volleydemo.viewmodels.PostsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var context: Context = LocalContext.current
            Shared.context = context

            HomeView()

        }
    }
}

@Composable
fun HomeView() {

    val viewModle: PostsViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        HomeListView(viewModle)
    }
}

@Composable
private fun HomeListView(viewModel: PostsViewModel) {
    LazyColumn {
        item(viewModel.posts.none()) {
            viewModel.posts.forEach { post ->
                HomeCardView(post = post)
            }
        }
    }
}

@Composable
private fun HomeCardView(post: Posts) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "title: ${post.title}", modifier = Modifier.padding(bottom = 4.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray)
            )

            Text(text = "body: ${post.body}", modifier = Modifier.padding(top = 4.dp))
        }
    }
}