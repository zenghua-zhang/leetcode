package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
    public static void main(String[] args){
        LetterCombinationsofaPhoneNumber d = new LetterCombinationsofaPhoneNumber();
        System.out.println(d.letterCombinations("23"));
        
    }
    
    public List<String> letterCombinations(String digits) {
        if(null == digits){
            return null;
        }
        String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz" };
        List<String[]> tmpList = new LinkedList<String[]>();
        List<String> retList = new ArrayList<String>();
        if("".equals(digits)){
            retList.add("");
            return retList;
        }
        for (char c : digits.toCharArray()) {
            String s = map[c - '0'];
            String[] strs = new String[s.length()];
            for(int cnt = 0;cnt < s.length();cnt++){
                strs[cnt] = String.valueOf(s.charAt(cnt));
            }
            
            tmpList.add(strs);
        }
        
        letter(retList,0,tmpList);

        return retList;
    }

    private void letter(List<String> retList, int pos, List<String[]> tmpList) {
        if(pos >= tmpList.size()){
            return;
        }
        String[] tmp = tmpList.get(pos);
        List<String> tList = new LinkedList<String>();
        if(retList.isEmpty()){
            for(String s:tmp){
                tList.add(s);
            }
        }else{
            for(String s:retList){
                for(String s2:tmp){
                    tList.add(s+s2);
                }
            }
        }
        retList.clear();
        retList.addAll(tList);
        letter(retList,pos+1,tmpList);
        
        
    }
}
