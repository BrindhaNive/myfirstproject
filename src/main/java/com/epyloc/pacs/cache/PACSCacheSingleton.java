package com.epyloc.pacs.cache;

import java.io.ObjectStreamException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PACSCacheSingleton implements Relodable {


	private static Lock lock = new ReentrantLock();
	private static volatile PACSCacheSingleton instance;
	private static volatile PACSCacheSingleton _instance;

	public static PACSCacheSingleton getInstance() {
		lock.lock();
		if (instance == null) {
			instance = new PACSCacheSingleton();
		}
		lock.unlock();
		return instance;
	}

	@Override
	public void clear() {
		lock.lock();
		try {
			_instance = instance;
			instance = null;
			instance = new PACSCacheSingleton();
		} catch (Exception e) {
//			logger.error("Exception While clearing cache  ", e);
		} finally {
			lock.unlock();
		}
	}

	public PACSCacheSingleton() {
		reloadCache();
	}

	private void reloadCache() {
		try {
			_instance = null;
		} catch (Exception e) {
//			logger.error("Exception While Loading Master data  ", e);
			instance = _instance;
		}
	}

	public Object readResolve() throws ObjectStreamException {
		return instance;
	}
}
