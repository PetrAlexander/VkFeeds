package com.example.vkfeeds.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.example.vkfeeds.presentation.feedposts.PostItem
import com.example.vkfeeds.presentation.feedposts.PostViewModel
import com.example.vkfeeds.presentation.theme.VkFeedsTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkFeedsTheme {
                val posts = viewModel.posts.collectAsState()
                LazyColumn(
                    contentPadding = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(items = posts.value, key = { it.id }) { post ->
                        PostItem(
                            post = post,
                            onCommentsClick = { option ->
                                viewModel.updatePostOption(post, option)
                            },
                            onViewsClick = { option ->
                                viewModel.updatePostOption(post, option)
                            },
                            onRepliesClick = { option ->
                                viewModel.updatePostOption(post, option)
                            },
                            onLikesClick = { option ->
                                viewModel.updatePostOption(post, option)
                            },
                        )
                    }
                }
            }
        }
    }
}