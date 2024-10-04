package com.vladdzyga.littlelemon

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.vladdzyga.littlelemon.ui.theme.LittleLemonColor
import kotlinx.coroutines.launch

/**
 * @author VladyslavDzyhovskyi
 * Created 04-Oct-24 at 12:12
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .padding(start = 20.dp)
                .size(50.dp)
            ) {}
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "LittleLemon Logo",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .size(50.dp)
            )
            IconButton(
                onClick = {
                    navController.navigate(Profile.route)
                },
                modifier = Modifier.padding(end = 20.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .background(color = LittleLemonColor.DarkOlive)
                .padding(bottom = 20.dp)
        ) {
            Text(
                text = "Little Lemon",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = LittleLemonColor.Yellow,
                modifier = Modifier.padding(start = 20.dp, top = 16.dp)
            )
            Text(
                text = "Chicago",
                fontSize = 24.sp,
                color = LittleLemonColor.White,
                modifier = Modifier.padding(start = 20.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(20.dp)
            ) {
                Text(
                    text = "We are a family owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    color = LittleLemonColor.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(bottom = 28.dp, end = 20.dp)
                        .fillMaxWidth(0.6f)
                )
                Image(
                    painter = painterResource(id = R.drawable.upperpanelimage),
                    contentDescription = "Upper Panel Image",
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                )
            }
            TextField(
                value = "",
                onValueChange = { },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                },
                placeholder = { Text("Enter search phrase") },
                textStyle = TextStyle(fontSize = 16.sp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(horizontal = 20.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White.copy(alpha = 0.6f),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "ORDER FOR DELIVERY!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 20.dp)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    ButtonItem(text = "Starters")
                }
                item {
                    ButtonItem(text = "Mains")
                }
                item {
                    ButtonItem(text = "Desserts")
                }
                item {
                    ButtonItem(text = "Drinks")
                }
            }
        }
        LazyColumn {
            item {
                MenuDishCard(
                    "Greek Salad",
                    "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
                    12.99,
                    R.drawable.greeksalad
                )
            }
            item {
                MenuDishCard(
                    "Lemon Desert",
                    "Traditional homemade Italian Lemon Ricotta Cake.",
                    8.99,
                    R.drawable.lemondessert
                )
            }
            item {
                MenuDishCard(
                    "Bruschetta",
                    "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
                    4.99,
                    R.drawable.bruschetta
                )
            }
            item {
                MenuDishCard(
                    "Grilled Fish",
                    "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
                    19.99,
                    R.drawable.grilledfish
                )
            }
            item {
                MenuDishCard(
                    "Pasta",
                    "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
                    8.99,
                    R.drawable.pasta
                )
            }
            item {
                MenuDishCard(
                    "Lasagne",
                    "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese.",
                    7.99,
                    R.drawable.lasagne
                )
            }
        }
    }
}

@Composable
fun ButtonItem(text: String) {
    Button(
        onClick = {},
        modifier = Modifier.height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray
        )

    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = LittleLemonColor.DarkOlive
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDishCard(name: String, description: String, price: Double, imageResource: Int) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier.padding(horizontal = 13.dp)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column () {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = description,
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(top = 5.dp, bottom = 5.dp)
                )
                Text(
                    text = "$${price}",
                    fontWeight = FontWeight.Bold,
                )
            }
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
    Divider(
        modifier = Modifier.padding(start = 8.dp, end = 8.dp),
        thickness = 1.dp,
        color = LittleLemonColor.DarkGrey
    )
}