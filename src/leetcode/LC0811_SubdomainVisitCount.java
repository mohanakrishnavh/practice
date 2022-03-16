package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0811_SubdomainVisitCount {
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> countSubdomainPairs = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) {
            return countSubdomainPairs;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] countDomainInfo = cpdomain.split(" ");
            String[] domains = countDomainInfo[1].split("\\.");
            int count = Integer.parseInt(countDomainInfo[0]);

            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                domain = domains[i] + (i < domains.length - 1 ? "." : "") + domain;
                countMap.put(domain, countMap.getOrDefault(domain, 0) + count);
            }
        }

        for (String domain : countMap.keySet()) {
            countSubdomainPairs.add(countMap.get(domain) + " " + domain);
        }

        return countSubdomainPairs;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
