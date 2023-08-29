@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.jetpackcomposeday2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import com.example.jetpackcomposeday2.ui.theme.Jetpackcomposeday2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpackcomposeday2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // scaffold cung cấp định hình cao
                    // gồm 3 tham số
                    // topbar thanh tiêu đề
                    // bottomBar  Nội Dung Điều Hướng
                    // content  nội dung chính  người dùng
//                    Scaffold(
//                        bottomBar = { SootheNavigationRail() }
//                    ) { padding ->
//                        HomeScreen(Modifier.padding(padding))
//                    }

                    HomeScreen()
                }
            }
        }
    }
}
//fun MySootheApp(windowSize: WindowSizeClass) {
//    when (windowSize.widthSizeClass) {
//        WindowWidthSizeClass.Compact -> {
//            SootheNavigationRail()
//        }
//        WindowWidthSizeClass.Expanded -> {
//            SootheNavigationRail()
//        }
//    }
//}

// khởi tạo mảng truyền vào
private val alignYourBodyData = listOf(
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
).map { DrawableStringPair(it.first, it.second) }


// sau đó gắn map vào với drawableStringPair
private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

// khởi tạo thanh search
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
)

{
    var remembersearch by rememberSaveable { mutableStateOf("") }
    TextField(
        value = remembersearch,
        onValueChange = {remembersearch = it},
        leadingIcon = {
            Icon(
                // gắn icon
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        // gắn màu vào với color qua textfieldColors
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
        ),
        placeholder = {
            Text(stringResource(R.string.app_name))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Composable
//  khởi tạo phần tử alignYourBodyElement
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    // gắn     horizontalAlignment = Alignment.CenterHorizontally vào giữa
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            modifier = modifier.paddingFromBaseline(top = 24.dp, bottom = 24.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }

}
// khởi tạo cục  favoriteCollectionCard
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

//  khởi tạo 1 grid gắn cục vào
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp)
    ) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(item.drawable, item.text, Modifier.height(80.dp))
        }
    }
}
// gắn  alginYour vào row
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}
// khởi tạo title với homeSection sau đó gắn phần tử vào
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    // để trống và truyền vào 1 composable vào
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        // truyền cục kahcs vào
        content()
    }
}
// khởi tạo màn hình homeSection
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.app_name) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.app_name) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}
//@Composable
// tạo 1 thanh bottomNavigation
//fun ScootheBottomNavigation(modifier:Modifier = Modifier){
//    NavigationBar(modifier = modifier,
//    containerColor =  MaterialTheme.colorScheme.surfaceVariant) {
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text(
//                    text = "home"
//                )
//            },
//            selected = true,
//            onClick = {}
//        )
//        NavigationBarItem(
//            icon = {
//                Icon(
//                    imageVector = Icons.Default.AccountCircle,
//                    contentDescription = null
//                )
//            },
//            label = {
//                Text(
//                    text = "Profile"
//                )
//            },
//            selected = false,
//            onClick = {}
//        )
//    }
//}

// tạo 1 thanh navigationRailItem


@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.padding(start = 8.dp, end = 8.dp),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                },
                label = {
                   Text(text = "Home")
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = "Profile")
                },
                selected = false,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jetpackcomposeday2Theme {

        // chỉ dùng cho  top  and navbottom
//        Scaffold(
//            bottomBar = { SootheNavigationRail() }
//        ) { padding ->
//            HomeScreen(Modifier.padding(padding))
//        }

        // dùng  nav nghiêng
        SootheNavigationRail()
        HomeScreen()
    }
}