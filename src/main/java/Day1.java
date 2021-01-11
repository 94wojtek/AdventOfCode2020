import java.util.*;

public class Day1 {
    private final String fileName = "report.txt";
    private final FileLinesReader fileLinesReader;
    private String[] arrInput;

    public Day1() {
        this(new DefaultFileLinesReader());
    }

    public Day1(FileLinesReader fileLinesReader) {
        this.fileLinesReader = fileLinesReader;
    }

    public void arrOfInput() {
        List<String> report = fileLinesReader.readAllLines(fileName);
        int size = report.size();
        arrInput = report.toArray(new String[size]);
    }

    public int twoEntriesProduct() {
        int sum = 0;
        int entry1 = 0;
        int entry2 = 0;

        arrOfInput();
        for (int index1 = 0; index1 <= getArrInput().length - 1; index1++) {
            entry1 = Integer.parseInt(getArrInput()[index1]);

            for (int index2 = 0; index2 <= getArrInput().length - 1; index2++) {
                entry2 = Integer.parseInt(getArrInput()[index2]);
                sum = entry1 + entry2;

                if(sum == 2020)
                    break;
            }
            if(sum == 2020)
                break;
        }

        System.out.println(entry1);
        System.out.println(entry2);
        System.out.println(sum);

        return entry1 * entry2;
    }

    public int threeEntriesProduct() {
        int sum = 0;
        int entry1 = 0;
        int entry2 = 0;
        int entry3 = 0;

        arrOfInput();
        for (int index1 = 0; index1 <= getArrInput().length - 1; index1++) {
            entry1 = Integer.parseInt(getArrInput()[index1]);

            for (int index2 = 0; index2 <= getArrInput().length - 1; index2++) {
                entry2 = Integer.parseInt(getArrInput()[index2]);

                for (int index3 = 0; index3 <= getArrInput().length - 1; index3++) {
                    entry3 = Integer.parseInt(getArrInput()[index3]);
                    sum = entry1 + entry2 + entry3;

                    if(sum == 2020)
                        break;
                }

                if(sum == 2020)
                    break;
            }
            if(sum == 2020)
                break;
        }

        System.out.println(entry1);
        System.out.println(entry2);
        System.out.println(entry3);
        System.out.println(sum);

        return entry1 * entry2 * entry3;
    }

    public void setArrInput(String[] arrInput) {
        this.arrInput = arrInput;
    }

    public String[] getArrInput() {
        return arrInput;
    }

    public static void main(String[] args) {
        Day1 day1 = new Day1();
        System.out.println(day1.twoEntriesProduct());
        Arrays.toString(day1.getArrInput());
        System.out.println(day1.threeEntriesProduct());
    }
}

