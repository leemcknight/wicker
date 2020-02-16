package org.mcknight.wicker.commons.fs;

import org.mcknight.wicker.commons.lang.Expression;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class WickerRecordSet<T> implements Stream<T> {    
    private WickerFileReader reader;  
    private Class<T> clazz;  

    public WickerRecordSet(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void loadCsv(String path) throws IOException {
        reader = new CsvReader(true);
        reader.open(path);        
    }

    private T transformFunc(WickerRecord record) {
        T obj = null;
        try {                                       
            Constructor<T> ctor = clazz.getConstructor();
            obj = (T)ctor.newInstance();
            for(String fieldName : record.fields()) {
                String setter = buildSetterName(fieldName);
                Method method = clazz.getMethod(setter, String.class);
                method.invoke(obj, record.getString(fieldName));
            }
        } catch(Exception ex) {
            throw new WickerRecordException("Unable to build type from WickerRecord.", ex);
        } 
        return obj;        
    }

    private String buildSetterName(String fieldName) {
        StringBuilder sb = new StringBuilder();
        return sb.append("set")
            .append(fieldName.substring(0,1).toUpperCase())
            .append(fieldName.substring(1)).toString();
    }

    private Stream<T> baseStream() {
        return reader.stream().map(record -> transformFunc(record));
    }

    @Override
    public Iterator<T> iterator() {
        return baseStream().iterator();
    }

    @Override
    public Spliterator<T> spliterator() {
        return baseStream().spliterator();
    }

    @Override
    public boolean isParallel() {
        return baseStream().isParallel();
    }

    @Override
    public Stream<T> sequential() {
        return baseStream().sequential();
    }

    @Override
    public Stream<T> parallel() {
        return baseStream().parallel();
    }

    @Override
    public Stream<T> unordered() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<T> onClose(Runnable closeHandler) {
        return baseStream().onClose(closeHandler);
    }

    @Override
    public void close() {
        baseStream().close();
    }

    @Override
    public Stream<T> filter(Predicate<? super T> predicate) {
        return reader.stream().map(record -> transformFunc(record)).filter(predicate);        
    }

    @Override
    public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return baseStream().map(mapper);
    }

    @Override
    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return baseStream().mapToInt(mapper);        
    }

    @Override
    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Stream<T> distinct() {
        return baseStream().distinct();        
    }

    @Override
    public Stream<T> sorted() {
        return baseStream().sorted();
    }

    @Override
    public Stream<T> sorted(Comparator<? super T> comparator) {
        return baseStream().sorted(comparator);
    }

    @Override
    public Stream<T> peek(Consumer<? super T> action) {
        return baseStream().peek(action);
    }

    @Override
    public Stream<T> limit(long maxSize) {
        return baseStream().limit(maxSize);
    }

    @Override
    public Stream<T> skip(long n) {
        return baseStream().skip(n);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        // TODO Auto-generated method stub

    }

    @Override
    public void forEachOrdered(Consumer<? super T> action) {
        // TODO Auto-generated method stub

    }

    @Override
    public Object[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <A> A[] toArray(IntFunction<A[]> generator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return baseStream().reduce(identity, accumulator);
    }

    @Override
    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return baseStream().reduce(accumulator);
    }

    @Override
    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return baseStream().reduce(identity, accumulator, combiner);
    }

    @Override
    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return baseStream().collect(supplier, accumulator, combiner);
    }

    @Override
    public <R, A> R collect(Collector<? super T, A, R> collector) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> min(Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> max(Comparator<? super T> comparator) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean anyMatch(Predicate<? super T> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean allMatch(Predicate<? super T> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean noneMatch(Predicate<? super T> predicate) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<T> findFirst() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<T> findAny() {
        // TODO Auto-generated method stub
        return null;
    }

    
}
