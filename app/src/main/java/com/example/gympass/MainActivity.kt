package com.example.gympass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gympass.ui.theme.GympassTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GympassTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GympassTheme {
        Greeting("Android")
    }
}

fun generateSubsets(integersList: IntArray): List<List<Int>> {
    val resultsList = mutableListOf<List<Int>>()
    backtrack(integersList, 0, mutableListOf(), resultsList)
    return resultsList
}

// Backtracking algorithm
fun backtrack(
    integersList: IntArray,
    start: Int, currentSubset:
    MutableList<Int>, resultSubset:
    MutableList<List<Int>>,
) {
    resultSubset.add(ArrayList(currentSubset)) // Add value to result

    for (i in start until integersList.size) {
        currentSubset.add(integersList[i]) // Updated current subset
        backtrack(integersList, i + 1, currentSubset, resultSubset) // recursive with next index as starting point
        currentSubset.removeAt(currentSubset.size - 1) // backtrack by removing the last element
    }
}

fun main() {
    val integerListEmpty = emptyList<Int>()
    val integerList3 = intArrayOf(1,2,3)
    val integerList1 = intArrayOf(1,2,3,4)
    val integerList2 = intArrayOf(5,6,1,9)

    val subsets1 = generateSubsets(integerList1)
    val subsets2 = generateSubsets(integerList2)
    val subsets3 = generateSubsets(integerList3)

    println("Test 1 |||||||||||||||")
    integerListEmpty.forEachIndexed { _, subset ->
        println(subset)
    }

    println("Test 2 |||||||||||||||")
    subsets1.forEachIndexed { _, subset ->
        println(subset)
    }

    println("Test 3 |||||||||||||||")
    subsets2.forEachIndexed { _, subset ->
        println(subset)
    }

    println("Test 4 |||||||||||||||")
    subsets3.forEachIndexed { _, subset ->
        println(subset)
    }
}
