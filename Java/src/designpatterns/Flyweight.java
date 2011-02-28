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
class Character {
	private char c;
	public Character(char c) {
		this.c = c;
	}
	public void draw(Font font, Log log) {
		log.append(c + ":" + font.getFontName() + "\n");
	}
}

class CharacterFactory {
	private static final int NCHARCODES = 128;
	private static Character[] characters = new Character[NCHARCODES];

	static Character CreateCharacter(char c) {
		if (characters[c] == null)
			characters[c] = new Character(c);
		return characters[c];
	}
}


