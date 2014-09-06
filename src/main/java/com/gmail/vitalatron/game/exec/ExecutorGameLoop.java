package com.gmail.vitalatron.game.exec;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorGameLoop extends AbstractTimedLoop {
    protected Executor executor = Executors.newSingleThreadExecutor();
    protected long lastExecutionNanoTime;

    protected Runnable loop = new Runnable() {
        @Override
        public void run() {
            while (!stopped) {
                long t = System.nanoTime();
                double delta = ((t - lastExecutionNanoTime) / 1000000) / (double) delay;

                for (GameTask task : tasks) {
                    task.execute(delta);
                }

                lastExecutionNanoTime = System.nanoTime();
                t = (lastExecutionNanoTime - t) / 1000000;

                try {
                    Thread.sleep((delay - t < 0) ? 0 : delay - t);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    };

    public ExecutorGameLoop() {
        lastExecutionNanoTime = System.nanoTime();
        executor.execute(loop);
    }
}
