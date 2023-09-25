package com.example.formsqlite

import DBHandler
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formsqlite.ui.theme.FormSQLiteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormSQLiteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(){

    var coursename by remember { mutableStateOf("") }
    var courseduration by remember { mutableStateOf("") }
    var coursetracks by remember { mutableStateOf("") }
    var coursedescription by remember { mutableStateOf("") }
    val context = LocalContext.current
    var dbHandler: DBHandler = DBHandler(context)
    SimpleCenterAlignedTopAppBar()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text( "SQlite Database in Android",
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                        modifier = Modifier
                    .padding(bottom = 16.dp)
                )

                OutlinedTextField(
                    value = coursename,
                    onValueChange = { coursename = it },
                    label = { Text("Enter your course name") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                )

                OutlinedTextField(
                    value = courseduration,
                    onValueChange = { courseduration = it },
                    label = { Text("Enter your course duration") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                )

                OutlinedTextField(
                    value = coursetracks,
                    onValueChange = { coursetracks = it },
                    label = { Text("Enter your course tracks") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                )

                OutlinedTextField(
                    value = coursedescription,
                    onValueChange = { coursedescription = it },
                    label = { Text("Enter your course description") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                        .background(Color.White)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {
                            dbHandler.addNewCourse(
                                coursename,
                                courseduration,
                                coursedescription,
                                coursetracks
                            )
                            Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT)
                                .show()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(text = "Add to Database")
                    }

                    Button(
                        onClick = {

                        },
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        Text(text = "Read Courses to Database")
                    }
                }
            }
        }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() { // Componente Top Bar
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "CREATE - NOSQL",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
    FormSQLiteTheme {
        App()
    }
}