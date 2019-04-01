package me.sv.fileexhibitsloader

import android.content.Context
import com.google.gson.Gson
import me.sv.fileexhibitsloader.models.ExhibitsListModel
import me.sv.fileexhibitsloader.utils.EXHIBITS_FILE_NAME
import me.sv.fileexhibitsloader.utils.getJsonFromAssets
import me.sv.model.Exhibit
import me.sv.model.ExhibitsLoader

class FileExhibitsLoader(private val context: Context) : ExhibitsLoader {

    override fun getExhibitList(): List<Exhibit>? {
        val jsonStr = getJsonFromAssets(context, EXHIBITS_FILE_NAME)
        val listModel = Gson().fromJson(jsonStr, ExhibitsListModel::class.java)
        return listModel.list
    }
}