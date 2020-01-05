package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Diana_Aimbetova on 1/5/2020
 **/

public class CF_Sample5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> ussrMoon = CompletableFuture.supplyAsync(() -> "USSR")
                .thenApplyAsync(s -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    s += " are Moon communists.";
                    return s;
                });

        CompletableFuture<String> usaMoon = CompletableFuture.supplyAsync(() -> "USA")
                .thenApply(s -> s+= " will build first Moon base.");

        ussrMoon.acceptEitherAsync(usaMoon, System.out :: println);
    }
}
