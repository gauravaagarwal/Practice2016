package com.atlassian.test;

import java.util.ArrayList;
import java.util.List;

public class DataValidation {

    public static void main(String[] args) {
        test(validate("|Name|Address|~n|ABC|ADD~~|ADD1||~n"), "1:4:1:Address_2");
        test(validate("|Name|Address|~n||ABC|ADD~~|ADD1||~n"),
                "1:5:2:Address_3");
        test(validate("||Name|Address|~n||ABC|ADD~~|ADD1||~n"), ERROR);
        test(validate("|Name|Name|~n||ABC|ADD~~|ADD1||~n"), ERROR);
        test(validate("Name|Name|~n||ABC|ADD~~|ADD1||~n"), ERROR);
        test(validate("|Name|Name|~n||ABC|ADD~~|ADD1~n"), ERROR);
        test(
                validate("|Name|Address|~n|Patrick|Patrick@test.com|pat@test.com|~n|Annie||annie@test.com|"),
                "2:3:1:Address_1");
        test(validate("~~~"), ERROR);
        test(validate("|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n"),"E");
        // .equals("1:3:2:Address_3"));
        /*
         * String strline="|ABC||ADD~~|ADD1||"; if (strline.startsWith("|"))
         * strline=strline.substring(1); if (strline.endsWith("|"))
         * strline=strline.substring(0,strline.length()-1);
         * System.out.println(strline); for (String str:strline.split("\\|",-1)) {
         * System.out.println(":"+str); }
         */
        // System.out.println(validate("|ABC~|ABC|ADD1|"));
    }

    private static void test(String actual, String expected) {
        if (actual.equals(expected))
            System.out.println("GooD: " + actual);
        else {
            System.out.println("Actual: " + actual);
            System.out.println("Expected: " + expected);
        }
    }

    private final static String ERROR = "0:0:0:format_error";

    public static String validate(String input) {
        String lineArray[] = input.split("\\~n");
        ArrayList<Column> columnArray = new ArrayList<Column>();
        boolean firstLine = true;
        for (String strline : lineArray) {
            if (strline.startsWith("|"))
                strline = strline.substring(1);
            else
                return ERROR;
            if (strline.endsWith("|"))
                strline = strline.substring(0, strline.length() - 1);
            else
                return ERROR;
            String strArray[] = strline.split("\\|", -1);
            int j = 0;
            for (int i = 0; i < strArray.length; i++) {
                String parsedValue = null;
                String str1 = strArray[i];
                int lastIndexOfTilda = str1.lastIndexOf('~');
                int lastIndexOfDoubleTilda = str1.lastIndexOf("~~");
                if (lastIndexOfTilda != -1
                        && lastIndexOfTilda == str1.length() - 1) {
                    if (lastIndexOfDoubleTilda != -1
                            && lastIndexOfDoubleTilda == str1.length() - 2) {
                        parsedValue = str1;
                        j++;
                    } else {
                        parsedValue = str1 + "|" + strArray[++i];
                        j++;
                    }
                } else {
                    parsedValue = str1;
                    j++;
                }
                // System.out.println(j+": "+parsedValue);
                if (firstLine) {
                    if (parsedValue.isEmpty()
                            || columnArray.contains(new Column(parsedValue))) {
                        return ERROR;
                    }
                    columnArray.add(new Column(parsedValue));
                } else {
                    if (columnArray.size() == j - 1) {
                        Column col = columnArray.get(columnArray.size() - 1);
                        columnArray.add(new Column(col));
                    }
                    columnArray.get(j - 1).addValue(parsedValue);
                }
                if (strArray.length<columnArray.size()){
                    columnArray.get(j - 1).addValue("");
                }
            }

            firstLine = false;
        }
        int emptyValue = 0;
        for (Column col : columnArray) {
            for (String value : col.getValues()) {
                if (value == null || value.isEmpty()) {
                    emptyValue++;
                }
            }
        }
        return (lineArray.length - 1) + ":" + columnArray.size() + ":"
                + emptyValue + ":"
                + columnArray.get(columnArray.size() - 1).getFullName();
    }
    public static class Column {
        private String name;

        private List<String> values = new ArrayList<String>();

        private int suffix = 0;

        public Column(String _name) {
            name = _name;
        }

        public Column(Column column) {
            name = column.name;
            suffix = column.suffix + 1;
        }

        public void addValue(String value) {
            values.add(value);
        }

        public int getSize() {
            return values.size();
        }

        public String getFullName() {
            if (suffix == 0)
                return name;
            return name + "_" + suffix;
        }

        public String getName() {
            return name;
        }

        public int getSuffix() {
            return suffix;
        }

        public List<String> getValues() {
            return values;
        }

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = PRIME * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final Column other = (Column) obj;
            if (name == null) {
                if (other.name != null)
                    return false;
            } else if (!name.equals(other.name))
                return false;
            return true;
        }

    }
}

