package org.terrytsao.service;

import java.io.Serializable;

public interface MyService {

	public <T> void add(T t);

	public <T> T getById(Class<T> type, Serializable id);
}
