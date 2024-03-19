package io.github.gouvinb.seagulls.lib.core.datastore.model.local

// TODO: 04/03/2024: add categories, and entries support
data class UserDataLocal(
    val shouldHideOnboarding: Boolean,
    val themeBrand: ThemeBrandLocal,
    val darkThemeConfig: DarkThemeConfigLocal,
)
