package future;

import java.util.concurrent.*;

/**
 * @author Diana_Aimbetova
 */
public class FutureSample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> Jules_Verne = () -> {
            System.out.println("The romance was written.");
            return "De la terra a la lune";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> firstTripOutTheEarth = executorService.submit(Jules_Verne);

        System.out.println(firstTripOutTheEarth.isDone());

        Thread.sleep(1000);

        System.out.println(firstTripOutTheEarth.isDone());
        System.out.println(firstTripOutTheEarth.get());
    }
}
