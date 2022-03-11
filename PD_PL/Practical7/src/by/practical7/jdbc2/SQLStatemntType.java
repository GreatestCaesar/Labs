package by.practical7.jdbc2;

enum SQLStatemntType {
    ANY(0), SELECT(1), NON_SELECT(2);
    private final int sqlTypeCode;

    private SQLStatemntType(int sqlTypeCode) {
        this.sqlTypeCode = sqlTypeCode;
    }

    public int getSQLTypeCode() {
        return this.sqlTypeCode;
    }
}
