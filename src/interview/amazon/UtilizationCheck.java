package interview.amazon;

public class UtilizationCheck {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int getNumberOfInstances(int[] averageUtilization, int instances) {
        if (averageUtilization.length == 0) {
            return 1;
        }

        int i=0;
        boolean isTaskPerformed = false;
        double MAX_INSTANCES = 2*Math.pow(10, 8);
        while (i < averageUtilization.length) {
            if (averageUtilization[i] < 25 && instances>1) {
                instances = (int)Math.ceil(instances/2.0);
                isTaskPerformed = true;
            }
            else if (averageUtilization[i] > 65 && instances*2 <= MAX_INSTANCES) {
                instances *= 2;
                isTaskPerformed = true;
            }

            i = isTaskPerformed ? i+10 : i+1;
            isTaskPerformed = false;
        }

        return instances;
    }

    public static void main(String[] args) {
        UtilizationCheck obj = new UtilizationCheck();
        int[] avgUtils = new int[]{24, 25, 5, 6, 7, 10, 80, 5, 12, 16, 34, 27, 65, 50};
        int instances = 2;
        System.out.println(obj.getNumberOfInstances(avgUtils, instances));
    }
    // i , instances, isTaskPerfomed
    // 0,  1, true
    // 10,
}
