package com.example.a0247_roomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a0247_roomdatabase.repositori.RepositoriSiswa
import com.example.a0247_roomdatabase.room.Siswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(private val repositoriSiswa: RepositoriSiswa) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiswaStream()
        .map { HomeUiState(listSiswa = it.toList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILIS),
            initialValue = HomeUiState()
        )

    fun deleteSiswa(siswa: Siswa) {
        viewModelScope.launch {
            repositoriSiswa.deleteSiswa(siswa)
        }
    }

    data class HomeUiState(
        val listSiswa: List<Siswa> = listOf()
    )
}
