
package br.qi.redeantisocial2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.qi.redeantisocial2.ui.theme.RedeAntiSocial2Theme
import br.qi.redeantisocial2.R
import br.qi.redeantisocial2.ui.theme.RedeAntiSocial2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RedeAntiSocial2Theme {
                // Aqui, vão os códigos
                // que serão o App em si.
            }
        }
    }
}

@Composable
fun ProfileName(
    @DrawableRes image : Int,
    name : String,
    time : String,
    modifier : Modifier = Modifier
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "Foto do perfil",
            contentScale = ContentScale.FillBounds,
            modifier = modifier
                .size(46.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = CircleShape
                )
        )

        Spacer(
            modifier = Modifier.padding(horizontal = 6.dp)
        )

        Column {
            Text(
                text = name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = time,
                color = Color.Gray,
                fontSize = 12.sp
            )
        }
    }
}
@Composable
fun Post(
    @DrawableRes image: Int,
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(id = image),
            contentDescription = "imagem do post",
            modifier = modifier.fillMaxSize()
        )
    }
}

@Composable
fun PostIcons(
    like: Boolean,
    modifier: Modifier = Modifier
) {
    Row {
        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = "Ícone de curtida"
            )

        }

        IconButton(
            onClick = { /*TODO*/ }
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Ícone de comentário"
            )
        }
    }
}
@Composable
fun PostText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box{
        Text(
            text = text,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis

        )
    }
}

//////////////////////////////////////////////////////////////////
@Preview(showBackground = true)
@Composable
fun ProfileNamePreview() {
    RedeAntiSocial2Theme{
        Column {
            ProfileName(
                image = R.drawable.oliviapalito,
                name = "Olivia Palito",
                time = "2 horas atrás"
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PostPreview() {
    RedeAntiSocial2Theme {
        Post(image = R.drawable.oliviapalito)
    }
}
@Preview(showBackground = true)
@Composable
fun PostIconsPreview(){
    RedeAntiSocial2Theme {
        PostIcons(like = true)
    }
}
@Preview(showBackground = true)
@Composable
fun PostTextPreview() {
    RedeAntiSocial2Theme {
        PostText(
            text = "Um homem bateu em minha porta e eu abri, senhoras e senhores poe a mão no chão"
        )
    }

}
