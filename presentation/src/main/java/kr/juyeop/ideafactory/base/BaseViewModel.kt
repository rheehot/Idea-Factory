package kr.juyeop.ideafactory.base

import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

open class BaseViewModel : ViewModel() {

    private val disposable = CompositeDisposable()

    fun addDisposable(single : Single<*>, observer : DisposableObserver<*>){
        disposable.add(single.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribeWith(observer as SingleObserver<Any>) as Disposable)
    }
    fun addDisposable(completable : Completable, observer : DisposableCompletableObserver){
        disposable.add(completable.subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread()).subscribeWith(observer))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}