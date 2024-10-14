package com.vladdzyga.littlelemon

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.edit
import com.vladdzyga.littlelemon.ui.theme.LittleLemonColor

/**
 * @author VladyslavDzyhovskyi
 * Created 04-Oct-24 at 12:11
 */

@Composable
fun Profile(sharedPreferences: SharedPreferences) {
    var firstName by remember { mutableStateOf(sharedPreferences.getString("first_name", "") ?: "") }
    var lastName by remember { mutableStateOf(sharedPreferences.getString("last_name", "") ?: "") }
    var email by remember { mutableStateOf(sharedPreferences.getString("email", "") ?: "") }

    val context = LocalContext.current

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
                .padding(20.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(
                    text = "First Name:",
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = firstName,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.End
                )
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(
                    text = "Last Name:",
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = lastName,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.End
                )
            }

            Divider(color = Color.LightGray, thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            ) {
                Text(
                    text = "Email:",
                    fontSize = 16.sp,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = email,
                    fontSize = 16.sp,
                    modifier = Modifier.weight(2f),
                    textAlign = TextAlign.End
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                Toast.makeText(context, "Log out done.",Toast.LENGTH_SHORT).show()
                sharedPreferences.edit(commit = true) {
                    putString("first_name", "")
                    putString("last_name", "")
                    putString("email", "")
                    putBoolean("logged", false)
                }
                (context as? Activity)?.finish()
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            },
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
                text = "Log out",
                color = LittleLemonColor.DarkGrey,
                fontSize = 18.sp
            )
        }
    }
}