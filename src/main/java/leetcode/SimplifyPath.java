package leetcode;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> l = new LinkedList<String>();
        String[] ps = path.split("/");
        for (String p : ps) {
            if (null == p || p.equals("") || p.equals(".")) {
                continue;
            }
            if(p.equals("..")){
                l.pollFirst();
                continue;
            }
            l.push(p);
        }
        
        StringBuilder sb = new StringBuilder("/");
        String tmp;
        while(!l.isEmpty()){
            tmp = l.pollLast();
            sb.append(tmp).append("/");
        }
        String ret = sb.toString();
        if(ret.length()>1){
            ret = ret.substring(0, ret.length()-1);
        }

        return ret;

    }
}
