import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class Day2Test {
    Day2 day2Test;

    @BeforeEach
    void setUp() {
        day2Test = new Day2();
    }

    @Test
    void convertEntryToArr_shouldSplitAndConvertEntry() {
        assertAll(
                () -> assertEquals("13",
                        day2Test.convertEntryToArr("13-14 f: ffffffffnfffvv")[0]),
                () -> assertEquals("14",
                        day2Test.convertEntryToArr("13-14 f: ffffffffnfffvv")[1]),
                () -> assertEquals("f",
                        day2Test.convertEntryToArr("13-14 f: ffffffffnfffvv")[2]),
                () -> assertEquals("ffffffffnfffvv",
                        day2Test.convertEntryToArr("13-14 f: ffffffffnfffvv")[3])
        );
    }

    @Test
    void charOccurrencyContained_shouldReturnFalse() {
        String[] testArr = {"13", "14", "f", "ffffffffnfffvv"};
        assertFalse(day2Test.charOccurrencyContained(testArr));
    }

    @Test
    void charOccurrencyContained_shouldReturnTrue() {
        String[] testArr = {"2", "3", "n", "nnjn"};
        assertTrue(day2Test.charOccurrencyContained(testArr));
    }

    @Test
    void charSpecificPosition_shouldReturnFalse(){
        String[] testArr = {"13", "14", "f", "ffffffffnfvvff"};
        assertFalse(day2Test.charSpecificPosition(testArr));
    }

    @Test
    void charSpecificPosition_shouldReturnTrue(){
        String[] testArr = {"13", "14", "f", "ffffffffnfvvfv"};
        assertTrue(day2Test.charSpecificPosition(testArr));
    }

    @Nested
    @ExtendWith(MockitoExtension.class)
    class Day2WithMocks {
        @Mock FileLinesReader fileLinesReaderMock;
        Day2 day2WithMock;
        List<String> sampleList;

        @BeforeEach
        void setUp() {
            day2WithMock = new Day2(fileLinesReaderMock);
            sampleList = new LinkedList<>();
            sampleList.add("foo");
            sampleList.add("bar");
            sampleList.add("foobar");
        }

        @Test
        void entriesAssignment_ShouldReturnSampleList() {
            List<String> expectedList = new LinkedList<>();
            expectedList.add("foo");
            expectedList.add("bar");
            expectedList.add("foobar");
            when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(sampleList);
            day2WithMock.entriesAssignment("someFile");
            assertEquals(expectedList, day2WithMock.getEntriesList());
        }

        @Test
        void count_shouldReturnCountOfCorrectPasswords() {
            List<String> expectedList = new LinkedList<>();
            expectedList.add("2-3 n: nnjn");
            expectedList.add("2-3 h: hhhh");
            expectedList.add("1-6 b: lcpcbcr");
            expectedList.add("13-14 f: ffffffffnfffvv");
            expectedList.add("2-4 r: rrrr");
            expectedList.add("10-12 w: kwtzpnzspwwwdz");
            when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(expectedList);
            assertEquals(3, day2WithMock.countPassWithValidOccurrnces());
        }
    }
}