/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

/**
 *
 * @author jtherrell
 */
abstract class HelpHandler {
	protected static final int NO_HELP_TOPIC = -1;
	public static Log log;
	
	protected HelpHandler successor;
	protected int helpTopicID;

	public HelpHandler(HelpHandler successor, int helpTopicID) {
		this.successor = successor;
		this.helpTopicID = helpTopicID;
	}

	public boolean hasHelpFor(int helpTopicID) {
		return this.helpTopicID == helpTopicID;
	}

    public void handleHelp(int helpTopicID) {
		log.append("In HelpHandler...");
		if (successor != null)
			successor.handleHelp(helpTopicID);
	}
}

class HelpWidget extends HelpHandler {
	private HelpWidget parent;

	public HelpWidget(HelpWidget widget, int helpTopicID) {
		super(widget, helpTopicID);
		parent = widget;
	}
}

class HelpButton extends HelpWidget {
	public HelpButton(HelpWidget widget, int helpTopicID) {
		super(widget, helpTopicID);
	}

	@Override
	public void handleHelp(int helpTopicID) {
		log.append("In HelpButton...");
		if (hasHelpFor(helpTopicID)) {
			log.append("Button helped!");
		} else {
			super.handleHelp(helpTopicID);
		}
	}
}

class HelpDialog extends HelpWidget {
	public HelpDialog(HelpWidget widget, int helpTopicID) {
		super(widget, helpTopicID);
	}

	@Override
	public void handleHelp(int helpTopicID) {
		log.append("In HelpDialog...");
		if (hasHelpFor(helpTopicID)) {
			log.append("Dialog helped!");
		} else {
			super.handleHelp(helpTopicID);
		}
	}
}

class HelpApplication extends HelpWidget {
	public HelpApplication(int helpTopicID) {
		super(null, helpTopicID);
	}

	@Override
	public void handleHelp(int helpTopicID) {
		log.append("In HelpApplication...");
		if (hasHelpFor(helpTopicID)) {
			log.append("Application helped!");
		} else {
			super.handleHelp(helpTopicID);
		}
	}
}
