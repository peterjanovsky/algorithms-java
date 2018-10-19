package com.pjanof.algorithms.problems;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubstringLength {

    final Logger logger = LoggerFactory.getLogger(SubstringLength.class);

/*
    private String recurse(char[] str, Character[] substr1, Character[] substr2, Hashtable<Character, Integer> ht,
                           int startOffset, int endOffset, int substr1Offset, int substr2Offset) {

        System.out.format("Iteration\n");

        if (str.length > endOffset) {
            if (ht.containsKey(str[endOffset])) {

                System.out.format("Key Exists with Offsets, Start: %d End: %d Sub1: %d Sub2: %d\n", startOffset,
                                  endOffset, substr1Offset, substr2Offset);

                // assign existing substr to temperary substring which might be the actual result
                if (substr2 == null) substr2 = new Character[str.length];

                if (substr1Offset > substr2Offset) {
                    substr2Offset = 0;
                    for (int i=0; i < substr1Offset; i++) {
                        substr2[i] = substr1[i];
                        substr2Offset++;
                    }
                }

                // remove all keys from the Hashtable
                ht.clear();

                // assign new starting offset to local variable
                int temp = ++startOffset;

                String result = recurse(str, null, substr2, ht, temp, temp, 0, substr2Offset);
                return result;
            } else {

                System.out.format("Key Doesn't Exist with Offsets, Start: %d End: %d Sub1: %d Sub2: %d\n", startOffset,
                                  endOffset, substr1Offset, substr2Offset);

                ht.put(str[endOffset], 1);

                if (substr1 == null) substr1 = new Character[str.length];
                substr1[substr1Offset] = str[endOffset];

                String result = recurse(str, substr1, substr2, ht, startOffset, ++endOffset, ++substr1Offset, substr2Offset);
                return result;
            }
        } else {

            System.out.format("Final\n");

            StringBuilder sb = new StringBuilder();

            if (substr1Offset > substr2Offset) {

                for(int i=0; i < substr1Offset; i++) sb.append(substr1[i]);

            } else {

                for(int i=0; i < substr2Offset; i++) sb.append(substr2[i]);
            }

            return sb.toString();
        }
    }

    private int findSubstr(char[] str) {

        // temp storage of seen characters
        Set s = new HashSet(256);

        // temp storage of length of largest seen substring
        int res = 0;

        // utilize two markers indicating the starting and ending offsets for the window being analyzed
        int i = 0;  // window start
        int j = 0;  // window end

        while ((i < str.length) && (j < str.length)) {

            if (s.contains(str[j])) { // duplicate has been found

                System.out.format("Key %c Exist with Offsets, Start: %d End: %d\n", str[j], i, j);

                // if the length of this substring is larger it is now the max
                res = getMax(res, j - i);

                s.clear();  // clear the set
                i++;        // increment beginning offset of window being analyzed
                j = i;

            } else {

                System.out.format("Key %c Doesn't Exist with Offsets, Start: %d End: %d\n", str[j], i, j);

                s.add(str[j]);
                j++;  // increment the ending offset of window being analyzed
            }
        }

        res = getMax(res, j - i);
        return (res);
    }
*/

    private int getMax(int i, int j) {
        return ((i > j) ? i : j);
    }

    private int findSubstr(char[] str) {

        // temp storage of seen characters
        Set s = new HashSet(256);

        // temp storage of length of largest seen substring
        int res = 0;

        // utilize two markers indicating the starting and ending offsets for the window being analyzed
        int i = 0;  // window start
        int j = 0;  // window end

        while ((i < str.length) && (j < str.length)) {

            if (s.contains(str[j])) { // duplicate has been found

                System.out.format("Key %c Exist with Offsets, Start: %d End: %d\n", str[j], i, j);

                // if the length of this substring is larger it is now the max
                res = getMax(res, j - i);

                s.remove(str[i]);
                i++;              // increment beginning offset of window being analyzed

            } else {

                System.out.format("Key %c Doesn't Exist with Offsets, Start: %d End: %d\n", str[j], i, j);

                s.add(str[j]);
                j++;  // increment the ending offset of window being analyzed
            }
        }

        res = getMax(res, j - i);
        return (res);
    }

    // Given "abcabcbb", the answer is "abc", which the length is 3.
    // Given a string, find the length of the longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        Character[] substr1 = null;
        Character[] substr2 = null;

        if ((s != null) && (s.length() > 0)) {

            //String result = recurse(s.toCharArray(), substr1, substr2, ht, 0, 0, 0, 0);
            //System.out.format("String: %s Substring: %s Substring Length: %d\n", s, result, result.length());
            int result = findSubstr(s.toCharArray());
            System.out.format("String: %s Substring Length: %d\n", s, result);
            return result;

        } else return 0;
    }
}
