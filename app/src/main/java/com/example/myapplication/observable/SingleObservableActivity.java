package com.example.myapplication.observable;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class SingleObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerExample();
        mapExample();
        zipExample();
        bufferExample();
        takeExample();
        reduceExample();
        filterExample();
        skipExample();
        concatExample();
        mergeExample();
        switchMapExample();
        intervalExample();
    }

    private void intervalExample() {

        Observable.interval(0, 2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {
                Log.i("--->", aLong.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void switchMapExample() {

        get123Int()
                .switchMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) {
                        int delay = new Random().nextInt(2);

                        return Observable.just(integer.toString() + "x")
                                .delay(delay, TimeUnit.SECONDS,
                                        Schedulers.io());
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String strings) {
                        Log.i("--->", strings.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void mergeExample() {

        Observable.merge(get123(), getAbc()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        Log.i("--->", strings.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void concatExample() {
        Observable.concat(getAbc(), get123()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        Log.i("--->", strings.toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void skipExample() {

        Observable.just(11, 42, 63, 64, 75, 66, 27, 18, 89, 103).skip(5).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("--->", integer.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void filterExample() {
        Observable.just(11, 42, 63, 64, 75, 66, 27, 18, 89, 103).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Exception {
                return integer % 3 == 0;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                Log.i("--->", integer.toString());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void reduceExample() {
        Observable.just("Vijat", "Radhakisan", "Sonawane").reduce(new BiFunction<String
                , String, String>() {
            @Override
            public String apply(String s, String s2) throws Exception {
                return s.concat(" ").concat(s2);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(String strings) {
                        Log.i("--->", "" + strings);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void takeExample() {

        Observable.just("1", "2", "3", "4", "5", "6").take(3).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String strings) {
                Log.i("--->", "" + strings);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void bufferExample() {

        Observable.just("1", "2", "3", "4", "5", "6").buffer(3).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                Log.i("--->", "" + strings);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void zipExample() {
        Observable.zip(getAbc(), get123(), new BiFunction<List<String>,
                List<String>, List<String>>() {
            @Override
            public List<String> apply(List<String> strings,
                                      List<String> strings2) throws Exception {
                List<String> combineList = new ArrayList<>();
                combineList.addAll(strings);
                combineList.addAll(strings2);
                return combineList;
            }
        }).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<String> strings) {
                Log.i("--->", "" + strings);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    private Observable<Integer> get123Int() {
        return Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9);

    }

    private Observable<List<String>> get123() {
        return Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> e) {
                if (!e.isDisposed()) {
                    List<String> intee = new ArrayList<>();
                    intee.add("1");
                    intee.add("2");
                    intee.add("3");
                    intee.add("4");
                    e.onNext(intee);
                    e.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());
    }

    private Observable<List<String>> getAbc() {
        return Observable.create(new ObservableOnSubscribe<List<String>>() {
            @Override
            public void subscribe(ObservableEmitter<List<String>> e) throws Exception {
                if (!e.isDisposed()) {
                    List<String> intee = new ArrayList<>();
                    intee.add("A");
                    intee.add("B");
                    intee.add("C");
                    intee.add("D");
                    e.onNext(intee);
                    e.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());
    }


    private void mapExample() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                if (!emitter.isDisposed()) {
                    emitter.onNext("Vijay");
                    emitter.onComplete();
                }
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String s) throws Exception {
                return s.concat("Sonawane");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("", "" + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void timerExample() {

        Completable completable = Completable.timer(10000,
                TimeUnit.MILLISECONDS);

        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i("-->", "onSubscribe");
            }

            @Override
            public void onComplete() {
                Log.i("-->", "onComplete");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("-->", "onError");
            }
        });

    }
}
