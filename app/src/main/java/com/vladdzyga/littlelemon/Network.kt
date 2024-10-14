package com.vladdzyga.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author VladyslavDzyhovskyi
 * Created 14-Oct-24 at 10:51
 */

@Serializable
data class MenuItemNetwork(
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("description") val description: String,
    @SerialName("price") val price: String,
    @SerialName("image") val imageUrl: String,
    @SerialName("category") val category: String
)

@Serializable
data class MenuNetwork(
    @SerialName("menu") val menuItems: List<MenuItemNetwork>
)