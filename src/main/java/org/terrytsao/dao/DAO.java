package org.terrytsao.dao;

import java.io.Serializable;

public interface DAO {
	public <T> void add(T t);

	public <T> T getById(Class<T> type, Serializable id);
}
