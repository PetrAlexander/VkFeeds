package com.example.vkfeeds.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.vkfeeds.R

@Composable
fun Profile() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(id = R.string.profile))
    }
}