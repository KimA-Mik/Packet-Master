package ru.kima.packetmaster.ui.feature.shifts.list

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.collections.immutable.persistentListOf
import org.koin.androidx.compose.koinViewModel
import ru.kima.packetmaster.R
import ru.kima.packetmaster.domain.shift.model.Shift
import ru.kima.packetmaster.ui.util.LocalSnackbarHostState
import ru.kima.packetmaster.ui.util.preview.PMPreview

@Composable
fun ShiftListScreen() {
    val viewModel: ShiftListViewModel = koinViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    ShiftListScreenContent(
        state = state
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ShiftListScreenContent(
    state: ShiftListState
) {
    val snackbarHostState = LocalSnackbarHostState.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.title_shifts)) }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.add_24px),
                    contentDescription = null
                )
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(state.shifts, key = { it.id }) {
                ShiftListItem(
                    shift = it,
                    editClicked = { /* TODO */ },
                    deleteClicked = { /* TODO */ }
                )
            }
        }
    }
}

@Composable
private fun ShiftListItem(
    shift: Shift,
    editClicked: (Long) -> Unit,
    deleteClicked: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = shift.name,
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = { deleteClicked(shift.id) }) {
            Icon(
                painter = painterResource(R.drawable.delete_24px),
                contentDescription = null
            )
        }

        IconButton(onClick = { editClicked(shift.id) }) {
            Icon(
                painter = painterResource(R.drawable.edit_24px),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun ShiftListPreview() = PMPreview {
    ShiftListScreenContent(
        state = ShiftListState(
            shifts = persistentListOf(
                Shift(id = 1, name = "Смена 1"),
                Shift(id = 2, name = "Смена 2"),
                Shift(id = 3, name = "Смена 3"),
            )
        )
    )
}