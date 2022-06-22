import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    private PriorityQueue priQueue;

    static Stream<Arguments> lab3() {
        return Stream.of(
                Arguments.of(new int[]{1,4,3,5,2}, new int[]{1,2,5,4,3}),
                Arguments.of(new int[]{4,4,6,4,4}, new int[]{4,4,6,4,4}),
                Arguments.of(new int[]{-14,6,-23,5,6}, new int[]{-23,-14,5,6,6}),
                Arguments.of(new int[]{1,9,5,4,6}, new int[]{1,4,5,6,9}),
                Arguments.of(new int[]{9,8,7,6,5}, new int[]{5,6,7,8,9})
        );
    }

    @BeforeEach
    void setUp() {
        priQueue = new PriorityQueue();
    }

    @ParameterizedTest
    @MethodSource("lab3")
    void testPriQueue(int[] input, int[] ans) {
        for (int num : input) {
            priQueue.offer(num);
        }
        for(int i = 0; i < priQueue.size(); i++) {
            assertEquals(priQueue.poll(), ans[i]);
        }
    }

    @Test
    void testExceptionIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue priQueue = new PriorityQueue(0);
        });
    }

    @Test
    void testExceptionClassCastException() {
        ClassCastException exception = assertThrows(ClassCastException.class, () -> {
            priQueue.add(new Object[]{1, 1});
        });
    }

    @Test
    void testExceptionNullPointerException() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            priQueue.offer(null);
        });
        assertEquals(null, exception.getMessage());
    }
}
