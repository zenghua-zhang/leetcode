package leetcode;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary a = new AddBinary();

        System.out.println(a.addBinary("1", "1010"));

    }

    public String addBinary(String a, String b) {
        int lengthDiff = a.length() - b.length();
        if (lengthDiff < 0) {
            a = addZero(-lengthDiff, a);
        } else {
            b = addZero(lengthDiff, b);
        }

        StringBuilder r = new StringBuilder();
        boolean carryBit = false;

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        for (int i = charsA.length - 1; i >= 0; i--) {
            int add = carryBit ? 1 : 0;
            int s = Integer.valueOf(String.valueOf(charsA[i]))
                    + Integer.valueOf(String.valueOf(charsB[i])) + add;
            carryBit = s >= 2;
            r.append(s % 2);
        }
        if(carryBit){
            r.append(1);
        }

        return r.reverse().toString();
    }

    private String addZero(int length, String input) {
        StringBuilder r = new StringBuilder();
        while (length > 0) {
            r.append("0");
            length--;
        }
        r.append(input);
        return r.toString();
    }
}
