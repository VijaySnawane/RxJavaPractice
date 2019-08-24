package com.example.myapplication.observable;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class SingleObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Single.just("Vijay").subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("",""+d);
            }

            @Override
            public void onSuccess(String s) {
                Log.i("",""+s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("",""+e);
            }
        });
    }
}
