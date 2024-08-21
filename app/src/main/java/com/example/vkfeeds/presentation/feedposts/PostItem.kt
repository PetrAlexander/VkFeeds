package com.example.vkfeeds.presentation.feedposts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Comment
import androidx.compose.material.icons.automirrored.rounded.Reply
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkfeeds.domain.Option
import com.example.vkfeeds.domain.OptionType
import com.example.vkfeeds.domain.Post
import com.example.vkfeeds.utils.getOptionByType

@Composable
fun PostItem(
    post: Post,
    onCommentsClick: (Option) -> Unit,
    onViewsClick: (Option) -> Unit,
    onRepliesClick: (Option) -> Unit,
    onLikesClick: (Option) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FeedPostHeader(post.groupName, post.time)
            FeedPostContent(post.description)
            FeedPostOptions(
                post.options,
                onCommentsClick,
                onViewsClick,
                onRepliesClick,
                onLikesClick,
            )
        }
    }
}

@Composable
private fun FeedPostHeader(
    name: String,
    time: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = name,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = time,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
private fun FeedPostContent(
    description: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = description)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
                .background(Color.Yellow)
        )
    }
}

@Composable
private fun FeedPostOptions(
    options: List<Option>,
    onCommentsClick: (Option) -> Unit,
    onViewsClick: (Option) -> Unit,
    onRepliesClick: (Option) -> Unit,
    onLikesClick: (Option) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val views = options.getOptionByType(OptionType.VIEWS)
        OptionItem(
            icon = Icons.Rounded.Visibility,
            value = views.value
        ) { onViewsClick(views) }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val replies = options.getOptionByType(OptionType.REPLIES)
            OptionItem(
                icon = Icons.AutoMirrored.Rounded.Reply,
                value = replies.value
            ) { onRepliesClick(replies) }
            val comments = options.getOptionByType(OptionType.COMMENTS)
            OptionItem(
                icon = Icons.AutoMirrored.Rounded.Comment,
                value = comments.value
            ) { onCommentsClick(comments) }
            val likes = options.getOptionByType(OptionType.LIKES)
            OptionItem(
                icon = Icons.Rounded.FavoriteBorder,
                value = likes.value,
            ) { onLikesClick(likes) }
        }
    }
}

@Composable
private fun OptionItem(
    icon: ImageVector,
    value: Int,
    optionClick: () -> Unit
) {
    Row(
        modifier = Modifier.clickable {
            optionClick()
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSecondary
        )
        Text(text = value.toString())
    }
}
