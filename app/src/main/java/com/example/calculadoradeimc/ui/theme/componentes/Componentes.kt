package com.example.calculadoradeimc.ui.theme.componentes

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun InputTexts(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    maxLine: Int = 1,
    onTextChange: (String) -> Unit,
    onImeAction: () -> Unit = {},

        ){

    val keyBoardController = LocalSoftwareKeyboardController.current


    OutlinedTextField(value = text,
        onValueChange = onTextChange,
    colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent),
    maxLines = maxLine,
    label = { Text(text = label) },
    keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions( onDone = {
            onImeAction()
            keyBoardController?.hide()
        } ),
        modifier = modifier
            .padding(top = 5.dp
            )
    )
}

@Composable
fun GenericButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true ) {


    Button(onClick = onClick,
    shape = RectangleShape,
    enabled = enabled,
    modifier = modifier) {

        Text( text,
       fontSize = 17.sp)

    }

}