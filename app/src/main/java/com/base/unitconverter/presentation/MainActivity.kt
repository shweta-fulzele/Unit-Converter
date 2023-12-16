package com.base.unitconverter.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import com.base.unitconverter.R
import com.base.unitconverter.ui.theme.UnitConverterTheme
import com.base.unitconverter.userinterfaceutils.HeightSpacer
import com.base.unitconverter.userinterfaceutils.MyAppButton
import com.base.unitconverter.userinterfaceutils.MyAppOutlineTextField
import com.base.unitconverter.userinterfaceutils.TextWithColon
import com.base.unitconverter.userinterfaceutils.TitleBold
import com.base.unitconverter.userinterfaceutils.TitleMedium
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    var counter by remember { mutableIntStateOf(0) }

    Column {
        println("Composing with counter before: ${counter.component1()}")

        Button(onClick = { counter = counter + 1 }) {
            Text("Increment Counter")
        }

        println("Composing with counter after: ${counter.component1()} ")
    }
}


@Composable
fun UnitConverter() {
    val context = LocalContext.current

    UnitConverterUI(context)
}


@Composable
fun UnitConverterUI(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var inputValue by remember {
            mutableStateOf("")
        }

        var outputValue by remember {
            mutableStateOf("")
        }

        var inputUnit by remember {
            mutableStateOf("Centimeters")
        }

        var outputUnit by remember {
            mutableStateOf("Meters")
        }

        var iExpanded by remember {
            mutableStateOf(false)
        }

        var oExpanded by remember {
            mutableStateOf(false)
        }

        val iConversionFactory = remember {
            mutableStateOf(1.00)
        }

        val oConversionFactory = remember {
            mutableStateOf(1.00)
        }

        fun convertFactory() {
            val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
            val result =
                (inputValueDouble * iConversionFactory.value * 100.0 / oConversionFactory.value).roundToInt() / 100.0
            outputValue = result.toString()
        }

        TitleBold(text = stringResource(id = R.string.unit_converter))
        HeightSpacer(height = 24)
        MyAppOutlineTextField(
            value = inputValue,
            placeholder = stringResource(id = R.string.enter_value)
        ) {
            inputValue = it
            convertFactory()
        }
        HeightSpacer(height = 16)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {

//            Input Box
            Box {

//                Input Button
                MyAppButton(inputUnit, cornerShape = 10) {
//onCLick
                    iExpanded = true
                }

                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.centimeter)) },
                        onClick = {
                            iExpanded = false
                            inputUnit =context.getString(R.string.centimeter)
                            iConversionFactory.value = 0.01
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.meter)) },
                        onClick = {
                            iExpanded = false
                            inputUnit = context.getString(R.string.meter)
                            iConversionFactory.value = 1.00
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.millimeter)) },
                        onClick = {
                            iExpanded = false
                            inputUnit = context.getString(R.string.millimeter)
                            iConversionFactory.value = 0.001
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.feet)) },
                        onClick = {
                            iExpanded = false
                            inputUnit = context.getString(R.string.feet)
                            iConversionFactory.value = 0.3048
                            convertFactory()
                        })

                }
            }

//            Output Box
            Box {
                //                Output Button
                MyAppButton(
                    outputUnit,
                    cornerShape = 10
                ) { oExpanded = true }

                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.centimeter)) },
                        onClick = {
                            oExpanded = false
                            outputUnit = context.getString(R.string.centimeter)
                            oConversionFactory.value = 0.01
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.meter)) },
                        onClick = {
                            oExpanded = false
                            outputUnit = context.getString(R.string.meter)
                            oConversionFactory.value = 1.00
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.millimeter)) },
                        onClick = {
                            oExpanded = false
                            outputUnit = context.getString(R.string.millimeter)
                            oConversionFactory.value = 0.001
                            convertFactory()
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.feet)) },
                        onClick = {
                            oExpanded = false
                            outputUnit =context.getString(R.string.feet)
                            oConversionFactory.value = 0.3048
                            convertFactory()
                        })


                }

            }
        }

        HeightSpacer(height = 20)

        TextWithColon(text = stringResource(id = R.string.result), outputText = "$outputValue $outputUnit")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}