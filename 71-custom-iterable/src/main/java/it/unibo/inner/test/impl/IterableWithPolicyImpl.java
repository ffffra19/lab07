package it.unibo.inner.test.impl;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T>{
    private final T[] array;
    int i = 0;

    public IterableWithPolicyImpl(final T[] array) {
        this.array = array;
    }

    void setIterationPolicy(Predicate<T> filter) {
        IO.println();
    }

    public class InnerIterator implements Iterator<T>{
        T current;
        int i = 0;
        
        protected InnerIterator(T[] array){
            this.current = array[i];
        }

        @Override
        public T next() {
            T nextItem = current;
            this.i++;
            current = array[i];
            return nextItem;
        }
        @Override 
        public boolean hasNext(){
            return this.next() != null;
        }
    }

    public Iterator<T> iterator() {
        return new InnerIterator(this.array);
    }
}