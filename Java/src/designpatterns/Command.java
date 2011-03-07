/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jtherrell
 */
class Document {
	private String filename;

    public Document(String filename) {
		this.filename = filename;
	}
    public void open() {
		// Open the file and store file's contents
	}

	public void read() {
		
	}
    public void paste() {
		// Paste contents into document
	}
};

class Application {
	private ArrayList<Document> docs;

    void add(Document doc) {
		docs.add(doc);
	}
};
/*
*/
abstract class Command {

    abstract public void execute();
	//protected Command();
};
/*
*/
class OpenCommand extends Command {

	private Application target;

	public OpenCommand(Application app) {
		target = app;
	}

    public void execute() {
		String name = askUser();
		if(name != null) {
			Document doc = new Document(name);
			target.add(doc);
			doc.open();
		}	
	}
	
	public String askUser() {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter filename: ");
		return in.nextLine();
	}
};


class PasteCommand extends Command {
	private Document doc;

	public PasteCommand(Document doc) {
		this.doc = doc;
	}

    public void execute() {
		doc.paste();
	}
};

class SimpleCommand extends Command {
	private Receiver receiver;

    public SimpleCommand(Receiver receiver) {
		this.receiver = receiver;
	}

    public void execute() {
		receiver.action();
	}

};

interface Receiver {
	public void action();
}

class MyClass implements Receiver {
	public void action() {
		// do something
	}
};

class MacroCommand extends Command {
	private ArrayList<Command> cmds;
	
	public MacroCommand() {
		cmds = new ArrayList<Command>();
	}

    public void add(Command cmd) {
		cmds.add(cmd);
	}
	
    public void remove(Command cmd) {
		cmds.remove(cmd);
	}

    public void execute() {
		for (int i = 0; i < cmds.size(); i++)
			cmds.get(i).execute();
	}
};

//void dummy () {
///*
//*/
//MyClass* receiver = new MyClass;
//// ...
//Command* aCommand =
//    new SimpleCommand<MyClass>(receiver, &MyClass::Action);
//// ...
//aCommand->Execute();
///*
//*/
//}
/*
*/