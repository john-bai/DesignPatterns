package designpatterns;

/**
 * @author jtherrell
 */
class Facade {
	public void doSomething() {
		SubsystemClassA.doSomething();
		SubsystemClassB.doSomething();
		SubsystemClassC.doSomething();
		SubsystemClassD.doSomething();
	}
}

class SubsystemClassA {
	public static void doSomething(){}
}

class SubsystemClassB {
	public static void doSomething(){}
}

class SubsystemClassC {
	public static void doSomething(){}
}

class SubsystemClassD {
	public static void doSomething(){}
}