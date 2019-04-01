package me.sv.exhibitions

import android.app.Application
import me.sv.exhibitions.repository.ExhibitsRepository
import me.sv.exhibitions.repository.ExhibitsRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class App : Application(), KodeinAware {
    override val kodein by Kodein.lazy {
        import(androidXModule(this@App))
        bind<ExhibitsRepository>() with singleton { ExhibitsRepositoryImpl(applicationContext) }
    }
}