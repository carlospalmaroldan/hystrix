import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class CommandHelloWorldObservable extends HystrixObservableCommand<String> {

    private final String name;

    public CommandHelloWorldObservable(String name){
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name=name;
    }

    @Override
    protected Observable<String> construct(){
        return Observable.create(new Observable.OnSubscribe<String>(){

            @Override
            public void call(Subscriber<? super String> observer){
                if(!observer.isUnsubscribed()){
                    observer.onNext("Hello");
                    observer.onNext(name+"!");
                    observer.onCompleted();
                }
            }

        }).subscribeOn(Schedulers.io());
    }

}
