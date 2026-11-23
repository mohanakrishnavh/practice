package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * ReformatDate
 * 
 * Reformats a date from {@code "20th Oct 2052"} style to {@code "2052-10-20"} (YYYY-MM-DD).
 *
 * <p>Approach: Split on spaces, strip the ordinal suffix from the day, map the month
 * abbreviation to its number and zero-pad the day.
 *
 * <p>Time Complexity: O(1). Space Complexity: O(1).
 * 
 * @author Mohanakrishna, Vanamala Hariprasad
 * @version 1.0
 */
public class ReformatDate {
    /**
     * Converts a date such as {@code "6th Jun 1933"} to {@code "1933-06-06"}.
     *
     * @param date the date in "Day Month Year" form with an ordinal day suffix
     * @return the date in YYYY-MM-DD format
     */
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] dateComponents = date.split(" ");

        String dayPart = dateComponents[0].substring(0, dateComponents[0].length() - 2);
        String day = Integer.parseInt(dayPart) < 10 ? "0" + dayPart : dayPart;

        return dateComponents[2] + "-" + months.get(dateComponents[1]) + "-" + day;
    }
}
