package me.sv.exhibitions.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import me.sv.exhibitions.App
import me.sv.exhibitions.repository.ExhibitsRepository
import me.sv.model.Exhibit
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class ExhibitsActivityVM(application: Application) : AndroidViewModel(application), KodeinAware {
    override val kodein by (application as App).kodein
    override val kodeinContext = kcontext(application)

    private val repository: ExhibitsRepository by instance()

    private val job = Job()
    private val ioScope = CoroutineScope(Dispatchers.IO + job)

    private val _exhibitsListLiveData: MutableLiveData<List<Exhibit>> = MutableLiveData()

    /*Access as LiveData to prevent modification outside*/
    val exhibitsListLiveData: LiveData<List<Exhibit>>
        get() = _exhibitsListLiveData

    init {
        loadExhibitsList()
    }

    private fun loadExhibitsList() {
        ioScope.launch {
            val exhibitsList = repository.getExhibitsListAsync().await()
            withContext(Dispatchers.Main + job) {
                _exhibitsListLiveData.value = exhibitsList
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}