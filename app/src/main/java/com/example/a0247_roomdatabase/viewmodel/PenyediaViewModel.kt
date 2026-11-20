package com.example.a0247_roomdatabase.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.a0247_roomdatabase.AplikasiSiswa

object PenyediaViewModel {

    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EntryViewModel(
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }

        initializer {
            EditViewModel(
                this.createSavedStateHandle(),
                aplikasiSiswa().container.repositoriSiswa
            )
        }
    }
}

/**
 * Fungsi ekstensi untuk mengambil objek Application
 * dan mengembalikan instance AplikasiSiswa.
 */
fun CreationExtras.aplikasiSiswa(): AplikasiSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiSiswa)
