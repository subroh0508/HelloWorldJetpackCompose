package net.subroh0508.helloworldjetpackcompose

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Dp
import androidx.ui.tooling.preview.Preview
import net.subroh0508.helloworldjetpackcompose.model.IdolModel
import net.subroh0508.helloworldjetpackcompose.ui.HelloWorldJetpackComposeTheme
import net.subroh0508.helloworldjetpackcompose.ui.hexToColor
import net.subroh0508.helloworldjetpackcompose.viewmodel.IdolListViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: IdolListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    IdolListContainer(viewModel = viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()

        viewModel.loadIdols()
    }
}

@Composable
fun IdolListContainer(viewModel: IdolListViewModel) {
    val idols: List<IdolModel> by viewModel.idols.collectAsState(initial = listOf())

    IdolList(idols = idols)
}

@Composable
fun IdolList(idols: List<IdolModel>) {
    LazyColumnFor(
        items = idols,
        modifier = Modifier.fillMaxSize(),
    ) { (_, name, color) -> IdolListItem(name, color.hexToColor()) }
}

@Composable
fun IdolListItem(name: String, color: Color) {
    ConstraintLayout(
        Modifier.fillMaxWidth()
            .padding(Dp(16F))
    ) {
        val (nameRef, colorRef) = createRefs()

        Text(
            name,
            Modifier.constrainAs(nameRef) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(colorRef.top)
                width = Dimension.fillToConstraints
            },
        )
        Text(
            "",
            Modifier.constrainAs(colorRef) {
                top.linkTo(nameRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
            }.background(color),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun IdolListViewPreview() {
    HelloWorldJetpackComposeTheme {
        IdolList(idols = listOf(
            IdolModel(id = "Amami_Haruka", name = "天海春香", color = "#E22B30"),
            IdolModel(id = "Kisaragi_Chihaya", name = "如月千早", color = "#2743D2"),
            IdolModel(id = "Hosii_Miki", name = "星井美希", color = "#B4E04B"),
        ))
    }
}
