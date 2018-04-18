package com.bow.cloud.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.hystrix.metric.consumer.HystrixDashboardStream;
import com.netflix.hystrix.serial.SerialHystrixDashboardData;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @author vv
 * @since 2018/4/18.
 */
public class DashBoardDemo {

    /**
     * 开始监听
     * @see HystrixMetricsStreamServlet
     */
    public void beginListen(){
        Observable<HystrixDashboardStream.DashboardData> sampleStream = HystrixDashboardStream.getInstance().observe();
        Observable<String> stringObservable = sampleStream.concatMap(dashboardData -> Observable.from(SerialHystrixDashboardData.toMultipleJsonStrings(dashboardData)));

        stringObservable.observeOn(Schedulers.io()).subscribe(sampleDataAsString -> {
            System.out.println(sampleDataAsString);
        });
    }

    public static void main(String[] args) {
        DashBoardDemo demo = new DashBoardDemo();
        demo.beginListen();

        while(true){
            SimpleCommand command = new SimpleCommand();
            String result = command.execute();
            System.out.println("result "+result);
        }

    }
}
