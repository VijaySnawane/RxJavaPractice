package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.observable.FlowableActivity
import com.example.myapplication.observable.SingleObservableActivity
import com.example.myapplication.operators.DeferOperatorActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity :AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            btn1.id -> startActivity(Intent(this,DeferOperatorActivity::class.java))
            btn2.id -> startActivity(Intent(this,FlowableActivity::class.java))
            btn3.id -> startActivity(Intent(this,SingleObservableActivity::class.java))
            else -> println("Number too high")
        }
    }
}