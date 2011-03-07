/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.util.ArrayList;

/**
 *
 * @author jtherrell
 */
abstract class WordProcessorApplication {
	private ArrayList<Document> docs;
	protected Log log;

	public WordProcessorApplication(Log log) {
		docs = new ArrayList<Document>();
		this.log = log;
	}

	public void openDocument(String filename) {
		log.append("TEMPLATE METHOD START:");
		if (!canOpenDocument(filename))
			return;
		Document doc = doCreateDocument(filename);
		if (doc != null) {
			docs.add(doc);
			aboutToOpenDocument();
			doc.open();
			doc.read();
		}
		log.append("TEMPLATE METHOD END");
	}
	abstract public boolean canOpenDocument(String filename);
	abstract public Document doCreateDocument(String filename);
	abstract public void aboutToOpenDocument();
}

class UnixWordProcessorApplication extends WordProcessorApplication {

	public UnixWordProcessorApplication(Log log) {
		super(log);
	}

	@Override
	public boolean canOpenDocument(String filename) {
		log.append("UNIX canOpen:");
		return true;
	}

	@Override
	public Document doCreateDocument(String filename) {
		log.append("UNIX doCreate:");
		return new Document(filename);
	}

	@Override
	public void aboutToOpenDocument() {
		log.append("UNIX aboutTo:");
		// Do any setup prior to opening doc
	}
}