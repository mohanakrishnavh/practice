package interview.goldman;

import java.util.HashMap;
import java.util.Map;

/*
Question 1:
Given a 2-D String array of student-marks find the student with the highest average and output his average score. If the average is in decimals, floor it down to the nearest integer.

Example 1:

Input:  [{"Bob","87"}, {"Mike", "35"},{"Bob", "52"}, {"Jason","35"}, {"Mike", "55"}, {"Jessica", "99"}]
Output: 99
Explanation: Since Jessica's average is greater than Bob's, Mike's and Jason's average.
 */

public class HighestAverageScore {
    class Student {
        private String name;
        private int marksSum;
        private int marksCount;

        public Student(String name) {
            this.name = name;
            this.marksSum = 0;
            this.marksCount = 0;
        }
    }

    private int getHighestAverageScore(String[][] marks) {
        int highestAverageScore = -1;
        Map<String, Student> studentScoreMap = new HashMap<>();

        if (marks == null || marks.length == 0 || marks[0].length == 0) {
            return -1;
        }

        for (int i = 0; i < marks.length; i++) {
            String name = marks[i][0];
            Student student = studentScoreMap.getOrDefault(name, new Student(name));
            if (!studentScoreMap.containsKey(name)) {
                studentScoreMap.put(name, student);
            }
            student.marksSum += Integer.parseInt(marks[i][1]);
            student.marksCount += 1;
        }

        for (Student student : studentScoreMap.values()) {
            int averageScore = student.marksSum / student.marksCount;
            if (averageScore > highestAverageScore) {
                highestAverageScore = averageScore;
            }
        }
        return highestAverageScore;
    }

    public static void main(String[] args) {
        String[][] marks = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}};
        HighestAverageScore obj = new HighestAverageScore();
        System.out.println(obj.getHighestAverageScore(marks));
    }
}
