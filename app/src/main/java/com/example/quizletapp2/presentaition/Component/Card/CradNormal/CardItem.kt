package com.example.quizletapp2.presentaition.Component.Card.CradNormal

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizletapp2.R
import com.example.quizletapp2.presentaition.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardNormal(item : Screen.FeatureStudy, navController: NavController){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .shadow(ambientColor = Color.Gray,elevation = 2.dp, spotColor = Color.Black, shape = RoundedCornerShape(2.dp))
        ,
        shape = RoundedCornerShape(5.dp),
        onClick = {
            navController.navigate(item.fRouter)
        }
    ){
       Row(
           modifier = Modifier.padding(5.dp).fillMaxWidth().height(40.dp)
       ) {
           IconButton(onClick = { /*TODO*/ }) {
               Icon(
                   painter = painterResource(id = item.icon ),
                   contentDescription = "TagName",
                   modifier = Modifier.size(25.dp),
                   tint = Color.Blue
               )
           }
           Spacer(modifier = Modifier.width(5.dp))
           Column (
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.Start,
               modifier = Modifier.fillMaxSize()
           ) {
               Text(
                   text = item.title,
                   modifier = Modifier,
                   style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp)
               )
               Text(
                   modifier = Modifier.padding(top = 3.dp),
                   text = "Ôn lại các thuật ngữ và định nghĩa",
                   style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 10.sp)

               )
           }
       }
    }

}

@Preview(showBackground = true)
@Composable
fun dfsd(){
}