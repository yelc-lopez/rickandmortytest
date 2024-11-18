package com.example.rickandmortytesthomeland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickandmortytesthomeland.composables.CharacterList
import com.example.rickandmortytesthomeland.ui.theme.RickAndMortyApiTheme
import com.example.rickandmortytesthomeland.viewmodels.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyApiTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título
                    Text(
                        text = "Rick & Morty",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )

                    // Obtén el ViewModel actual
                    val characterViewModel: CharacterViewModel = viewModel()

                    // Mostrar el listado de personajes
                    CharacterList(viewModel = characterViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterList() {
    val characterViewModel: CharacterViewModel = viewModel()
    CharacterList(viewModel = characterViewModel)
}
