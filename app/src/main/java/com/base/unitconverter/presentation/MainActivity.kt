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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.base.unitconverter.R
import com.base.unitconverter.ui.theme.UnitConverterTheme
import com.base.unitconverter.userinterfaceutils.HeightSpacer
import com.base.unitconverter.userinterfaceutils.MyAppButton
import com.base.unitconverter.userinterfaceutils.MyAppOutlineTextField
import com.base.unitconverter.userinterfaceutils.TextWithColon
import com.base.unitconverter.userinterfaceutils.TitleBold
import com.base.unitconverter.userinterfaceutils.TitleMedium

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
                    UnitConverter()
                }
            }
        }
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

        val isDropDownExpanded1 = remember {
            mutableStateOf(false)
        }

        val buttonText1 = remember {
            mutableIntStateOf(R.string.select)
        }

        val isDropDownExpanded2 = remember {
            mutableStateOf(false)
        }

        val buttonText2 = remember {
            mutableIntStateOf(R.string.select)
        }

        TitleBold(text = stringResource(id = R.string.unit_converter))

        HeightSpacer(height = 10)
        MyAppOutlineTextField(placeholder = stringResource(id = R.string.enter_value))
        HeightSpacer(height = 10)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        ) {

            Box {
                MyAppButton(stringResource(id = buttonText1.value), cornerShape = 10) {
//onCLick
                    isDropDownExpanded1.value = true
                }

                DropdownMenu(expanded = isDropDownExpanded1.value, onDismissRequest = { }) {
                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.centimeter)) },
                        onClick = {
                            isDropDownExpanded1.value = false
                            buttonText1.intValue = R.string.centimeter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.meter)) },
                        onClick = {
                            isDropDownExpanded1.value = false
                            buttonText1.intValue = R.string.meter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.millimeter)) },
                        onClick = {
                            isDropDownExpanded1.value = false
                            buttonText1.intValue = R.string.millimeter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.feet)) },
                        onClick = {
                            isDropDownExpanded1.value = false
                            buttonText1.intValue = R.string.feet
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.inch)) },
                        onClick = {
                            isDropDownExpanded1.value = false
                            buttonText1.intValue = R.string.inch
                        })
                }
            }


            Box {
                MyAppButton(stringResource(id = buttonText2.value), cornerShape = 10) {
//onCLick
                    isDropDownExpanded2.value = true

                }

                DropdownMenu(expanded = isDropDownExpanded2.value, onDismissRequest = { }) {
                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.centimeter)) },
                        onClick = {
                            isDropDownExpanded2.value = false
                            buttonText2.intValue = R.string.centimeter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.meter)) },
                        onClick = {
                            isDropDownExpanded2.value = false
                            buttonText2.intValue = R.string.meter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.millimeter)) },
                        onClick = {
                            isDropDownExpanded2.value = false
                            buttonText2.intValue = R.string.millimeter
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.feet)) },
                        onClick = {
                            isDropDownExpanded2.value = false
                            buttonText2.intValue = R.string.feet
                        })

                    DropdownMenuItem(
                        text = { TitleMedium(text = stringResource(id = R.string.inch)) },
                        onClick = {
                            isDropDownExpanded2.value = false
                            buttonText2.intValue = R.string.inch
                        })
                }

            }
        }

        HeightSpacer(height = 10)

        TextWithColon(text = stringResource(id = R.string.result))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}