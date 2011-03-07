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
interface Mediator {
	public void widgetChanged(Widget changedWidget);
}

class FontDialogMediator implements Mediator {
	private Button ok;
	private Button cancel;
	private ListBox fontList;
	private EntryField fontName;
	private Log log;

	public FontDialogMediator(Log log) {
		ok = new Button(this, "OK", log);
		cancel = new Button(this, "CANCEL", log);
		fontList = new ListBox(this, log);
		List<String> fonts = new ArrayList<String>();
		fonts.add("Helvetica");
		fonts.add("Myriad Pro");
		fonts.add("Times New Roman");
		fontList.setList(fonts);
		fontName = new EntryField(this, log);
		this.log = log;
	}

	@Override
	public void widgetChanged(Widget changedWidget) {
		if (changedWidget == fontList) {
			log.append("updating fontName field ");
			fontName.setText(fontList.getSelection());
		} else if (changedWidget == ok) {
			log.append("OK ");
		} else if (changedWidget == cancel) {
			log.append("CANCEL ");
		}
	}

	public Widget[] getWidgets() {
		Widget[] widgets = {ok, cancel, fontList, fontName};
		return widgets;
	}

}

abstract class Widget {
	private Mediator mediator;
	protected Log log;
	
	public void changed() {
		mediator.widgetChanged(this);
	}
	abstract public void handleMouse(MouseEvent e);
	public Widget(Mediator mediator, Log log) {
		this.mediator = mediator;
		this.log = log;
	}
}

class ListBox extends Widget {
	private List<String> listItems;
	private int currentSelectionIndex;

	public ListBox(Mediator mediator, Log log) {
		super(mediator, log);
		listItems = new ArrayList<String>();
		currentSelectionIndex = 0;
	}

	@Override
	public void handleMouse(MouseEvent e) {
		log.append("ListBox changed ");
		//pretend the selected item in the list changed
		changed();
	}

	public String getSelection() {
		return listItems.get(currentSelectionIndex);
	}

	public void setList(List<String> listItems) {
		this.listItems = listItems;
	}
}

class EntryField extends Widget {
	private String entryText;

	public EntryField(Mediator mediator, Log log) {
		super(mediator, log);
		entryText = "";
	}

	public String getText() {
		return entryText;
	}

	public void setText(String text) {
		entryText = text;
	}

	@Override
	public void handleMouse(MouseEvent e) {
		log.append("EntryField changed ");
		//pretend the selected item in the list changed
		changed();
	}
}

class Button extends Widget {
	private String buttonLabel;

	public Button(Mediator mediator, String label, Log log) {
		super(mediator, log);
		buttonLabel = label;
	}

	public void setLabel(String label) {
		buttonLabel = label;
	}

	@Override
	public void handleMouse(MouseEvent e) {
		log.append("Button changed ");
		//pretend the button was clicked
		changed();
	}
	
}

class MouseEvent{}