package com.example.courselist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courselist.ui.theme.CourseListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CourseListTheme {
                    CourseListScreen()
            }
        }
    }
}


// Data source: a list of course names.
private val courseNames = listOf(
    "Umar Khan",
    "Introduction to Programming",
    "Software Engineering",
    "Mobile App Development",
    "Web Programming",
    "Fundamentals of Data Science",
    "Data Structures & Algorithms",
    "Cloud Computing",
    "Natural Language Processing",
    "Linear Algebra",
    "Discrete Mathematics",
    "Database Management Systems",
    "Operating Systems",
    "Computer Networks",
    "Artificial Intelligence",
    "Human-Computer Interaction",
    "Cybersecurity Fundamentals",
    "Software Testing & Quality Assurance",
    "Agile Methodologies",
    "Design Thinking",
    "Decision Support Systems",
    "Big Data Analytics"
)

@Composable
fun CourseListScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        items(courseNames){ courseName ->
            CourseNameCard(name = courseName)
        }
    }
}

@Composable
fun CourseNameCard(name: String){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Text(
            text = name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListTheme {
        CourseListScreen()
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    CourseListTheme {
//        Greeting("Android")
//    }
//}