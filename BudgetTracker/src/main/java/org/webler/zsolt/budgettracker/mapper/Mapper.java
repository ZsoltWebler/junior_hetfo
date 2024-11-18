package org.webler.zsolt.budgettracker.mapper;

public interface Mapper<F,T> {

    public T mapTo(F from);

    public F mapFrom(T to);

}
