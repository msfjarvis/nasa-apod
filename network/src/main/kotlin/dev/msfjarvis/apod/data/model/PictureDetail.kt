package dev.msfjarvis.apod.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This class represents a single picture as sent by the NASA APOD API.
 */
@Serializable
data class PictureDetail(
  val copyright: String? = null,
  val date: String,
  val explanation: String,
  @SerialName("hdurl")
  val hdUrl: String,
  @SerialName("media_type")
  val mediaType: String,
  @SerialName("service_version")
  val serviceVersion: String,
  val title: String,
  val url: String,
)
