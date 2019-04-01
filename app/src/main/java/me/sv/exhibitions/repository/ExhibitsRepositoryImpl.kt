package me.sv.exhibitions.repository

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import me.sv.fileexhibitsloader.FileExhibitsLoader
import me.sv.model.Exhibit
import me.sv.model.ExhibitsLoader

class ExhibitsRepositoryImpl(context: Context) : ExhibitsRepository {
    private val loader: ExhibitsLoader = FileExhibitsLoader(context)

    override fun getExhibitsListAsync(): Deferred<List<Exhibit>?> = CoroutineScope(Dispatchers.IO).async {
        loader.getExhibitList()
    }
}