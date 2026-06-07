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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import io.github.elyesmansour.floatingTabBarSample.shared.resources.Res
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_play_arrow
import org.jetbrains.compose.resources.painterResource

data class PodcastEpisode(
    val id: String,
    val title: String,
    val description: String,
    val duration: String,
    val publishedDate: String,
    val podcastName: String,
    val progress: Float = 0f,
    val isPlaying: Boolean = false
)

@Composable
fun PodcastsScreen(
    scrollConnection: NestedScrollConnection,
    modifier: Modifier = Modifier
) {
    val episodes = remember {
        listOf(
            PodcastEpisode(
                id = "1",
                title = "The Secret Life of Succulents",
                description = "Discover the fascinating world of succulents and learn why these water-storing plants are perfect for beginners. We dive deep into their unique adaptations and care requirements.",
                duration = "42:15",
                publishedDate = "2 days ago",
                podcastName = "Plant Whisperer Podcast",
                progress = 0.35f
            ),
            PodcastEpisode(
                id = "2",
                title = "Houseplant Myths Debunked",
                description = "From watering schedules to fertilizer fears, we tackle the most common misconceptions about indoor plant care. Time to separate fact from fiction!",
                duration = "28:47",
                publishedDate = "1 week ago",
                podcastName = "Green Thumb Chronicles",
                progress = 0f
            ),
            PodcastEpisode(
                id = "3",
                title = "Propagation Station: Growing Your Collection",
                description = "Learn the art of plant propagation with expert tips on water propagation, soil propagation, and everything in between. Multiply your plants for free!",
                duration = "35:22",
                publishedDate = "1 week ago",
                podcastName = "Plant Whisperer Podcast",
                progress = 1f
            ),
            PodcastEpisode(
                id = "4",
                title = "The Psychology of Plant Parenting",
                description = "Why do we feel so connected to our plants? Explore the mental health benefits of caring for houseplants and the science behind our green companions.",
                duration = "31:08",
                publishedDate = "2 weeks ago",
                podcastName = "Mindful Gardener",
                progress = 0.67f
            ),
            PodcastEpisode(
                id = "5",
                title = "Seasonal Plant Care: Winter Edition",
                description = "Keep your plants thriving through the colder months with these essential winter care tips. From humidity to lighting, we cover it all.",
                duration = "26:13",
                publishedDate = "2 weeks ago",
                podcastName = "Four Season Botanist",
                progress = 0f
            ),
            PodcastEpisode(
                id = "6",
                title = "Air Purifying Plants: Science or Hype?",
                description = "Do houseplants really clean the air? We examine the research behind air-purifying plants and discuss which ones are actually effective.",
                duration = "33:45",
                publishedDate = "3 weeks ago",
                podcastName = "Green Thumb Chronicles",
                progress = 0.15f
            ),
            PodcastEpisode(
                id = "7",
                title = "Plant Pest Control: Natural Solutions",
                description = "Dealing with aphids, spider mites, and other common plant pests? Learn about natural, eco-friendly methods to keep your plants healthy.",
                duration = "29:56",
                publishedDate = "3 weeks ago",
                podcastName = "Plant Whisperer Podcast",
                progress = 0f
            ),
            PodcastEpisode(
                id = "8",
                title = "The Ultimate Guide to Fiddle Leaf Figs",
                description = "Master the art of caring for everyone's favorite dramatic houseplant. From light requirements to leaf cleaning, we cover everything you need to know.",
                duration = "38:12",
                publishedDate = "1 month ago",
                podcastName = "Fiddle & Fern",
                progress = 0.88f
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
        items(episodes) { episode ->
            PodcastEpisodeCard(episode = episode)
        }
    }
}

@Composable
private fun PodcastEpisodeCard(
    episode: PodcastEpisode,
    modifier: Modifier = Modifier
) {
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
                        .size(64.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🎧",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = episode.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    
                    Text(
                        text = episode.podcastName,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    
                    Row(
                        modifier = Modifier.padding(top = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = episode.duration,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "•",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = episode.publishedDate,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_play_arrow),
                        contentDescription = "Play",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            
            Text(
                text = episode.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 12.dp)
            )
            
            if (episode.progress > 0f) {
                Column(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Progress",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "${(episode.progress * 100).toInt()}%",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    
                    LinearProgressIndicator(
                        progress = { episode.progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 4.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.3f)
                    )
                }
            }
        }
    }
}