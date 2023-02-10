package com.example.calculadoradeimc.ui.theme.telas

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoradeimc.R
import com.example.calculadoradeimc.ui.theme.componentes.GenericButton
import com.example.calculadoradeimc.ui.theme.componentes.InputTexts

@Preview
@Composable
fun TelaPrincipal() {

    var peso by remember {

        mutableStateOf("")

    }

    var altura by remember {

        mutableStateOf("")

    }

    val context = LocalContext.current

    val r = remember {
        mutableStateOf("")
    }

    val validstate = remember(r.value) {

        r.value.trim().isNotEmpty()

    }

    Column() {

        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        },
            backgroundColor = Color(0xFFDADFE3)
        )

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            
            InputTexts(
                text = peso,
                label = "Peso",
                onTextChange = {
                    peso = it
                } )


            InputTexts(
                text = altura,
                label = "Altura",
                onTextChange = {
                    Toast.makeText( context, "Seu IMC é: ${it}",
                        Toast.LENGTH_SHORT)
                    altura = it
                } )

            Divider(modifier = Modifier.padding(top = 10.dp))

            GenericButton(modifier = Modifier.padding(top = 10.dp),
                text = "Calcular",
                onClick = {

                    if ( peso.isNotEmpty() && altura.isNotEmpty() ) {

                        val peso2: Double? = peso.toDouble()
                        val altura2: Double? = altura.toDouble()

                        val resultado: Double? = peso2?.div((altura2!! * altura2!!))
                        val rr = "%.2f".format( resultado )
                        r.value = rr.toString()

                        Toast.makeText( context, "Seu IMC é: $resultado",
                            Toast.LENGTH_SHORT).show()

                    }else {

                        if ( peso.isEmpty() ) {

                            Toast.makeText( context, "Digite o peso",
                                Toast.LENGTH_SHORT).show()


                        }

                        if ( altura.isEmpty() ) {

                            Toast.makeText( context, "Digite a altura",
                                Toast.LENGTH_SHORT).show()
                        }

                    }

                })



            if (validstate) {

                Divider(modifier = Modifier.padding(top = 10.dp))

                Column(modifier = Modifier.padding(top = 20.dp)) {

                    Text(text = "Seu IMC é: ",
                        fontSize = 25.sp
                    )
                    Text(text = r.value.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally))

                }


            }

        }

    }

}

@Preview
@Composable
fun Resultado(){

    Column(modifier = Modifier.padding(6.dp)) {

        Text(text = "Seu IMC é: ",
        fontSize = 25.sp
        )
        Text(text = "27.77",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally))

    }


}