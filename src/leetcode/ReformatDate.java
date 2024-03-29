package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReformatDate {
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
