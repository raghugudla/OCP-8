package izo809.chap7;

import java.util.concurrent.*;

public class SingleThreadExecutorEx {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 500; i++)
                    SingleThreadExecutorEx.counter++;
                //return "Reached!";
            });
            Object s = result.get(1, TimeUnit.NANOSECONDS);
            System.out.println("Reached. s = " + s + ", done = " + result.isDone() + ", done = " + result.isCancelled());

        } catch (TimeoutException e) {
            System.out.println("Not reached in time");
        } finally {
            if (service != null)
                service.shutdown();
        }
    }
}
