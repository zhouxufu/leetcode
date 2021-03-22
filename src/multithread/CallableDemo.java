package multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<String> callable = () -> {
            Thread.sleep(5000);
            return "callable";
        };


        test1(callable);
        test2(callable);



    }

    public static void test1(Callable callable) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(callable);
        System.out.println(submit.isDone());
        System.out.println(submit.get());
        System.out.println(submit.isDone());
    }


    public static void test2(Callable callable){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(callable);
        System.out.println("test2"+submit.isDone());
        System.out.println("test2"+submit.cancel(false));
        System.out.println("test2"+submit.isDone());
    }

}
