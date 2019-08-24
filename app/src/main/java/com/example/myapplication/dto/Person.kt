package com.example.myapplication.dto

import io.reactivex.Observable
import java.util.concurrent.Callable

class Person {

    var firstName: String = "DEFAULT"

    fun getPersonObservable(): Observable<String> {
        return Observable.just(firstName)
    }

    fun getPersonDefferObservable(): Observable<String> {
        return Observable.defer<String> {
            Observable.just(firstName)
        }
    }
}