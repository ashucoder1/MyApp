package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(textValue:String, textSize: TextUnit, colorValue: Color = Color.Black,
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
fun TextFieldComponent(text:String,placeholder:String){
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
            Text(text = placeholder,
                fontSize = 18.sp
            )
        },
        label={
              Text(text = text)
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
    TextFieldComponent("Label Text","Name")
}


@Composable
fun ButtonComponent(textValue:String,onClick:()->Unit){
    Button(
        modifier = Modifier.wrapContentWidth()
            .clickable(onClick=onClick),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        onClick = onClick

    ) {
        TextComponent(textValue = textValue + "!",
            textSize = 18.sp,
            colorValue = Color.White,
            fontWeight = FontWeight.Light)
    }
}

@Preview
@Composable
fun ButtonComponentPreview(){
    ButtonComponent("Button Text",{})
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
        .padding(18.dp)
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
            Spacer(modifier = Modifier.size(8.dp))

            TextWithShadow(value = value)

            Spacer(modifier = Modifier.size(8.dp))

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
    Box(modifier= Modifier
        .size(300.dp, 110.dp)
        .clip(
            shape = RoundedCornerShape(
                topStart = topStart,
                topEnd = topEnd,
                bottomEnd = bottomEnd,
                bottomStart = bottomStart
            )
        )
        .background(Color.Blue)
    ){
}
}

@Preview(showBackground = true)
@Composable
fun BackgroundShapePreview(){
    BackgroundShape(topStart= 0.0f, topEnd = 120.0f,
    bottomEnd= 330.0f, bottomStart= 90.0f)
}

@Composable
fun CheckBoxText(text: String,horizontalArrangement: Arrangement.Horizontal){
    Row(horizontalArrangement = horizontalArrangement) {
        val isChecked = remember { mutableStateOf(false) }
        Checkbox(checked = isChecked.value,
            enabled = true,
            onCheckedChange = {isChecked.value=it},
            colors = CheckboxDefaults.colors(Color.Green) ,
            modifier = Modifier.align(Alignment.CenterVertically)
            )
        Spacer(Modifier.width(2.dp))
        Text(text = text,modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Preview(showBackground = true)
@Composable
fun CheckBoxTextPreview(){
    CheckBoxText("Checked Box",Arrangement.Start)
}

@Composable
fun ImageBox(resource_id:Int,width:Dp,height:Dp){
    Box(modifier = Modifier
        .size(width, height)
        .background(MaterialTheme.colorScheme.primary, CircleShape)
        .clip(CircleShape)){
        Image(painter = painterResource(id = resource_id), contentDescription = null ,
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp))
    }
}

@Preview
@Composable
fun ImageBoxPreview(){
    ImageBox(R.drawable.temp_logo,100.dp,100.dp)
}

@Composable
fun ProfileTopCard(){
    Card(
        modifier= Modifier
            .padding(18.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(0.dp,0.dp,24.dp,24.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                TextComponent(textValue = "UserId", textSize = 18.sp, fontWeight = FontWeight.Medium)
                Image(imageVector = Icons.Default.Edit, contentDescription = "EditProfile")
            }
            Row(modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                ImageBox(resource_id = R.drawable.temp_logo,
                    width =100.dp ,
                    height =100.dp )
            }
            TextComponent(textValue = "UserName", textSize = 24.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(18.dp, 8.dp)
                    .fillMaxWidth()) {
                    TextWithShadow(value = "clap :1000")
                    TextWithShadow(value = "followers :1200")
            }

        }
        
    }
}

@Preview
@Composable
fun ProfileTopCardPreview(){
    ProfileTopCard()
}

@Composable
fun ProfileBottomCard(){
    Card(
        modifier= Modifier
            .padding(18.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp,24.dp,0.dp,0.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ){
        Column(modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.Top) {
            TextComponent(textValue = "Pin", textSize = 18.sp, fontWeight = FontWeight.Normal)
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, 18.dp)){
                items(20){
                    ImageBox(resource_id = R.drawable.temp_logo, width = 40.dp, height = 40.dp)
                    Spacer(modifier = Modifier.width(18.dp))

                }
            }

        }

    }
}

@Preview
@Composable
fun ProfileBottomCardPreview(){
    ProfileBottomCard()
}

@Composable
fun MemoryComponent(){
    Card(
        modifier= Modifier
            .padding(18.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(24.dp,24.dp,0.dp,0.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ){
        Column(modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.Top) {
            TextComponent(textValue = "Memory", textSize = 18.sp, fontWeight = FontWeight.Normal)
            LazyRow(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, 18.dp)){
                items(20){
                    Column(modifier=Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        ImageBox(resource_id = R.drawable.temp_logo, width = 40.dp, height = 40.dp)
                        TextComponent(textValue = "username", textSize = 18.sp, fontWeight = FontWeight.Light)
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun MemoryComponentPreview(){
    MemoryComponent()
}

@Composable
fun RoomCard(){
    Box(modifier = Modifier
        .padding(8.dp)
        .border(2.dp, Color.Black, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center){
        Column(modifier=Modifier.padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            ImageBox(resource_id = R.drawable.temp_logo, width = 50.dp, height = 50.dp)
            Spacer(modifier = Modifier.size(4.dp))
            TextComponent(textValue = "room", textSize = 18.sp, fontWeight = FontWeight.Light)
        }
    }
}

@Preview
@Composable
fun RoomCardPreview(){
    RoomCard()
}





