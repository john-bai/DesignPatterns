/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.List;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtherrell
 */
public class IteratorTest {
	private List<String> list;
	private Iterator<String> iterator;
	
    public IteratorTest() {
		list = new ArrayList<String>();
		list.add("The");
		list.add("official");
		list.add("Iterator");
		list.add("test!");
		iterator = new Iterator<String>(list);
    }

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of isEmpty method, of class Iterator.
	 */ @Test
	public void testIsEmptyTrue() {
		while (0 < list.size())
			list.remove(0);
		boolean expResult = true;
		boolean result = iterator.isEmpty();
		assertEquals(expResult, result);
	}

	/**
	 * Test of isEmpty method, of class Iterator.
	 */ @Test
	public void testIsEmptyFalse() {
		boolean expResult = false;
		boolean result = iterator.isEmpty();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hasNext method, of class Iterator.
	 */ @Test
	public void testHasNextTrue() {
		boolean expResult = true;
		boolean result = iterator.hasNext();
		assertEquals(expResult, result);
	}

	 	/**
	 * Test of hasNext method, of class Iterator.
	 */ @Test
	public void testHasNextFalse() {
		boolean expResult = false;
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		boolean result = iterator.hasNext();
		assertEquals(expResult, result);
	}

	/**
	 * Test of hasPrevious method, of class Iterator.
	 */ @Test
	public void testHasPrevTrue() {
		iterator.next();
		boolean expResult = true;
		boolean result = iterator.hasPrev();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of hasPrevious method, of class Iterator.
	 */ @Test
	public void testHasPrevFalse() {
		boolean expResult = false;
		boolean result = iterator.hasPrev();
		assertEquals(expResult, result);
	}

	/**
	 * Test of next method, of class Iterator.
	 */ @Test
	public void testNext() {
		int i = 0;
		while(iterator.hasNext()) {
			String expResult = list.get(i);
			String result = iterator.next();
			assertEquals(expResult, result);
			i++;
		}
	}

	/**
	 * Test of next method, of class Iterator.
	 */ @Test
	public void testPrev() {
		iterator.next();
		iterator.next();
		iterator.next();
		iterator.next();
		int i = list.size() - 1;
		while(iterator.hasPrev()) {
			String expResult = list.get(i);
			String result = iterator.prev();
			assertEquals(expResult, result);
			i--;
		}
	}

}