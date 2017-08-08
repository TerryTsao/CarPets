package org.terrytsao.dao;

import java.io.Serializable;

public interface DAO<T> {
	public void add(T t);

	public T getById(Serializable id);

	public void setClass(Class<T> clazz);
}
