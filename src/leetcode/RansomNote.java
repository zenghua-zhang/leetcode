package leetcode;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magChars = new int[26];
        for (char c : magazine.toCharArray()) {
            magChars[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if(--magChars[c - 'a'] <0){
                return false;
            }
        }

        return true;
    }
}
