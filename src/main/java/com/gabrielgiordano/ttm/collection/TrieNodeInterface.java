package com.gabrielgiordano.ttm.collection;

/**
 * The Interface Node for Tries implementations use.
 * 
 * @author Gabriel Giordano
 */
public interface TrieNodeInterface {
	
	/**
	 * Puts a new child into the trie node.
	 *
	 * @param character the character to put into the trie node
	 */
	void putChild(char character);

	/**
	 * Gets the child of the trie node.
	 *
	 * @param character the character of the trie node
	 * @return the child trie node
	 */
	TrieNodeInterface getChild(char character);

	/**
	 * Gets the size of occurrences of the trie node.
	 *
	 * @return the size of occurrences of the trie node
	 */
	int getSize();
}
