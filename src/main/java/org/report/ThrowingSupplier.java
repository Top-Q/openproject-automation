package org.report;

@FunctionalInterface
public interface ThrowingSupplier<T> {

    T get() throws Exception;
}
