package com.gabrielgiordano.ttm.collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TrieTests {

  Trie trie;

  @Before
  public void setUp() {
    trie = new Trie();

    trie.add("lpas");
    trie.add("opwkqe");
    trie.add("daskl");
    trie.add("qwepo");
    trie.add("ter");
    trie.add("pokzxoaopsdkaspoaks");
    trie.add("qwowqeiwqpeoeiwqqw");
    trie.add("qwowqeiwqpeoeiwqqwb");
    trie.add("qwowqeiwqpeoeiwqqwc");
    trie.add("qwowqeiwqpeoeiwqqwd");
  }

  @Test
  public void testSizesOnDifferentPrefixSearches() {
    assertEquals(1, trie.getSize("ter"));
    assertEquals(0, trie.getSize("www"));
    assertEquals(1, trie.getSize("qwep"));
    assertEquals(4, trie.getSize("qwowqeiwqpeoeiwqqw"));
    assertEquals(1, trie.getSize("qwowqeiwqpeoeiwqqwd"));
  }

  @Test
  public void testCharacterSearchResults() {

    Set<Character> c = new HashSet<Character>();
    c.add('w');

    assertEquals(c, trie.getResult("q").getCharacters());
  }

  @Test
  public void testSuffixedSearchResults() {
    Collection<String> s = new ArrayList<>();
    s.add("er");

    assertEquals(s, trie.getResult("t").getSuffixes());
  }
}
