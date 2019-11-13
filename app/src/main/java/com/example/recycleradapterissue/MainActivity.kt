package com.example.recycleradapterissue

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val adapter = RecyclerAdapterKt()
        adapter.setData(ItemGenerator.largeListWithHeadersAt())
        adapter.setHasStableIds(true)
        recycler_view.setLayoutManager(LinearLayoutManager(this))
        recycler_view.setAdapter(adapter)

        visibility_button.setOnClickListener{
            adapter.setData(ItemGenerator.largeListWithHeadersAt2())
        }

    }

}
