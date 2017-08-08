package org.terrytsao.service;

import java.io.Serializable;

public interface MyService<T> {

	public void add(T t);

	public T getById(Serializable id);
}
