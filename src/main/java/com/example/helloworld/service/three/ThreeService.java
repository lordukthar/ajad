package com.example.helloworld.service.three;


import com.example.helloworld.service.one.One;
import rx.Observable;

import java.util.concurrent.Callable;

public interface ThreeService {

    Three getThree(final One one);

    Callable<Three> getThreeCallable(final One one);

    Observable<Three> observeThree(final One one);

    static ThreeService newInstance() {
        return new ThreeServiceImpl();
    }

}