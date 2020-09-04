package kz.entity;

public class ExcelSettings {

    private char nameColumn;
    private char typeColumn;
    private char linkColumn;
    private int stopRow;//todo is it needed?

    public ExcelSettings(char nameColumn, char typeColumn, char linkColumn, int stopRow) {
        this.nameColumn = nameColumn;
        this.typeColumn = typeColumn;
        this.linkColumn = linkColumn;
        this.stopRow = stopRow;
    }

    public void setNameColumn(char nameColumn) {
        this.nameColumn = nameColumn;
    }

    public void setTypeColumn(char typeColumn) {
        this.typeColumn = typeColumn;
    }

    public void setLinkColumn(char linkColumn) {
        this.linkColumn = linkColumn;
    }

    public void setStopRow(int stopRow) {
        this.stopRow = stopRow;
    }

    public int getNameColumnIndex() {
        return getIndexOfColumn(nameColumn);
    }

    public int getTypeColumnIndex() {
        return getIndexOfColumn(typeColumn);
    }

    public int getLinkColumnIndex() {
        return getIndexOfColumn(linkColumn);
    }

    public int getStopRow() {
        return stopRow;
    }

    public int getIndexOfColumn(char letter) {
        // converting input letter in to uniform case.
        char inputLetterToLowerCase = Character.toLowerCase(letter);
        // Converting chat in to its ascii value
        int asciiValueOfInputChar = (int) inputLetterToLowerCase;
        // ASCII value of lower case letters starts from 97
        int position = asciiValueOfInputChar - 96;
        //index starts with 0 (zero)
        return position - 1;
    }

    @Override
    public String toString() {
        return "ExcelSettings{" +
                "nameColumn='" + nameColumn + '\'' +
                ", typeColumn='" + typeColumn + '\'' +
                ", linkColumn='" + linkColumn + '\'' +
                ", stopRow=" + stopRow +
                '}';
    }
}
