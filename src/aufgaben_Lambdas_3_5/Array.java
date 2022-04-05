package aufgaben_Lambdas_3_5;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Array<T> {
	@SuppressWarnings("unchecked")
	private T[] elements = (T[]) new Object[2];
	private int size;
	
	private IntUnaryOperator r ;	
	
	public Array(IntUnaryOperator r) {
		super();
		this.r = r;
	}
	
	
	public void add(T element) {
		this.ensureCapacity();
		this.elements[this.size] = element;
		this.size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public T get(int index) {
		if (index < 0 || index >= this.size)
			throw new IndexOutOfBoundsException();
		return this.elements[index];
	}
	
	private void ensureCapacity() {
		if (this.elements.length == size) {
			this.elements = Arrays.copyOf(elements, r.applyAsInt(size));
		}
	}
}
