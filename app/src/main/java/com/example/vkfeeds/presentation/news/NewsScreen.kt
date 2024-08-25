package com.example.vkfeeds.presentation.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp

@Composable
fun NewsScreen(
    viewModel: PostViewModel
) {
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
                }
            )
        }
    }
}