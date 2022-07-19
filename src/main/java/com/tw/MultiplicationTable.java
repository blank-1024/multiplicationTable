package com.tw;

public class MultiplicationTable {
    public String create(int start, int end) {
        if (isValid(start, end)) {
            return generateTable(start, end);
        }
        return null;
    }

    public Boolean isValid(int start, int end) {
        return isInRange(start) && isInRange(end) && isStartNotBiggerThanEnd(start, end);
    }

    public Boolean isInRange(int number) {
        return number > 0 && number < 1000;
    }

    public Boolean isStartNotBiggerThanEnd(int start, int end) {
        return start <= end;
    }

    public String generateTable(int start, int end) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= end; i++) {
            String line = generateLine(start, i);
            if (i == end) {
                sb.append(line);
            } else {
                sb.append(line).append("\r\n");
            }
        }
        return sb.toString();
    }

    public String generateLine(int start, int row) {
        StringBuffer sb = new StringBuffer();
        for (int i = start; i <= row; i++) {
            String expression = generateSingleExpression(i, row);
            if (i == row) {
                sb.append(expression);
            } else {
                sb.append(expression).append("  ");
            }
        }
        return sb.toString();
    }

    public String generateSingleExpression(int multiplicand, int multiplier) {
        return multiplicand + "*" + multiplier + "=" + multiplicand * multiplier;
    }
}
