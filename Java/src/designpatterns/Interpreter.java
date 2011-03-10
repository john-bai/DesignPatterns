/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author jtherrell
 */
interface BooleanExp {
	public boolean evaluate(Context context);
	public BooleanExp replace(String string, BooleanExp exp);
	public BooleanExp copy();
}

class Context {
	private Map<Object, Boolean> contextMap;

	public Context() {
		contextMap = new HashMap<Object, Boolean>();
		contextMap.put(true, true);
		contextMap.put(false, false);
	}

	public boolean lookup(Object obj) {
		return contextMap.get(obj);
	}
	public void assign(VariableExp exp, boolean bool) {
		contextMap.put(exp.name(), bool);
	}
}

class VariableExp implements BooleanExp {
	private String name;

	public VariableExp(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public boolean evaluate(Context context) {
		return context.lookup(name);
	}

	public BooleanExp replace(String name, BooleanExp exp) {
		if (this.name.equals(name))
			return exp.copy();
		else
			return copy();
	}

	public BooleanExp copy() {
		return new VariableExp(name);
	}
}

class Constant implements BooleanExp {
	Boolean bool;

	public Constant(Boolean bool) {
		this.bool = bool;
	}

	public boolean evaluate(Context context) {
		return context.lookup(bool);
	}

	public BooleanExp replace(String string, BooleanExp exp) {
		return this;
	}

	public BooleanExp copy() {
		return new Constant(bool);
	}
}

class AndExp implements BooleanExp {
	private BooleanExp operand1, operand2;

	public AndExp(BooleanExp operand1, BooleanExp operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public boolean evaluate(Context context) {
		return operand1.evaluate(context) && operand2.evaluate(context);
	}

	public BooleanExp replace(String name, BooleanExp exp) {
		return new AndExp(operand1.replace(name, exp),
						  operand2.replace(name, exp));
	}

	public BooleanExp copy() {
		return new AndExp(operand1.copy(), operand2.copy());
	}
}

class OrExp implements BooleanExp {
	private BooleanExp operand1, operand2;

	public OrExp(BooleanExp operand1, BooleanExp operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	public boolean evaluate(Context context) {
		return operand1.evaluate(context) || operand2.evaluate(context);
	}

	public BooleanExp replace(String name, BooleanExp exp) {
		return new OrExp(operand1.replace(name, exp),
						 operand2.replace(name, exp));
	}

	public BooleanExp copy() {
		return new OrExp(operand1.copy(), operand2.copy());
	}

}

class NotExp implements BooleanExp {
	private BooleanExp exp;

	public NotExp(BooleanExp exp) {
		this.exp = exp;
	}

	public boolean evaluate(Context context) {
		return !exp.evaluate(context);
	}

	public BooleanExp replace(String name, BooleanExp exp) {
		return new NotExp(exp.replace(name, exp));
	}

	public BooleanExp copy() {
		return new NotExp(exp.copy());
	}
}