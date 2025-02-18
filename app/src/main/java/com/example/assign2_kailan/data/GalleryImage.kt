package com.example.assign2_kailan.data
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.assign2_kailan.R


data class GalleryImage(

    val Id: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val imageDescription: Int,
    @StringRes val description: Int,
    @StringRes val artworkYear: Int,
    @StringRes val artist: Int
)


val galleryImages = listOf<GalleryImage> (
    GalleryImage(1, R.drawable.frankie, R.string.frankie_image_description, R.string.frankie_description, R.string.frankie_year, R.string.frankie_artist),
    GalleryImage(2, R.drawable.leroy, R.string.leroy_image_description, R.string.leroy_description, R.string.leroy_year, R.string.leroy_artist),
    GalleryImage(3, R.drawable.tzeitel, R.string.tzeitel_image_description, R.string.tzeitel_description, R.string.tzeitel_year, R.string.tzeitel_artist)
)