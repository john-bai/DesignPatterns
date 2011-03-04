/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package designpatterns;

import java.awt.Font;
/**
 *
 * @author jtherrell
 */
class Char {
	private char c;
	public Char(char c) {
		this.c = c;
	}
	public void draw(Font font, Log log) {
		log.append(c + ":" + font.getFontName() + "\n");
	}
}

class CharacterFactory {
	private static final int NCHARCODES = 128;
	private static Char[] characters = new Char[NCHARCODES];

	static Char CreateCharacter(char c) {
		if (characters[c] == null)
			characters[c] = new Char(c);
		return characters[c];
	}
}


