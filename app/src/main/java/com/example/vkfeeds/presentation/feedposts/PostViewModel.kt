package com.example.vkfeeds.presentation.feedposts

import androidx.lifecycle.ViewModel
import com.example.vkfeeds.domain.Option
import com.example.vkfeeds.domain.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PostViewModel: ViewModel() {

    private val _posts = MutableStateFlow(listOf(Post(), Post(id = 1), Post(id = 2)))
    val posts: StateFlow<List<Post>> = _posts

    fun updatePostOption(post: Post, option: Option) {
        val oldPosts = _posts.value
        val oldOptions = post.options
        val newOptions = oldOptions.toMutableList().apply {
            replaceAll { oldOption ->
                if (oldOption.type == option.type) {
                    oldOption.copy(value = oldOption.value + 1)
                } else oldOption
            }
        }
        val newPost = post.copy(options = newOptions)
        val newPosts = oldPosts.toMutableList().apply {
            replaceAll { oldPost ->
                if (oldPost.id == newPost.id) {
                    newPost
                } else oldPost
            }
        }
        _posts.value = newPosts
    }
}