package com.ander74.quattrox

import android.app.Application
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ander74.quattrox.data.entities.Companero
import com.ander74.quattrox.data.entities.TipoCompanero
import com.ander74.quattrox.ui.theme.QuattroXKtxTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {

    val db = (applicationContext as QuattroxApplication).room

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db.companeroDao().insert(
            Companero(
                matricula = 5060,
                nombre = "Andrés",
                apellidos = "Herrero Módenes"
            )
        )

        setContent {
            QuattroXKtxTheme {
                // A surface container using the 'background' color from the theme
                Companeros(companeros = db.companeroDao().getAll())
            }
        }
    }
}


@Composable()
fun Companeros(companeros: List<Companero>){
    QuattroXKtxTheme {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(8.dp)
    ){
        val compis = companeros
        items(companeros){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
            ) {
                Text(
                    text = "${it.matricula}",
                    color = MaterialTheme.colors.onPrimary
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "${it.nombre} ",
                    color = MaterialTheme.colors.onPrimary
                )
                Text(text = it.apellidos,
                    color = MaterialTheme.colors.onPrimary
                )
            }

        }
    }

    }

}


@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    showBackground = true,
    heightDp = 300
)
@Composable
fun DefaultPreview() {

    Companeros(listOf(
        Companero(matricula = 5060, nombre = "Andrés", apellidos = "Herrero"),
        Companero(matricula = 4935, nombre = "Joseba", apellidos = "Moyano"),
        Companero(matricula = 5190, nombre = "Arturo", apellidos = "Gómez")
    ))
}