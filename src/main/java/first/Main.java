package first;

import first.CommandHelloWorld;
import first.CommandHelloWorldObservable;
import rx.Observable;

public class Main {

    public static void main(String[] args){
        String s= new CommandHelloWorld("Carlos").execute();
        System.out.println(s);

        Observable<String> observable=new CommandHelloWorldObservable("carlos").construct();
        observable.subscribe(emission->System.out.println(emission));
    }
}
