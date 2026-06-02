package io.github.elyesmansour.floatingTabBarSample

import androidx.compose.runtime.Composable

/**
 * Shared entry point for the sample, consumed by both the Android `MainActivity` and the iOS
 * `MainViewController`. [PlantSky] applies [io.github.elyesmansour.floatingTabBarSample.ui.theme.FloatingTabBarTheme]
 * itself, so platform hosts only need to call this.
 */
@Composable
fun App() {
    PlantSky()
}
