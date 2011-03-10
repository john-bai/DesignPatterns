/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.List;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtherrell
 */
public class VisitorTest {
	private List<Equipment> parts;
	private Equipment chassis;

    public VisitorTest() {
		parts = new ArrayList<Equipment>();
		parts.add(new FloppyDisk("iFloppy", 10));
		parts.add(new FloppyDisk("MyFloppy", 5));
		parts.add(new Card("iCard", 100));
		parts.add(new Card("MyCard", 50));
		chassis = new Chassis("Chassis", 1000, parts);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testInventoryVisitor() {
		List<Equipment> inventory = new ArrayList<Equipment>();
		InventoryVisitor visitor = new InventoryVisitor(inventory);
		chassis.accept(visitor);

		int expResult = 5;
		int result = inventory.size();
		assertEquals(expResult, result);
	}

	@Test
	public void testPriceVisitor() {
		PricingVisitor priceVisitor = new PricingVisitor();
		chassis.accept(priceVisitor);
		double expResult = 1165;
		double result = priceVisitor.total();
		assertEquals(expResult, result, 0);
	}

}