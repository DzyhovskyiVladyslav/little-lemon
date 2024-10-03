package com.vladdzyga.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vladdzyga.littlelemon.ui.theme.LittleLemonColor

/**
 * @author VladyslavDzyhovskyi
 * Created 03-Oct-24 at 21:48
 */

@Composable
fun Onboarding() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.padding(top = 50.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .size(50.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "LittleLemon Logo"
            )
        }
        Box(
            modifier = Modifier
                .background(LittleLemonColor.DarkOlive)
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 40.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Let's get to know you",
                color = LittleLemonColor.White,
                fontSize = 25.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Personal information",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OnboardingTextField(
                value = firstName,
                onValueChange = { firstName = it },
                label = "First name"
            )
            OnboardingTextField(
                value = lastName,
                onValueChange = { lastName = it },
                label = "Last name"
            )
            OnboardingTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 80.dp)
                .height(50.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = LittleLemonColor.Yellow
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Register",
                color = LittleLemonColor.DarkGrey,
                fontSize = 18.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    Column {
        Text(
            text = label,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 5.dp)
        )
        TextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp)
                .height(50.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp)),
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
        )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}*/
