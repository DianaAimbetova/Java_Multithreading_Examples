package forkjoinwithjava8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Diana_Aimbetova 
 */
public class FibonacciTask extends RecursiveTask {
    private Integer fibIndex;
    private static AtomicInteger taskCounter = new AtomicInteger(0);

    private Map<Integer, Integer> fibMap = new HashMap<>();

    {
        fibMap.put(0,0);
        fibMap.put(1,1);
        fibMap.put(2,1);
        fibMap.put(3,2);
        fibMap.put(4,3);
    }

    public FibonacciTask(Integer fibIndex) {
        this.fibIndex = fibIndex;
    }

    public static AtomicInteger getTaskCounter() {
        return taskCounter;
    }

    @Override
    protected Integer compute(){

        if(fibMap.containsKey(fibIndex)){
            return fibMap.get(fibIndex);
        }

        final FibonacciTask task1 = new FibonacciTask(fibIndex-1);
        task1.fork();
        taskCounter.getAndIncrement();

        final FibonacciTask task2 = new FibonacciTask(fibIndex - 2);
        Integer result2  = task2.compute();
        taskCounter.getAndIncrement();

        Integer result1 = (Integer) task1.join();

        Integer result = result1 + result2;
        /*try{
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }*/
        System.out.println("Intermediate result is: " + result + " from thread: " + Thread.currentThread().getName());
        return result;
    }
}
