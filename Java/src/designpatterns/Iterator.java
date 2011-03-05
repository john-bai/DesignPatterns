/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.List;

/**
 *
 * @author jtherrell
 */
class Iterator<T> {
	private List<T> list;
	private int currentIndex;

	public Iterator(List<T> list) {
		this.list = list;
		currentIndex = 0;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public boolean hasNext() {
		return currentIndex < list.size();
	}

	public boolean hasPrev() {
		return currentIndex > 0;
	}

	public T next() {
		return list.get(currentIndex++);
	}

	public T prev() {
		return list.get(--currentIndex);
	}
}
