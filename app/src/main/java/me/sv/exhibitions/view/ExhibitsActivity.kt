package me.sv.exhibitions.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import me.sv.exhibitions.R
import me.sv.exhibitions.view.adapters.ExhibitsListAdapter
import me.sv.exhibitions.viewModel.ExhibitsActivityVM
import me.sv.model.Exhibit

class ExhibitsActivity : AppCompatActivity() {
    private lateinit var viewModel: ExhibitsActivityVM
    private var exhibitsListAdapter: ExhibitsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ExhibitsActivityVM::class.java)
        subscribeToExhibitsList()
    }

    private fun subscribeToExhibitsList() {
        viewModel.exhibitsListLiveData.observe(this, Observer<List<Exhibit>> {
            updateList(it)
        })
    }

    private fun updateList(exhibits: List<Exhibit>?) {
        exhibits?.let {
            if (exhibitsListAdapter == null) {
                exhibitsListAdapter = ExhibitsListAdapter()
                rvExhibits.layoutManager = LinearLayoutManager(this)
                rvExhibits.adapter = exhibitsListAdapter
                rvExhibits.setHasFixedSize(true)

            }
            exhibitsListAdapter?.setList(it)
        }
    }
}
