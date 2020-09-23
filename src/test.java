import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import	java.lang.annotation.Annotation;
public class test {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        long startTime = System.currentTimeMillis();
        Set<Class<? extends Animal>> set=new HashSet<> ();
        set.add(Chicken.class);
        set.add(Rabbit.class);
        CompletableFuture<Void> test1 = CompletableFuture.runAsync(() -> {
            Question question = new Cage(15000, 30000, set);
            question.check();
            question.anower();
        });
        CompletableFuture<Void> test2 = CompletableFuture.runAsync(() -> {
            Question question = new Cage(15000, 30000, set);
            question.check();
            question.anower();

        });
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(test1, test2).thenRun(() -> {
            long endTime = System.currentTimeMillis();
            long l = (endTime - startTime) / 1000;
            System.out.println("运行消耗" + l + "秒");
        }).exceptionally(new Function<Throwable, Void>() {
            @Override
            public Void apply(Throwable throwable) {
                throwable.printStackTrace();
                return null;
            }
        });

        voidCompletableFuture.get();
    }
}
