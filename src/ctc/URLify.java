package ctc;

public class URLify {

    private static String urlify(String inputString, int trueLength) {
        int resultIndex = inputString.length() - 1;
        int index = trueLength - 1;
        char[] charArray = inputString.toCharArray();

        while (resultIndex != index) {
            if (charArray[index] != ' ') {
                //charArray[resultIndex]
            }

            index++;
        }


        return new String(charArray);
    }

    public static void main(String[] args) {
        String inputString = "Mr John Smith    ";

    }
}
