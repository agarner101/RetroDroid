package io.andrewgarner.retrokdroid.model

import com.google.gson.annotations.SerializedName

/**
 * Describes a simple image data. Has a url and a timestamp.
 * Created by andrewgarner on 8/8/18.
 */
data class ImageData(
        @SerializedName("imageUrl") val url: String,
        @SerializedName("lastUpdated") val timeStamp: String
)