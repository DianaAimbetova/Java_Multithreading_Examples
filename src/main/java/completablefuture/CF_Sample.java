package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Diana_Aimbetova on 1/5/2020
 **/

public class CF_Sample {
    private static final String GALILEO = "Galileo";

    public static void main(String[] args) {
        CompletableFuture<String> cf = new CompletableFuture<>();
        System.out.println(cf.isDone());

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            cf.complete("Go to the stars, boys.");
        });

        if(cf.getNow(GALILEO).equals(GALILEO)){
            if(!cf.isCancelled()){
                cf.cancel(false);
            }
        } else{
            System.out.println(cf.getNow("Kopernik"));
        }
    }
}
