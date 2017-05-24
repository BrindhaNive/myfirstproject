package com.epyloc.pacs.util;

public interface Pair<T,V> {
	
	public void setFirstObject(T t);
	public T getFirstObject();
	
	public  void setSecondObject(V v);
	public V getSecondObject();

}
