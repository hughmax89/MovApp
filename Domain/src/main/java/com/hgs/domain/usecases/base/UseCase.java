package com.hgs.domain.usecases.base;

import com.hgs.domain.interface_adapters.PostExecutionThread;
import com.hgs.domain.interface_adapters.ThreadExecutor;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Use cases are the entry points to the domain layer.
 *
 * @param <Q> the request type
 * @param <P> the response type
 */
public abstract class UseCase<Q extends UseCase.RequestValues, P extends UseCase.ResponseValue> {

    private Q mRequestValues;

    private final ThreadExecutor threadExecutor;

    private final PostExecutionThread postExecutionThread;

    private final CompositeDisposable compositeDisposable;

    protected UseCase(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
        compositeDisposable = new CompositeDisposable();
    }

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public Q getRequestValues() {
        return mRequestValues;
    }

    public void execute(DisposableObserver<P> observer, Q requestValues) {
        final Observable<P> observable = this.createObservableUseCase(requestValues)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.getScheduler());

        DisposableObserver observerDisposable = observable.subscribeWith(observer);
        addDisposable(observerDisposable);
    }

    /**
     * Dispose from current {@link CompositeDisposable}.
     */
    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    /**
     * Builds an {@link io.reactivex.Observable} which will be used when executing the current {@link UseCase}.
     */
    protected abstract Observable<P> createObservableUseCase(Q requestValues);

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    /**
     * Data passed to a request.
     */
    public interface RequestValues {
    }

    /**
     * Data received from a request.
     */
    public interface ResponseValue {
    }
}
