package interview.amazon;

import java.util.*;

public class TransactionLogs {

    public static void main(String[] args) {
        String[][] transactions = new String[][]{{"345366 89921 45"}, {"029323 38239 23"}, {"38239 345366 15"}, {"029323 38239 77"}, {"345366 38239 23"}, {"029323 345366 13"}, {"38239 38239 23"}};
        int threshold = 3;
        System.out.println(new TransactionLogs().getFraudulentIds(transactions, threshold));
    }

    private Map<String, Integer> getUserTransactionCountMap(String[][] transactions) {
        Map<String, Integer> userTransactionCountMap = new HashMap<>();

        for (String[] transaction : transactions) {
            if (!transaction[0].isBlank()) {
                String[] transactionLog = transaction[0].split(" ");
                Set<String> users = new HashSet<>(Arrays.asList(transactionLog[0], transactionLog[1]));
                for (String user : users) {
                    userTransactionCountMap.put(user, userTransactionCountMap.getOrDefault(user, 0) + 1);
                }
            }
        }

        return userTransactionCountMap;
    }

    public List<String> getFraudulentIds(String[][] transactions, int threshold) {
        List<String> fraudulentIds = new ArrayList<>();
        if (transactions == null || transactions.length == 0) {
            return fraudulentIds;
        }

        Map<String, Integer> userTransactionCountMap = getUserTransactionCountMap(transactions);
        for (String user : userTransactionCountMap.keySet()) {
            int noOfTransactions = userTransactionCountMap.get(user);
            if (noOfTransactions >= threshold) {
                fraudulentIds.add(user);
            }
        }

        Collections.sort(fraudulentIds);

        return fraudulentIds;
    }
}
