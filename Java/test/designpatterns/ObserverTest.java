/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jtherrell
 */
public class ObserverTest {

    public ObserverTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
		Log log = new Log();
		Subject subject = new Subject("Original Title", log);
		ObserverA obA = new ObserverA(subject);
		ObserverB obB = new ObserverB(subject);
		ObserverC obC = new ObserverC(subject);
		subject.attach(obA);
		subject.attach(obB);
		subject.attach(obC);
		subject.setTitle("Update Title");
		String expResult = "notifying ObserverA" + "\n"
						 + "ObserverA notified!" + "\n"
						 + "notifying ObserverB" + "\n"
						 + "ObserverB notified!" + "\n"
						 + "notifying ObserverC" + "\n"
						 + "ObserverC notified!" + "\n";
		String result = log.toString();
		assertEquals(expResult, result);
	}

}