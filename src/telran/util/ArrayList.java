package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

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
		if (size == array.length) {
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

		System.arraycopy(array, index + 1, array, index, size - index - 1);
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

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

//=========================HW04===========================
	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		if (index >= 0) {
			remove(index);
		}
		return index < 0 ? false : true;
	}

	@Override
	public T[] toArray() {
		return Arrays.copyOf(array, size);
	}

	
	@Override
	public T[] toArray(T[] buffer) {
		T[] res = buffer;
		if (buffer.length < size) {
			res = (T[]) Arrays.copyOf(array, size);
		} else {
			System.arraycopy(array, 0, res, 0, size);
			if (res.length > size) {
				res[size] = null;
			}
		}
		return res;
	}

//	@Override
//	public T[] toArray(T[] buffer) {
//		T[] res = buffer;
//		if(buffer.length < size) {
//			res =  (T[])new Object[size];
//		} 
//		System.arraycopy(array, 0, res, 0, size );
//		if(res.length > size) {
//			res[size] = null;
//		}
//		return res;
//	}
	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort() {

		sort((Comparator<T>) Comparator.naturalOrder());

	}

	@Override
	public void sort(Comparator<T> comp) {

		boolean isSort = false;
		int length = size;

		while (isSort == false) {

			for (int i = 1; i < length; i++) {
				isSort = true;
				if (comp.compare(array[i - 1], array[i]) > 0) {
					T temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					isSort = false;
				}

			}
			length--;
		}
	}

	@Override
	public int indexOf(Predicate<T> predicate) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(Predicate<T> predicate) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (predicate.test(array[index])) {
				res = index;
			}
			index--;
		}
		return res;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		boolean isRemove = false;
		for(int i = 0; i < size; i++) {
			if(predicate.test(array[i])) {
				isRemove = remove(array[i]);
			}
		}
		return isRemove;
	}
}
