@file:OptIn(ExperimentalSharedTransitionApi::class)

package io.github.elyesmansour.floatingTabBarSample

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.elyesmansour.floatingTabBar.FloatingTabBar
import io.github.elyesmansour.floatingTabBar.FloatingTabBarScope
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.tooling.preview.Preview
import io.github.elyesmansour.floatingTabBarSample.shared.resources.Res
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_add
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_favorite
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_home
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_person
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_search
import io.github.elyesmansour.floatingTabBarSample.shared.resources.ic_settings

/**
 * Previews exercising every layout combination [FloatingTabBar] supports, in both the inline and
 * expanded states. The layout is driven by three optional pieces, so each state has a matrix of:
 *
 *  - tab group:  present (one or more [FloatingTabBarScope.tab]) or absent
 *  - accessory:  present or absent
 *  - standalone: present ([FloatingTabBarScope.standaloneTab]) or absent
 *
 * Each preview forces a single state via the `isInline` overload so the case renders deterministically.
 */

private data class PreviewTab(val key: String, val text: String, val icon: DrawableResource)

private val previewTabs = listOf(
    PreviewTab("home", "Home", Res.drawable.ic_home),
    PreviewTab("search", "Search", Res.drawable.ic_search),
    PreviewTab("favorites", "Favorites", Res.drawable.ic_favorite),
    PreviewTab("profile", "Profile", Res.drawable.ic_person),
)

private val previewStandaloneTab = PreviewTab("add", "Add", Res.drawable.ic_add)

/**
 * Renders a [FloatingTabBar] in a single forced state with any combination of the three pieces.
 *
 * @param isInline whether to force the inline (true) or expanded (false) state
 * @param hasTabGroup whether to include the tab group (the inline state shows the selected tab)
 * @param hasAccessory whether to include the accessory
 * @param hasStandalone whether to include the standalone tab
 */
@Composable
private fun PreviewBar(
    isInline: Boolean,
    hasTabGroup: Boolean,
    hasAccessory: Boolean,
    hasStandalone: Boolean,
) {
    MaterialTheme {
        // A surface behind the floating bar so its shadows and background are visible.
        Surface(color = MaterialTheme.colorScheme.surfaceContainerLowest) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                FloatingTabBar(
                    isInline = isInline,
                    selectedTabKey = if (hasTabGroup) previewTabs.first().key else null,
                    inlineAccessory = previewAccessory(hasAccessory),
                    expandedAccessory = previewAccessory(hasAccessory),
                ) {
                    if (hasTabGroup) {
                        previewTabs.forEach { tabItem ->
                            tab(
                                key = tabItem.key,
                                title = { Text(tabItem.text) },
                                icon = {
                                    Icon(painter = painterResource(tabItem.icon), contentDescription = tabItem.text)
                                },
                                onClick = {},
                            )
                        }
                    }

                    if (hasStandalone) {
                        standaloneTab(
                            key = previewStandaloneTab.key,
                            icon = {
                                Icon(
                                    painter = painterResource(previewStandaloneTab.icon),
                                    contentDescription = previewStandaloneTab.text,
                                )
                            },
                            onClick = {},
                        )
                    }
                }
            }
        }
    }
}

/** A simple settings-icon accessory used to fill the accessory slot, or null when not requested. */
private fun previewAccessory(
    hasAccessory: Boolean,
): (@Composable SharedTransitionScope.(Modifier, AnimatedVisibilityScope) -> Unit)? {
    if (!hasAccessory) return null
    return { modifier, _ ->
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            Icon(painter = painterResource(Res.drawable.ic_settings), contentDescription = "Accessory")
        }
    }
}

// region Inline previews

@Preview
@Composable
private fun InlineTabsPreview() =
    PreviewBar(isInline = true, hasTabGroup = true, hasAccessory = false, hasStandalone = false)

@Preview
@Composable
private fun InlineTabsStandalonePreview() =
    PreviewBar(isInline = true, hasTabGroup = true, hasAccessory = false, hasStandalone = true)

@Preview
@Composable
private fun InlineTabsAccessoryPreview() =
    PreviewBar(isInline = true, hasTabGroup = true, hasAccessory = true, hasStandalone = false)

@Preview
@Composable
private fun InlineTabsAccessoryStandalonePreview() =
    PreviewBar(isInline = true, hasTabGroup = true, hasAccessory = true, hasStandalone = true)

@Preview
@Composable
private fun InlineAccessoryPreview() =
    PreviewBar(isInline = true, hasTabGroup = false, hasAccessory = true, hasStandalone = false)

@Preview
@Composable
private fun InlineAccessoryStandalonePreview() =
    PreviewBar(isInline = true, hasTabGroup = false, hasAccessory = true, hasStandalone = true)

@Preview
@Composable
private fun InlineStandalonePreview() =
    PreviewBar(isInline = true, hasTabGroup = false, hasAccessory = false, hasStandalone = true)

// endregion

// region Expanded previews

@Preview
@Composable
private fun ExpandedTabsPreview() =
    PreviewBar(isInline = false, hasTabGroup = true, hasAccessory = false, hasStandalone = false)

@Preview
@Composable
private fun ExpandedTabsStandalonePreview() =
    PreviewBar(isInline = false, hasTabGroup = true, hasAccessory = false, hasStandalone = true)

@Preview
@Composable
private fun ExpandedTabsAccessoryPreview() =
    PreviewBar(isInline = false, hasTabGroup = true, hasAccessory = true, hasStandalone = false)

@Preview
@Composable
private fun ExpandedTabsAccessoryStandalonePreview() =
    PreviewBar(isInline = false, hasTabGroup = true, hasAccessory = true, hasStandalone = true)

@Preview
@Composable
private fun ExpandedAccessoryPreview() =
    PreviewBar(isInline = false, hasTabGroup = false, hasAccessory = true, hasStandalone = false)

@Preview
@Composable
private fun ExpandedAccessoryStandalonePreview() =
    PreviewBar(isInline = false, hasTabGroup = false, hasAccessory = true, hasStandalone = true)

@Preview
@Composable
private fun ExpandedStandalonePreview() =
    PreviewBar(isInline = false, hasTabGroup = false, hasAccessory = false, hasStandalone = true)

// endregion
