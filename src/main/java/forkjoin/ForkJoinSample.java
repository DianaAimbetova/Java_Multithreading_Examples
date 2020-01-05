package forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * @author Diana_Aimbetova
 */
public class ForkJoinSample {
    public static final Integer FIB_INDEX = 20;

    public static void main(String[] args) throws InterruptedException {
        final ForkJoinPool pool = new ForkJoinPool();
        FibonacciTask task = new FibonacciTask(FIB_INDEX);

        // Integer fibNumber = (Integer) pool.invoke(task);
        // System.out.println("Fibonacci Number: " + fibNumber + " with index: " + FIB_INDEX);
        pool.execute(task);
        do {
            System.out.println("Parallelism: " + pool.getParallelism());
            System.out.println("Pool size: " + pool.getPoolSize());
            System.out.println("Queued task count: " + pool.getQueuedTaskCount());
            Thread.sleep(1000);
        }while(!task.isDone());
        System.out.println("# of task counter is: " + FibonacciTask.getTaskCounter());
    }

}
