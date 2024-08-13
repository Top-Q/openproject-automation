package org.report;

@FunctionalInterface
public interface ThrowingRunnable {
    void run() throws Exception;
}
