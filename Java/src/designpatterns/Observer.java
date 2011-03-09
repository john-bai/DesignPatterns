/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jtherrell
 */
/*
*/
class Subject {
	private List<Observer> observers;
	private Log log;
	private String title;
	
	public Subject(String title, Log log) {
		observers = new ArrayList<Observer>();
		this.title = title;
		this.log = log;
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			log.append("notifying " + observer.getClass().getSimpleName() + "\n");
			observer.update();
		}
	}

	public void attach(Observer observer) {
		if (observer != null)
			observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	public Log log() {
		return log;
	}

	public String title() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		notifyObservers();
	}
}

interface Observer {
	public void update();
}

class ObserverA implements Observer {
	private Subject subject;

	public ObserverA(Subject subject) {
		this.subject = subject;
	}

	public void update() {
		subject.log().append(this.getClass().getSimpleName() + " notified!\n");
	}
}

class ObserverB implements Observer {
	private Subject subject;

	public ObserverB(Subject subject) {
		this.subject = subject;
	}

	public void update() {
		subject.log().append(this.getClass().getSimpleName() + " notified!\n");
	}
}

class ObserverC implements Observer {
	private Subject subject;

	public ObserverC(Subject subject) {
		this.subject = subject;
	}

	public void update() {
		subject.log().append(this.getClass().getSimpleName() + " notified!\n");
	}
}