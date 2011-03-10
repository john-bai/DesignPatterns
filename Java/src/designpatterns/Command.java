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
class Application {
	private List<Document> docs;
	private int currentDocIndex;
	private Menu menu;
	private Log log;

	public Application(Log log) {
		docs = new ArrayList<Document>();
		currentDocIndex = -1;
		this.log = log;
	}

	public void addMenu(Menu menu) {
		this.menu = menu;
	}

    public void addDocument(Document doc) {
		log.append(doc.filename() + " opened...");
		docs.add(doc);
		currentDocIndex = docs.indexOf(doc);
	}

	public Document currentDoc() {
		if (currentDocIndex < 0 || currentDocIndex >= docs.size()) {
			return null;
		}
		log.append("Paste to " + docs.get(currentDocIndex).filename());
		return docs.get(currentDocIndex);
	}
}
/*
*/
interface Command {
    public void execute();
}
/*
*/
class OpenCommand implements Command {

	private Application target;

	public OpenCommand(Application app) {
		target = app;
	}

    public void execute() {
		String name = askUser();
		if(name != null) {
			Document doc = new Document(name);
			target.addDocument(doc);
			doc.open();
		}	
	}
	
	public String askUser() {
		// Pretend we prompt the user for the filename
		return "./untitled.txt";
	}
}


class PasteCommand implements Command {
	private Application target;

	public PasteCommand(Application target) {
		this.target = target;
	}

    public void execute() {
		target.currentDoc().paste();
	}
}

class Menu {
	private List<MenuItem> menuItems;

	public Menu() {
		menuItems = new ArrayList<MenuItem>();
	}

	public void addMenuItem(MenuItem menuItem) {
		if (menuItem != null)
			menuItems.add(menuItem);
	}
}

class MenuItem {
	private String label;
	private Command command;

	public MenuItem(String label, Command command) {
		this.label = label;
		this.command = command;
	}

	public void clicked() {
		command.execute();
	}

}

class Document {
	private String filename;

    public Document(String filename) {
		this.filename = filename;
	}

	public String filename() {
		return filename;
	}

	public void read() {}
    public void open() {}
    public void paste() {}
}