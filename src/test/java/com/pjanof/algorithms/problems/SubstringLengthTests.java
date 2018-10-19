package com.pjanof.algorithms.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Substring Length")
class SubstringLengthTests {

    final Logger logger = LoggerFactory.getLogger(SubstringLengthTests.class);

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("About to execute repetition %d of %d for %s",
            currentRepetition, totalRepetitions, methodName));
    }

    @RepeatedTest(value = 1, name = "{displayName} {currentRepetition} of {totalRepetitions}")
    @DisplayName("Find the Longest Substring")
    void lengthOfLongestSubstring()
    {
        SubstringLength sl = new SubstringLength();

/*
        // duplicated character(s): a b c
        // substring(s): abc bca cab
        int result = sl.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(result, 3);

        // duplicated character(s): b
        // substring(s): b
        result = sl.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(result, 1);

        // duplicated character(s): w
        // substring(s): wke
        result = sl.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(result, 3);

        result = sl.lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abc");
        Assertions.assertEquals(result, 95);

        // duplicated character(s): a
        // substring(s): bcdefaghijklmn
        int result = sl.lengthOfLongestSubstring("abcdefaghijklmn");
        Assertions.assertEquals(result, 14);
*/
        // duplicated character(s): a e
        // substring(s): fagehijklmn
        int result = sl.lengthOfLongestSubstring("abcdefagehijklmn");
        Assertions.assertEquals(result, 11);
    }
}
