package com.gabrielgiordano.ttm.collection;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.gabrielgiordano.ttm.bean.SearchElementBean;

/**
 * A custom search prefix Trie algorithm implementation with caching and run time speed in mind. 
 * Also called digital tree, radix tree or prefix tree.
 *  
 * More about Trie: @see <a href="https://en.wikipedia.org/wiki/Trie">Wikipedia</a>
 * 
 * @author Gabriel Giordano
 */
public class Trie implements TrieInterface<SearchElementBean> {

	/** The root for the Trie algorithm. */
	final TrieNode root = new TrieNode();

	/**
	 * Instantiates a new trie.
	 */
	public Trie() {}

	@Override
	public void add(String word) {
		TrieNode current = root;
		String normalizedWord = Trie.normalize(word);

		for (int i = 0; i < word.length(); ++i) {
			Character c = normalizedWord.charAt(i);
			current.putChild(c, word);
			current = current.getChild(c);
		}
		
		current.putWord(word);
	}

	@Override
	public int getSize(String prefix) {
		TrieNode current = root;

		for (int i = 0; i < prefix.length(); ++i) {
			Character c = prefix.charAt(i);
			current = current.getChild(c);

			if (current == null)
				return 0;
		}

		return current.getSize();
	}
	
	@Override
	public SearchElementBean getResult(String prefix) {
		TrieNode node = search(prefix);
		
		SearchElementBean result = new SearchElementBean();
		
		if (node != null) {
			result.setSize(node.size);
			result.setWords(node.words);
			
			if (node.size > 1)
				result.setCharacters(node.children.keySet());
			else
				result.setSuffixes(prefix);
		}
				
		return result;
	}
	
	/**
	 * Searches for the parameter prefix and returns a Trie Node.
	 *
	 * @see TrieNode
	 * @param prefix the query prefix
	 * @return the trie node
	 */
	private TrieNode search(String prefix) {
		
		prefix = Trie.normalize(prefix);
		
		TrieNode current = root;

		for (int i = 0; i < prefix.length(); ++i) {
			Character c = prefix.charAt(i);
			current = current.getChild(c);

			if (current == null)
				return null;
		}
		
		return current;
	}
	
	/**
	 * Normalizes the String for better search, ignoring accents and cases.
	 *
	 * @param s the string
	 * @return the normalized string
	 */
	protected static String normalize(String s) {
		
		String normalized = Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}+]", "").toLowerCase();
		
		return normalized;
	}

	/**
	 * The Class TrieNode for this Trie implementation.
	 */
	private class TrieNode implements TrieNodeInterface {

		/** The children nodes. */
		private Map<Character, TrieNode> children = new LinkedHashMap<>();
		
		/** The cached words. */
		private List<String> words = new ArrayList<>();
		
		/** The cached words size. */
		private int size = 0;
		
		@Override
		public void putChild(char character) {
			this.children.putIfAbsent(character, new TrieNode());
		}

		/**
		 * Puts a node child with the parameter character and word.
		 *
		 * @param character the character
		 * @param word the word
		 */
		public void putChild(char character, String word) {
			putChild(character);
			putWord(word);
		}

		/**
		 * Puts a word for caching purposes.
		 *
		 * @param word the word
		 */
		public void putWord(String word) {
			this.words.add(word);
			this.size++;
		}

		@Override
		public TrieNode getChild(char character) {
			return this.children.get(character);
		}

		@Override
		public int getSize() {
			return this.size;
		}

	}
}
