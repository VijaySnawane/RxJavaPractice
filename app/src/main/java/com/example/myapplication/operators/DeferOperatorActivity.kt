package com.example.myapplication.operators

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.dto.Person
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class DeferOperatorActivity : AppCompatActivity() {

    var mPerson : Person?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener(View.OnClickListener { doSomeWork() })

    }

    private fun doSomeWork() {

        mPerson = Person()

        var normalObserverble: Observable<String>? = mPerson?.getPersonObservable()
        var deferObservable: Observable<String>? = mPerson?.getPersonDefferObservable()
        var deferObservable2: Observable<String>? = mPerson?.getPersonDefferObservable()

        mPerson?.firstName = "Vijay"

        normalObserverble?.subscribe(getObserver());

        deferObservable?.subscribe(getObserver());

        mPerson?.firstName = "Vijay Sonawane"

        deferObservable2?.subscribe(getObserver());


    }

    fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(value: String) {
                textView.append(" onNext : value : $value")
                textView.append("/\n")
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

        }
    }
}