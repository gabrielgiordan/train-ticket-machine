package com.gabrielgiordano.ttm.collection;

/**
 * The Interface for Trie implementations.
 *
 * @author Gabriel Giordano
 * @param <E> the element type to get as the result
 */
public interface TrieInterface<E> {

  /**
   * Adds a word to the Trie tree.
   *
   * @param word the word
   */
  void add(String word);

  /**
   * Gets the size of occurrences of the Trie search.
   *
   * @param prefix the prefix to query
   * @return the size of occurrences
   */
  int getSize(String prefix);

  /**
   * Gets the result as the generic type inferred in the Trie implementation.
   *
   * @param prefix the prefix to query
   * @return the result of the query
   */
  E getResult(String prefix);
}
