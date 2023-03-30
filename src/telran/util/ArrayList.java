package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}
	@Override
	public void add(int index, T obj) {
		
		if(size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size);
		array[index] = obj;
		size++;
		

	}

	@Override
	public T remove(int index) {
		
		T res = array[index];
		System.arraycopy(array, 0, array, 0 ,index );
		System.arraycopy(array, index + 1, array, index , size - 1 - index);
		array[size - 1] = null;
		size--;
		return res;
	}

	@Override
	public T get(int index) {
		
		return array[index];
	}
	@Override
	public int size() {
		
		return size;
	}


}