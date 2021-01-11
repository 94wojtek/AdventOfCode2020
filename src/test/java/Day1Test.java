import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class Day1Test {
    Day1 day1;

    @BeforeEach
    void setUpDay1() {
        day1 = new Day1();
    }

    @Test
    void shouldIterateThroughArrAndMultiplyTwoEntries() {
        String[] testArr = {"100", "200", "300", "950", "400", "1070", "500"};
        day1.setArrInput(testArr);
        assertEquals(1016500, day1.twoEntriesProduct());
    }

    @Test
    void shouldIterateThroughArrAndMultiplyThreeEntries() {
        String[] testArr = {"100", "200", "300", "950", "700", "800", "400", "1070", "520"};
        day1.setArrInput(testArr);
        assertEquals(291200000, day1.threeEntriesProduct());
    }

    //Nested class of tests with usage of mocks
    @Nested
    @ExtendWith(MockitoExtension.class)
    class Da1WithMocks {
        @Mock FileLinesReader fileLinesReaderMock;
        Day1 day1WithMock;
        List<String> sampleList;

        @BeforeEach
        void setUpDay1WithMock() {
            day1WithMock = new Day1(fileLinesReaderMock);
            sampleList = new LinkedList<>();
            sampleList.add("1");
            sampleList.add("2");
            sampleList.add("3");
            sampleList.add("4");
            sampleList.add("5");
        }

        @Test
        void shouldReturnArrOfInputFromFile() {
            when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(Collections.singletonList("foo"));
            assertEquals("foo", day1WithMock.getArrInput()[0]);
        }

        @Test
        void shouldConvertListToArray() {
            when(fileLinesReaderMock.readAllLines(anyString())).thenReturn(sampleList);
            assertEquals("3", day1WithMock.getArrInput()[2]);
        }
    }
}