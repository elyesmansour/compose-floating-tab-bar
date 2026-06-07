package io.github.elyesmansour.floatingTabBarSample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.github.elyesmansour.floatingTabBarSample.shared.resources.Res
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_favorite
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_favorite_border
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_refresh
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_share
import org.jetbrains.compose.resources.painterResource

@Composable
fun ProfileScreen(
    scrollConnection: NestedScrollConnection,
    modifier: Modifier = Modifier
) {
    val userPosts = remember {
        listOf(
            PlantPost(
                id = "u1",
                username = "You",
                handle = "@you",
                content = "Just started my journey into plant parenthood! Got my first pothos today and I'm already in love 🌱💚",
                timestamp = "3h",
                likes = 12,
                reposts = 2
            ),
            PlantPost(
                id = "u2",
                username = "You",
                handle = "@you",
                content = "Question for the plant community: Is it normal for my snake plant to be this dramatic? It's been sulking since I moved it 2 inches to the left 🐍",
                timestamp = "1d",
                likes = 45,
                reposts = 8
            ),
            PlantPost(
                id = "u3",
                username = "You",
                handle = "@you",
                content = "Update: The pothos has taken over my entire bookshelf and I'm not even mad about it. This is my life now 📚🌿",
                timestamp = "2d",
                likes = 78,
                reposts = 15
            ),
            PlantPost(
                id = "u4",
                username = "You",
                handle = "@you",
                content = "PSA: Apparently you can't water plants with coffee. Who knew? 🙃 My plants are now properly hydrated and I'm properly caffeinated.",
                timestamp = "3d",
                likes = 156,
                reposts = 34
            ),
            PlantPost(
                id = "u5",
                username = "You",
                handle = "@you",
                content = "Went to the nursery for 'just one plant' and came home with six. I see no problem here 🛒🌱",
                timestamp = "4d",
                likes = 203,
                reposts = 67
            ),
            PlantPost(
                id = "u6",
                username = "You",
                handle = "@you",
                content = "My plant collection has officially outgrown my apartment. Time to find a bigger place... or maybe just more creative spots? 🏡",
                timestamp = "5d",
                likes = 89,
                reposts = 21
            ),
            PlantPost(
                id = "u7",
                username = "You",
                handle = "@you",
                content = "Today I learned that talking to your plants actually works! My monstera unfurled a new leaf right after I told it about my day 🗣️🌿",
                timestamp = "6d",
                likes = 134,
                reposts = 28
            ),
            PlantPost(
                id = "u8",
                username = "You",
                handle = "@you",
                content = "First successful propagation! 🎉 These little roots are giving me more joy than they probably should. Plant parent level: unlocked ✅",
                timestamp = "1w",
                likes = 267,
                reposts = 45
            )
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollConnection)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            // Profile Header
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Y",
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    
                    Text(
                        text = "Your Plant Journey",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    
                    Text(
                        text = "@you",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    
                    Row(
                        modifier = Modifier.padding(top = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "${userPosts.size}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Posts",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "847",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Followers",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "23",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = "Plants",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
        
        items(userPosts) { post ->
            UserPlantPostCard(post = post)
        }
    }
}

@Composable
private fun UserPlantPostCard(
    post: PlantPost,
    modifier: Modifier = Modifier
) {
    var isLiked by remember { mutableStateOf(post.isLiked) }
    var isReposted by remember { mutableStateOf(post.isReposted) }
    var likeCount by remember { mutableStateOf(post.likes) }
    var repostCount by remember { mutableStateOf(post.reposts) }

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Y",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                
                Column(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = post.username,
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = " ${post.handle}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                        Text(
                            text = " • ${post.timestamp}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            }
            
            Text(
                text = post.content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 12.dp)
            )
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            isLiked = !isLiked
                            likeCount += if (isLiked) 1 else -1
                        }
                    ) {
                        Icon(
                            painter = painterResource(if (isLiked) Res.drawable.ic_favorite else Res.drawable.ic_favorite_border),
                            contentDescription = "Like",
                            tint = if (isLiked) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        text = likeCount.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            isReposted = !isReposted
                            repostCount += if (isReposted) 1 else -1
                        }
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_refresh),
                            contentDescription = "Repost",
                            tint = if (isReposted) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        text = repostCount.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                
                IconButton(
                    onClick = { /* Share functionality */ }
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_share),
                        contentDescription = "Share",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}