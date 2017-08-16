package com.example.helloworld.service.two;


import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;

public class TwoCommand extends HystrixObservableCommand<Two> {

    private TwoService twoService;

    public TwoCommand(TwoService twoService) {
        super(HystrixCommandGroupKey.Factory.asKey("TwoCommand"));
        this.twoService = twoService;
    }

    @Override
    protected Observable<Two> construct() {
        return twoService.observeTwo();
    }

    @Override
    protected Observable<Two> resumeWithFallback() {
        return Observable.just(new Two("This is a fallback"));
    }
}
