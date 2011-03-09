/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class TCPState {

	public void transmit(TCPConnection connection, TCPOctetStream stream) {}
	public void activeOpen(TCPConnection connection) {}
	public void passiveOpen(TCPConnection connection) {}
	public void close(TCPConnection connection) {}
	public void synchronize(TCPConnection connection) {}
	public void acknowledge(TCPConnection connection) {}
	public void send(TCPConnection connection) {}
	public void changeState(TCPConnection connection, TCPState state) {
		connection.changeState(state);
	}
}

class TCPClosed extends TCPState {
	private static TCPState s_instance;

	private TCPClosed() {}

	public static TCPState instance() {
		if (s_instance == null) {
			s_instance = new TCPClosed();
		}
		return s_instance;
	}

	@Override
    public void activeOpen(TCPConnection connection) {
		changeState(connection, TCPEstablished.instance());
	}
	
	@Override
    public void passiveOpen(TCPConnection connection) {
		changeState(connection, TCPListen.instance());
	}
}

class TCPEstablished extends TCPState {
	private static TCPState s_instance;

	private TCPEstablished(){}

	public static TCPState instance() {
		if (s_instance == null) {
			s_instance = new TCPEstablished();
		}
		return s_instance;
	}

	@Override
	public void close(TCPConnection connection) {
		changeState(connection, TCPListen.instance());
	}

	@Override
	public void transmit(TCPConnection connection, TCPOctetStream stream) {
		connection.processOctet(stream);
	}
}

class TCPListen extends TCPState {
	private static TCPState s_instance;

	private TCPListen(){}

	public static TCPState instance() {
		if (s_instance == null) {
			s_instance = new TCPListen();
		}
		return s_instance;
	}

	@Override
	public void send(TCPConnection connection) {
		// send SYN, receive SNY, ACK, etc.
		changeState(connection, TCPEstablished.instance());
	}
}

class TCPConnection{
	private TCPState state;

	public TCPConnection()		{ state = TCPClosed.instance(); }
	public void activeOpen()	{ state.activeOpen(this);		}
	public void passiveOpen()	{ state.passiveOpen(this);		}
	public void close()			{ state.close(this);			}
	public void send()			{ state.send(this);				}
	public void acknowledge()	{ state.acknowledge(this);		}
	public void syncronize()	{ state.synchronize(this);		}
	public TCPState state()		{ return state;					}

	public void processOctet(TCPOctetStream stream) {}
	protected void changeState(TCPState state) { this.state = state; }
}

class TCPOctetStream{}