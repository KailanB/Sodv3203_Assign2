package com.example.assign2_kailan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assign2_kailan.data.GalleryImage
import com.example.assign2_kailan.data.galleryImages
import com.example.assign2_kailan.ui.theme.Assign2_KailanTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assign2_KailanTheme {
               GalleryDisplay()
            }
        }
    }
}

@Composable
fun GalleryDisplay(modifier: Modifier = Modifier) {

    var galleryIndex by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_small))
    ){
        Spacer(modifier = Modifier.size(128.dp))
        GalleryImage(galleryIndex)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(32.dp))
            GalleryItemDescription(galleryIndex)
            Spacer(modifier = Modifier.size(32.dp))
            GalleryButtons(galleryIndex, onClick = {indexChange: Int -> galleryIndex = indexChange})
            Spacer(modifier = Modifier.size(32.dp))
        }

    }
}

@Composable
fun GalleryImage(
    index: Int
){

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(dimensionResource(R.dimen.image_canvas))
            .shadow(elevation = 12.dp, shape = RectangleShape)
            .background(Color.White)
            .padding(dimensionResource(R.dimen.padding_medium))

    ){
        Image(
            painter = painterResource(id = galleryImages[index].imageResourceId),
            contentDescription = stringResource(id = galleryImages[index].imageDescription),
            //contentScale = ContentScale.Crop,
            modifier = Modifier.size(dimensionResource(R.dimen.image_size))

        )
    }




}

@Composable
fun GalleryItemDescription(
    index: Int,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.width(300.dp)
            .background(color = colorResource(R.color.details_background))
            .padding(dimensionResource(R.dimen.padding_small))
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = stringResource(id = galleryImages[index].description),
                fontSize = 24.sp
            )
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = stringResource(id = galleryImages[index].artist) + " ",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = galleryImages[index].artworkYear)
            )
        }
    }

}

@Composable

fun GalleryButtons(
    galleryIndex: Int,
    onClick: (Int) -> Unit
){


    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.buttons)),
            onClick = {
                // since we are going backwards in the gallery we check if we are beyond the first image
                if(galleryIndex > 0)
                {
                    // in this case simply step backwrads
                    onClick(galleryIndex - 1)
                }
                // else if we are at the first image,
                // going backwards means we need to move to the last image in the gallery
                else{
                    onClick(galleryImages.size - 1)
                }


            },
            modifier = Modifier.width(128.dp)
        ) {
            Text(
                text = "Previous"
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.buttons)),
            onClick = {
                // check if current index is at last index of gallery
                if(galleryIndex >= galleryImages.size - 1)
                {
                    // if so next reverts back to first image in the gallery at index 0
                    onClick(0)
                }
                // else continue to next image by +1
                else{
                    onClick(galleryIndex + 1)
                }


            },
            modifier = Modifier.width(128.dp)
        ) {
            Text(
                text = "Next"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GalleryPreview() {
    Assign2_KailanTheme {
        GalleryDisplay()
    }
}