import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Day2 {
    private static final String PASSWORD_FILE_NAME = "passwords.txt";
    private final FileLinesReader fileLinesReader;
    private List<String> entriesList;

    public Day2() {
        this(new DefaultFileLinesReader());
    }

    public Day2(FileLinesReader fileLinesReader) {
        this.fileLinesReader = fileLinesReader;
    }

    public void entriesAssignment(String fileName) {
        entriesList = fileLinesReader.readAllLines(fileName);
    }

    public int countPassWithValidOccurrnces() {
        entriesAssignment(getPasswordFileName());
        String tmpString;
        int index = 0;
        int count = 0;

        while(getEntriesList().iterator().hasNext() && index != getEntriesList().size()) {
            tmpString = getEntriesList().get(index);
            String[] tmpEntryArr = convertEntryToArr(tmpString);
            if(charOccurrencyContained(tmpEntryArr)) //1st part - for char quantity in String
            //if(charSpecificPosition(tmpEntryArr)) //2nd part - for char at specific position
                count++;
            index++;
        }
        System.out.println(index);
        System.out.println(count);

        return count;
    }

    public String[] convertEntryToArr(String entry) {
        String[] formattedEntry = new String[4];

        String[] splittedEntry = entry.split(" ");
        String[] splittedEntryPortion = splittedEntry[0].split("-");
        String passwordCharToString = Character.toString(splittedEntry[1].charAt(0));

        formattedEntry[0] = splittedEntryPortion[0];
        formattedEntry[1] = splittedEntryPortion[1];
        formattedEntry[2] = passwordCharToString;
        formattedEntry[3] = splittedEntry[2];

        return formattedEntry;
    }

    public boolean charOccurrencyContained(String[] formattedEntry) {
        int lowerLimit = Integer.parseInt(formattedEntry[0]);
        int upperLimit = Integer.parseInt(formattedEntry[1]);
        int count = StringUtils.countMatches(formattedEntry[3], formattedEntry[2]);

        return count >= lowerLimit && count <= upperLimit;
    }

    public boolean charSpecificPosition(String[] formattedEntry) {
        int firstIndex = Integer.parseInt(formattedEntry[0]) - 1;
        int secondIndex = Integer.parseInt(formattedEntry[1]) - 1;
        char[] passwordToCharArr = formattedEntry[3].toCharArray();
        String stringChar1 = Character.toString(passwordToCharArr[firstIndex]);
        String stringChar2 = Character.toString(passwordToCharArr[secondIndex]);

        if(formattedEntry[2].equals(stringChar1) && formattedEntry[2].equals(stringChar2))
            return false;

        return formattedEntry[2].equals(stringChar1) || formattedEntry[2].equals(stringChar2);
    }

    public List<String> getEntriesList() {
        return entriesList;
    }

    public String getPasswordFileName() {
        return PASSWORD_FILE_NAME;
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2();
        day2.countPassWithValidOccurrnces();
    }
}
