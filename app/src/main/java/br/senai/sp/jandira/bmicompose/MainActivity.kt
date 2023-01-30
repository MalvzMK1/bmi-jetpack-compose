package br.senai.sp.jandira.bmicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmicompose.ui.theme.BMIComposeTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BMIComposeTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          BmiCalculator()
        }
      }
    }
  }
}

@Composable
fun Header() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(top = 8.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painterResource(id = R.drawable.health_icon),
      contentDescription = "App Logo",
      modifier = Modifier.size(100.dp)
    )
    Text(
      text = stringResource(id = R.string.app_title).uppercase(),
      color = Color.Blue,
      fontSize = 32.sp,
      letterSpacing = 6.sp,
      textAlign = TextAlign.Center
    )
  }
}

@Preview
@Composable
fun HeaderPreview() {
  Header()
}

@Composable
fun Main() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Column() {
      var weight by rememberSaveable() { mutableStateOf("") }
      var height by rememberSaveable() { mutableStateOf("") }
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = stringResource(id = R.string.weight_label),
          modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
          value = weight,
          onValueChange = { weight = it },
          Modifier
            .fillMaxWidth(),
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
          singleLine = true,
          shape = RoundedCornerShape(16.dp)
        )
      }
      Spacer(
        modifier = Modifier.height(16.dp)
      )
      Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
      ) {
        Text(
          text = stringResource(id = R.string.height_label),
          modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
          value = height,
          onValueChange = { height = it },
          Modifier
            .fillMaxWidth(),
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
          singleLine = true,
          shape = RoundedCornerShape(16.dp)
        )
      }
    }
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 36.dp),
      shape = RoundedCornerShape(16.dp),
      colors = ButtonDefaults.buttonColors(Color(40, 150, 30))
    ) {
      Text(
        stringResource(id = R.string.button_text_calculate).uppercase(),
        color = Color.White,
        fontSize = 24.sp
      )
    }
    Spacer(
      modifier = Modifier.height(8.dp)
    )
  }
}

@Composable
fun Footer() {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(.7f),
    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
    backgroundColor = Color.Blue,
    contentColor = Color.White
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "Your Score",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = "0.00",
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
      )
      Text(
        text = "Congratulations! Your weight is ideal!",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
      )
      Spacer(
        modifier = Modifier.height(8.dp)
      )
      Row() {
        Button(onClick = { /*TODO*/ }) {
          Text(text = stringResource(id = R.string.reset))
        }
        Spacer(
          modifier = Modifier.width(8.dp)
        )
        Button(onClick = { /*TODO*/ }) {
          Text(text = stringResource(id = R.string.share))
        }
      }
    }
  }
}

@Preview
@Composable
fun FooterPreview() {
  Footer()
}

@Composable
fun BmiCalculator() {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceBetween
  ) {
    Header()
    Main()
    Footer()
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BmiComposePreview() {
  BMIComposeTheme {
    Surface(
      modifier = Modifier
        .fillMaxSize(),
      color = MaterialTheme.colors.background
    ) {
      BmiCalculator()
    }
  }
}
