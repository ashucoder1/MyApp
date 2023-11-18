package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(textValue:String,
                  textSize: TextUnit,
                  colorValue: Color = Color.Black,
                  fontWeight: FontWeight) {
    Text(text =textValue,
        fontSize=textSize,
        color=colorValue,
        fontWeight =fontWeight
    )
}

@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "Test Sample" , textSize = 24.sp, fontWeight = FontWeight.Bold)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
){
    var currentValue by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier= Modifier.fillMaxWidth(),
        value = currentValue ,
        onValueChange ={
            currentValue=it
        },
        placeholder ={
            Text(text = "Enter your name",
                fontSize = 18.sp
            )
        },
        textStyle = TextStyle.Default.copy(fontSize =24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),

        )
}

@Preview(showBackground = true)
@Composable
fun TextFieldComponentPreview(){
    TextFieldComponent()
}


@Composable
fun ButtonComponent(){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
        }

    ) {
        TextComponent(textValue = "Go to Details Screen !",
            textSize = 18.sp,
            colorValue = Color.White,
            fontWeight = FontWeight.Light)
    }
}

@Preview
@Composable
fun ButtonComponentPreview(){
    ButtonComponent()
}

@Composable
fun TextWithShadow(value:String){
    val shadowoffset= Offset(x=1f,y=2f)
    Text(text = value,
        fontSize = 24.sp,
        fontWeight = FontWeight.Light,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(),shadowoffset,2f)
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextWithShadowPreview(){
    TextWithShadow(value = "Welcome")
}


@Composable
fun FactsComposable(value: String){
    Card(modifier= Modifier
        .padding(32.dp)
        .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp,24.dp)) {
//            Image(painter = painterResource(id = R.drawable.comma),
//                contentDescription = "quotation image",
//                modifier = Modifier
//                    .size(24.dp)
//            )
            Spacer(modifier = Modifier.size(24.dp))

            TextWithShadow(value = value)

            Spacer(modifier = Modifier.size(24.dp))

//            Image(painter = painterResource(id = R.drawable.comma)  ,
//                contentDescription = "rev comma",
//                modifier = Modifier.rotate(180f)
//                    .size(24.dp))
        }

    }
}

@Preview
@Composable
fun FactsComposablePreview(){
    FactsComposable(value = "Hello")
}

@Composable
fun BackgroundShape(topStart: Float, topEnd: Float, bottomEnd: Float , bottomStart: Float ){
    Box(modifier=Modifier
        .size(300.dp,100.dp)
        .clip(
            shape = RoundedCornerShape(
                topStart = topStart,
                topEnd = topEnd,
                bottomEnd = bottomEnd,
                bottomStart = bottomStart
            )
        )
        .background(Color.Green)
    ){

}
}

@Preview(showBackground = true)
@Composable
fun BackgroundShapePreview(){
    BackgroundShape(topStart= 10.0f, topEnd = 20.0f,
    bottomEnd= 30.0f, bottomStart= 40.0f)
}
