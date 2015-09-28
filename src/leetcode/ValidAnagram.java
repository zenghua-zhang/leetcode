package leetcode;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] nu = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nu[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            nu[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < nu.length; i++) {
            if (nu[i] != 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("aabc", "abca"));
    }
}
