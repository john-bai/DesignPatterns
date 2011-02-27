package designpatterns;

/**
 * @author jtherrell
 */
class Facade {
	public void doSomething(Log log) {
		SubsystemClassA.doSomething(log);
		SubsystemClassB.doSomething(log);
		SubsystemClassC.doSomething(log);
		SubsystemClassD.doSomething(log);
	}
}

class SubsystemClassA {
	public static void doSomething(Log log){log.append("A");}
}

class SubsystemClassB {
	public static void doSomething(Log log){log.append("B");}
}

class SubsystemClassC {
	public static void doSomething(Log log){log.append("C");}
}

class SubsystemClassD {
	public static void doSomething(Log log){log.append("D");}
}