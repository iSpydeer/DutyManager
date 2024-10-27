package com.ispydeer.DutyManager.mappers;

public interface Mapper<A, B> {
    B map(A a);

    A unmap(B b);
}
