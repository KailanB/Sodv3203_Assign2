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
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
            .padding(20.dp)
    ){
        Spacer(modifier = Modifier.size(128.dp))
        GalleryImage(1)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.weight(1f))
            GalleryItemDescription(1)
            Spacer(modifier = Modifier.size(32.dp))
            GalleryButtons()
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
            .padding(40.dp)

    ){
        Image(
            painter = painterResource(id = galleryImages[index].imageResourceId),
            contentDescription = stringResource(id = galleryImages[index].imageDescription),
            //contentScale = ContentScale.Crop,
            modifier = Modifier.size(dimensionResource(R.dimen.image_size))
//                .padding(dimensionResource(R.dimen.padding_small))
//            .clip(MaterialTheme.shapes.small)
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
            .background(color = Color.LightGray)
            .padding(16.dp)
    ){
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ){
            Text(
                text = stringResource(id = galleryImages[index].description)
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
fun GalleryButtons(){

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ){
        Button(
            onClick = {}
        ) {
            Text(
                text = "Previous"
            )
        }
        Button(
            onClick = {}
        ) {
            Text(
                text = "Previous"
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assign2_KailanTheme {
        GalleryDisplay()
    }
}