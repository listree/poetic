package com.cookbook.datastruct;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by poet on 6/28/16.
 */
public class SearchTrieTest {

    @Test
    public void testTrieSearch() {

        SearchTrie trie = new SearchTrie();
        trie.insert("english");

        Assert.assertFalse(trie.search("xyz"));
        Assert.assertFalse(trie.search("eng"));
        Assert.assertTrue(trie.search("english"));

    }

    @Test
    public void testTrieStartsWith() {

        SearchTrie trie = new SearchTrie();
        trie.insert("english");

        Assert.assertFalse(trie.startsWith("xyz", false));
        Assert.assertTrue(trie.startsWith("eng", false));

    }

    @Test
    public void testRetrieveAll() {

        SearchTrie trie = new SearchTrie();
        trie.insert("english");
        trie.insert("germany");
        trie.insert("french");
        trie.insert("englishtea");
        trie.insert("frenchfry");
        trie.insert("germanyburger");

        Set set = new HashSet();
        set.add("english");
        set.add("germany");
        set.add("french");
        set.add("englishtea");
        set.add("frenchfry");
        set.add("germanyburger");

        Assert.assertEquals(set, trie.retrieveAll());

    }

}
