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
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T res = array[index];
		
		System.arraycopy(array, index + 1, array, index,
				size - index - 1);
		size--;
		return res;
	}

	@Override
	public T get(int index) {
		T res = array[index];
		return res;
	}
	@Override
	public int size() {
		
		return size;
	}
	@Override
	public boolean remove(T pattern) {
		boolean isRemove = false;
		int removeIndex = this.indexOf(pattern);
		if(removeIndex > 0) {
			this.remove(removeIndex);
			isRemove = true;
		}
		return isRemove;
	}
	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray(T[] array) {
		
		if(array.length >= size) {
				System.arraycopy(this.array, 0, array, 0, array.length);
			return array;
		}
		else {
			T[]newArray = Arrays.copyOf(array, size);
			System.arraycopy(this.array, 0, newArray, 0, size);
			return newArray;
		}
		
		
	}
	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while(index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}
	private boolean isEqual(T object, T pattern) {
		
		return pattern == null ? object == pattern :
			pattern.equals(object);
	}
	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size - 1;
		while(index > 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}


}