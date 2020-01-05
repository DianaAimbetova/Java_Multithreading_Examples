package completablefuture;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Diana_Aimbetova on 1/5/2020
 **/

public class CF_Sample3 {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return "Sputnik with dogs";
        }).thenApplyAsync(s -> {
            System.out.println(Thread.currentThread().getName());
            return s += ": Belka";
        }).thenApply(s -> {
            System.out.println(Thread.currentThread().getName());
            return s += " & Strelka";
        }).thenAcceptAsync(System.out::println);

        CompletableFuture.supplyAsync(() -> "Sputnik with cats")
                .thenApplyAsync(s -> s += "Meow")
                .thenApplyAsync(s -> s+=" Meoooooooooow")
                .thenRunAsync(() -> {
                    System.out.println("Nobody knows about heroic cats");
                });
    }
}
