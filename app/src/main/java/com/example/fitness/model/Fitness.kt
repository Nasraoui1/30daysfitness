package com.example.fitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Fitness(
    @StringRes val dayRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)
