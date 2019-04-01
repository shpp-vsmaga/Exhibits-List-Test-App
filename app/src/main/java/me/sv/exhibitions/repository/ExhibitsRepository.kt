package me.sv.exhibitions.repository

import kotlinx.coroutines.Deferred
import me.sv.model.Exhibit

interface ExhibitsRepository {
    fun getExhibitsListAsync(): Deferred<List<Exhibit>?>
}