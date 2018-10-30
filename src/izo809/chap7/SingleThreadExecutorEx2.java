package izo809.chap7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorEx2 {

    public static void main(String[] args) {

        ExecutorService service = null;
        try {
            System.out.println("Runtime.getRuntime().availableProcessors(): " + Runtime.getRuntime().availableProcessors());

            service = Executors.newSingleThreadExecutor();
            System.out.println("begin");

            service.execute(() -> System.out.println("Printing zoo inventory"));

            service.execute(() -> {
                for (int i = 0; i < 100; i++)
                    System.out.print("Printing record: " + i);
            });

            service.execute(() -> System.out.println("Printing zoo inventory"));

            System.out.println("end");

        } finally {

            System.out.println("finally");
            if (service != null)
                service.shutdown();
            //System.out.println("not executed: " + service.shutdownNow());

            System.out.println("shutdown: " + service.isShutdown() + ", terminated: " + service.isTerminated());
            service.execute(() -> System.out.println("Printing zoo inventory after shutdown"));
            System.out.println("shutdown: " + service.isShutdown() + ", terminated: " + service.isTerminated());
        }

    }

}
