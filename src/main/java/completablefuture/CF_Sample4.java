package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Diana_Aimbetova on 1/5/2020
 **/

public class CF_Sample4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> "Yuri Gagarin", executorService)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> "German Titov"), (s1, s2) -> {
                    System.out.println(Thread.currentThread().getName());
                    CompletableFuture.runAsync(() -> {
                        try {
                            Thread.sleep(1000);
                        }catch (InterruptedException ex){
                            ex.printStackTrace();
                        }
                        System.out.println("Korolev thinking in: " + Thread.currentThread().getName());
                    });
                    return pickYuri(s1, s2);
                }, executorService)
                .thenCombineAsync(CompletableFuture.supplyAsync(() -> "Grigori Nelubov"), (s1, s2) -> {
                    System.out.println(Thread.currentThread().getName());
                    return pickYuri(s1, s2);
                })
                .thenApply(s -> {
                    System.out.println(Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .thenAcceptAsync(s -> System.out.println("First man is space is: " + s ), executorService);

        System.out.println(cf.isDone());


    }

    private static String pickYuri(String s1, String s2) {
        return "Yuri Gagarin";
    }
}
