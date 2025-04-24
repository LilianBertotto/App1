

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    Box(
        modifier = modifier.height(200.dp)

    ) {
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
    curtida: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row {
        IconButton(
            onClick = curtida
        ) {
            Icon(
                imageVector = if(like) Icons.Filled.FavoriteBorder else Icons.Filled.Favorite,
                contentDescription = "Ícone de curtida",
                tint = if(like) Color.Black else Color.Red
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

// Componente para controle de estado
@Composable
fun PostIconsState(
    modifier: Modifier = Modifier
) {
    var changeLike by remember {
        mutableStateOf(false)
    }

    PostIcons(
        like = changeLike,
        curtida = { changeLike = !changeLike }
    )

}

@Composable
fun PostText(
    text: String,
    modifier: Modifier = Modifier
) {
    Box{
        Text(
            text = text,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis

        )
    }
}

@Composable
fun PostPage(
    @DrawableRes imageProfile: Int,
    nameProfile: String,
    timeProfile: String,
    @DrawableRes imagePost: Int,
    textPost: String,
    modifier: Modifier = Modifier

){
    Column {
        ProfileName(
            image = imageProfile,
            name = nameProfile,
            time = timeProfile
        )

        Post(image = imagePost)

        PostIconsState()

        PostText(text = textPost)
    } // Column
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
        PostIconsState()
    }
}
@Preview(showBackground = true)
@Composable
fun PostTextPreview() {
    RedeAntiSocial2Theme {
        PostText(
            text = "Um homem bateu em minha porta e eu abri, senhoras e senhores poe a mão no chão, senhoras e senhores dê uma voltinha e vai parar no olho da rua"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PostPagePreview() {
    RedeAntiSocial2Theme {
        PostPage(
            imageProfile = R.drawable.oliviapalito,
            nameProfile = "Olivia_Palito",
            timeProfile = "30 Minutos Atras",
            imagePost = R.drawable.oliviapalito,
            textPost = "Um homem bateu em minha porta e eu abri, senhoras e senhores poe a mão no chão, senhoras e senhores dê uma voltinha e vai parar no olho da rua"


        )
    }

}

