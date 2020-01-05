package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Diana_Aimbetova on 1/5/2020
 **/

public class CF_Sample2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            return "Sputnik";
        });
        System.out.println(cf.get());


        CompletableFuture<Integer> speed = CompletableFuture.supplyAsync(() -> 1)
                .thenApplyAsync(x -> x * 7)
                .thenApply(x -> x + 1);

        System.out.println("Speed: " + speed.get());

    }

}
