package com.pjanof.algorithms.problems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

@DisplayName("Add Numbers")
class AddNumbersTests {

    final Logger logger = LoggerFactory.getLogger(AddNumbersTests.class);

    @BeforeEach
    void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getTestMethod().get().getName();
        logger.info(String.format("About to execute repetition %d of %d for %s",
            currentRepetition, totalRepetitions, methodName));
    }

    @RepeatedTest(value = 2, name = "{displayName} {currentRepetition} of {totalRepetitions}")
    @DisplayName("Adds Two Lists")
    void addsTwoLists()
    {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(7);
        l3.next = new ListNode(0);
        l3.next.next = new ListNode(8);

        AddNumbers addNumbers = new AddNumbers();
        ListNode result = addNumbers.addTwoNumbers(l1, l2);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.val, 7);

        Assertions.assertNotNull(result.next);
        Assertions.assertEquals(result.next.val, 0);

        Assertions.assertNotNull(result.next.next);
        Assertions.assertEquals(result.next.next.val, 8);

        Assertions.assertNull(result.next.next.next);
    }

/*
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void addsTwoLists(ListNode l1, ListNode l2, ListNode l3)
    {
        AddNumbers addNumbers = new AddNumbers();
        ListNode result = addNumbers.addTwoNumbers(l1, l2);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.val, 7);

        Assertions.assertNotNull(result.next);
        Assertions.assertEquals(result.next.val, 0);

        Assertions.assertNotNull(result.next.next);
        Assertions.assertEquals(result.next.next.val, 8);

        Assertions.assertNull(result.next.next.next);
    }
*/
}
