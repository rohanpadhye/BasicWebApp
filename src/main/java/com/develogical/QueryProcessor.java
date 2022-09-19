package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        Pattern pAdd = Pattern.compile("what is (\\d+) plus (\\d+)");
        Pattern pMul = Pattern.compile("what is (\\d+) multiplied by (\\d+)");
        Matcher matcher;
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("name")) {
            return "Rohan";
        }
        matcher = pAdd.matcher(query.toLowerCase());
        if (matcher.find()) {
            try {
                int left = Integer.valueOf(matcher.group(1));
                int right = Integer.valueOf(matcher.group(2));
                return Integer.toString(left + right);
            } catch (NumberFormatException e) {
                // keep going
            }
        }

        matcher = pMul.matcher(query.toLowerCase());
        if (matcher.find()) {
            try {
                int left = Integer.valueOf(matcher.group(1));
                int right = Integer.valueOf(matcher.group(2));
                return Integer.toString(left * right);
            } catch (NumberFormatException e) {
                // keep going
            }
        }



        return "";
    }
}
