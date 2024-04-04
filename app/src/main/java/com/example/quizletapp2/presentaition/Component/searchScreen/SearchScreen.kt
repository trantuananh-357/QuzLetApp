package com.example.quizletapp2.presentaition.Component.searchScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.quizletapp2.R
import dagger.hilt.android.lifecycle.HiltViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, searchViewModel: SearchViewModel = hiltViewModel()){
    val titleTopic  = searchViewModel.searchText.collectAsState()
    val topicCards by searchViewModel.topicCards.collectAsState()
    val active  = remember {
        mutableStateOf(true)
    }
    val historys = remember {
        mutableListOf(
            "None"
        )
    }
    Scaffold (
        topBar = {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                if(active.value){

                }
                else{
                    IconButton(onClick = { navController.navigateUp()}) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.arrow_left_solid),
                            contentDescription = "backpress" )
                    }
                }
                SearchBar(
                    query = titleTopic.value,
                    onQueryChange = {
                           searchViewModel.onSearchTextChange(it)
                    },
                    onSearch = {
                        historys.add(titleTopic.value)
                        active.value = false
                    },
                    active = active.value,
                    onActiveChange = {
                        active.value = it
                    },
                    modifier = Modifier
                        .padding()
                        .fillMaxWidth(),
                    leadingIcon ={

                        IconButton(
                            onClick = {},
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.magnifying_glass_solid),
                                contentDescription = "search"
                            )

                        }
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                if(titleTopic.value.isNotEmpty()){
                                    searchViewModel.onSearchTextChange("")
                                }
                                else{
                                    active.value = false
                                }
                            }) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.xmark_solid),
                                contentDescription = "close"
                            )
                        }
                    }
                ) {
                    topicCards.forEach{topicCard ->
                        Row (
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = topicCard.subject,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }

                    }


                    historys.forEach{
                        Row (
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.clock_rotate_left_solid),
                                contentDescription = "history search"
                            )
                            Text(
                                text = it,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }

                    }
                }
            }



        }


    ){
        Divider(modifier = Modifier.padding(it))

    }


        


}