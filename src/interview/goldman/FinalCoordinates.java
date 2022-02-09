package interview.goldman;

/*
Given a string like ‘UUUDULR’, need to derive the final coordinates starting from (0, 0). This is pretty easy and he is asked to add a few other test cases if I would like to.
Test Case = [
[ "UUU", [0,3] ],
["ULDR", [0,0] ],
["ULLLDUDUURLRLR", [-2,2] ],
["UP LEFT 2xDOWN DOWN RIGHT RIGHT UP UP", [1,1]] ,
]
 */

public class FinalCoordinates {
    public static void main(String[] args) {
        FinalCoordinates obj = new FinalCoordinates();
        int[] result1 = obj.getFinalCoordinates("UUU", new int[]{0, 3});
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");
        int[] result2 = obj.getFinalCoordinates("ULDR", new int[]{0, 0});
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");
        int[] result3 = obj.getFinalCoordinates("ULLLDUDUURLRLR", new int[]{-2, 2});
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");
    }

    private int[] getFinalCoordinates(String instructions, int[] initialCoordinates) {
        int x = initialCoordinates[0];
        int y = initialCoordinates[1];

        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
            }
        }

        return new int[]{x, y};
    }
}
