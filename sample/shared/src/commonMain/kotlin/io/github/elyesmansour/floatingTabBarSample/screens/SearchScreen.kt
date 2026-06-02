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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_more_vert
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_search
import org.jetbrains.compose.resources.painterResource

data class TrendingTopic(
    val id: String,
    val hashtag: String,
    val postCount: String,
    val category: String
)

data class SuggestedUser(
    val id: String,
    val username: String,
    val handle: String,
    val followerCount: String,
    val bio: String
)

@Composable
fun SearchScreen(
    scrollConnection: NestedScrollConnection,
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    
    val trendingTopics = remember {
        listOf(
            TrendingTopic(
                id = "1",
                hashtag = "#PlantParenthood",
                postCount = "12.4K posts",
                category = "Community"
            ),
            TrendingTopic(
                id = "2",
                hashtag = "#SucculentSunday",
                postCount = "8.7K posts",
                category = "Weekly"
            ),
            TrendingTopic(
                id = "3",
                hashtag = "#PropagationStation",
                postCount = "15.2K posts",
                category = "DIY"
            ),
            TrendingTopic(
                id = "4",
                hashtag = "#PlantKiller",
                postCount = "3.1K posts",
                category = "Support"
            ),
            TrendingTopic(
                id = "5",
                hashtag = "#IndoorJungle",
                postCount = "23.8K posts",
                category = "Lifestyle"
            )
        )
    }
    
    val suggestedUsers = remember {
        listOf(
            SuggestedUser(
                id = "1",
                username = "The Plant Doctor",
                handle = "@plantdoctor",
                followerCount = "45.2K",
                bio = "Professional botanist sharing plant care tips and troubleshooting advice"
            ),
            SuggestedUser(
                id = "2",
                username = "Succulent Sarah",
                handle = "@succulentsarah",
                followerCount = "28.6K",
                bio = "Desert plant enthusiast | Cactus collector | Propagation expert"
            ),
            SuggestedUser(
                id = "3",
                username = "Monstera Maven",
                handle = "@monsteramaven",
                followerCount = "19.3K",
                bio = "Tropical plant lover | Fenestration fanatic | Plant photography"
            ),
            SuggestedUser(
                id = "4",
                username = "Herb Harmony",
                handle = "@herbharmony",
                followerCount = "12.7K",
                bio = "Growing herbs indoors | Culinary garden tips | From seed to table"
            )
        )
    }
    
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(scrollConnection)
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Search PlantSky...") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(Res.drawable.ic_search),
                        contentDescription = "Search"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true,
                shape = RoundedCornerShape(24.dp)
            )
        }
        
        item {
            Text(
                text = "Trending on PlantSky",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        
        items(trendingTopics) { topic ->
            TrendingTopicCard(topic = topic)
        }
        
        item {
            // Suggested Users Section Header
            Text(
                text = "Who to follow",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
        
        items(suggestedUsers) { user ->
            SuggestedUserCard(user = user)
        }
    }
}

@Composable
private fun TrendingTopicCard(
    topic: TrendingTopic,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = topic.category,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Icon(
                    painter = painterResource(Res.drawable.ic_more_vert),
                    contentDescription = "More options",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
            }
            
            Text(
                text = topic.hashtag,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            Text(
                text = topic.postCount,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }
}

@Composable
private fun SuggestedUserCard(
    user: SuggestedUser,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = user.username.first().toString(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = user.username,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = " ${user.handle}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
                
                Text(
                    text = "${user.followerCount} followers",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 2.dp)
                )
                
                Text(
                    text = user.bio,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(top = 4.dp),
                    maxLines = 2
                )
            }
        }
    }
}