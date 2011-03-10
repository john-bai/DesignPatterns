/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author jtherrell
 */
abstract class Equipment {

	private String name;
	private double price;

	public Equipment(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String name()		  { return name; }
    public double price()	  { return price; }
	abstract public void accept(EquipmentVisitor visitor);
}

abstract class CompositeEquipment extends Equipment {
	protected List<Equipment> parts;

	public CompositeEquipment(String name, double price, List<Equipment> parts) {
		super(name, price);
		this.parts = parts;
	}

	abstract public void accept(EquipmentVisitor visitor);
}

class FloppyDisk extends Equipment {

	public FloppyDisk(String name, double price) {
		super(name, price);
	}
	
	public void accept(EquipmentVisitor visitor) {
		visitor.visitFloppyDisk(this);
	}
}
class Card extends Equipment{

	public Card(String name, double price) {
		super(name, price);
	}
	
	public void accept(EquipmentVisitor visitor) {
		visitor.visitCard(this);
	}
}

class Bus extends CompositeEquipment{

	public Bus(String name, double price, List<Equipment> parts) {
		super(name, price, parts);
	}

	@Override
	public void accept(EquipmentVisitor visitor) {
		ListIterator<Equipment> iter = parts.listIterator();
		Equipment e;
		while(iter.hasNext()) {
			e = iter.next();
			e.accept(visitor);
		}
		visitor.visitBus(this);
	}
}

class Chassis extends CompositeEquipment {

	public Chassis(String name, double price, List<Equipment> parts) {
		super(name, price, parts);
	}

	@Override
	public void accept(EquipmentVisitor visitor) {
		ListIterator<Equipment> iter = parts.listIterator();
		Equipment e;
		while(iter.hasNext()) {
			e = iter.next();
			e.accept(visitor);
		}
		visitor.visitChassis(this);
	}
	
}

interface EquipmentVisitor{
	
	public void visitFloppyDisk(FloppyDisk floppy);
	public void visitCard(Card card);
	public void visitChassis(Chassis chassis);
	public void visitBus(Bus bus);
}

class PricingVisitor implements EquipmentVisitor {
	
	private double total;

	public double total() {
		return total;
	}

	public void visitFloppyDisk(FloppyDisk floppy) {
		total += floppy.price();
	}

	public void visitCard(Card card) {
		total += card.price();
	}

	public void visitChassis(Chassis chassis) {
		total += chassis.price();
	}

	public void visitBus(Bus bus) {
		total += bus.price();
	}
}

class InventoryVisitor implements EquipmentVisitor {
	
	private List<Equipment> inventory;

	public InventoryVisitor(List<Equipment> inventory) {
		this.inventory = inventory;
	}
	
	public void visitFloppyDisk(FloppyDisk floppy) {
		inventory.add(floppy);
	}

	public void visitCard(Card card) {
		inventory.add(card);
	}

	public void visitChassis(Chassis chassis) {
		inventory.add(chassis);
	}

	public void visitBus(Bus bus) {
		inventory.add(bus);
	}
}