package com.gabrielgiordano.ttm.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The Bean SearchElement is used to return the search results.
 * @author Gabriel Giordano
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchElementBean implements Serializable {

	private static final long serialVersionUID = 813037348073316707L;

	private Set<Character> characters;
	
	private Collection<String> suffixes;
	
	private Collection<String> words;
	
	private int size;

	public SearchElementBean() {}
	
	/**
	 * Gets the size of returned words.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the returned words.
	 *
	 * @param size the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Gets the next characters for complete the next words.
	 *
	 * @return the characters
	 */
	public Set<Character> getCharacters() {
		return characters;
	}

	/**
	 * Sets the characters for complete the next words.
	 *
	 * @param characters the new characters
	 */
	public void setCharacters(Set<Character> characters) {
		this.characters = characters;
	}
	
	/**
	 * Auto-configure the suffixes to complete the next words.
	 *
	 * @param prefix the prefix to query
	 */
	public void setSuffixes(String prefix) {
		suffixes = new ArrayList<String>();
		
		for (String word : words) {
			
			String suffix = word.substring(prefix.length(), word.length());
			
			if (!suffix.isEmpty())
				suffixes.add(suffix);
		}
	}

	/**
	 * Gets the suffixes to complete the resulted words.
	 *
	 * @return the suffixes
	 */
	public Collection<String> getSuffixes() {
		return suffixes;
	}

	/**
	 * Gets the words matching the query.
	 *
	 * @return the words
	 */
	public Collection<String> getWords() {
		return words;
	}

	/**
	 * Sets the words.
	 *
	 * @param words the new words
	 */
	public void setWords(Collection<String> words) {
		this.words = words;
	}
}
