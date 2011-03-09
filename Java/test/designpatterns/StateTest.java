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
public class StateTest {
	private TCPConnection connection;

    public StateTest() {
		connection = new TCPConnection();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
		assertEquals(TCPClosed.class, connection.state().getClass());
	}

	@Test
	public void testActiveOpen() {
		connection.activeOpen();
		assertEquals(TCPEstablished.class, connection.state().getClass());
	}

	@Test
	public void testPassiveOpen() {
		connection.passiveOpen();
		assertEquals(TCPListen.class, connection.state().getClass());
	}

	@Test
	public void testClose() {
		connection.activeOpen();
		connection.close();
		assertEquals(TCPListen.class, connection.state().getClass());
	}

	@Test
	public void testSend() {
		connection.passiveOpen();
		connection.send();
		assertEquals(TCPEstablished.class, connection.state().getClass());
	}

}