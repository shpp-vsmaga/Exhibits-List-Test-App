package me.sv.fileexhibitsloader.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

fun getJsonFromAssets(context: Context, fileName: String): String? {

    return try {
        val `is` = context.assets.open(fileName)
        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        null
    }
}