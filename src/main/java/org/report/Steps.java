package org.report;

import lombok.SneakyThrows;

public abstract class Steps {

    @SneakyThrows
    public static void given(String description, ThrowingRunnable action) {
        System.out.println("Given " + description);
        action.run();
    }


    @SneakyThrows
    public static <T> T given(String description, ThrowingSupplier<T> action) {
        System.out.println("Given " + description);
        return action.get();
    }

    @SneakyThrows
    public static <T> T and(String description, ThrowingSupplier<T> action) {
        System.out.println("And " + description);
        return action.get();
    }

    @SneakyThrows
    public static void and(String description, ThrowingRunnable action) {
        System.out.println("And " + description);
        action.run();
    }

    @SneakyThrows
    public static void when(String description, ThrowingRunnable action) {
        System.out.println("When " + description);
        action.run();
    }

    @SneakyThrows
    public static <T> T when(String description, ThrowingSupplier<T> action) {
        System.out.println("When " + description);
        return action.get();
    }

    @SneakyThrows
    public static void then(String description, ThrowingRunnable action) {
        System.out.println("Then " + description);
        action.run();
    }

}
