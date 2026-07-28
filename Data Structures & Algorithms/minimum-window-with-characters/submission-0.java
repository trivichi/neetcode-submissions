class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> tmap=new HashMap<>();
        Map<Character, Integer> rmap=new HashMap<>();
        for(char c: t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int have=0,need=tmap.size();
        int[] res={-1,-1};
        int reslen=Integer.MAX_VALUE;
        int l=0;
        for(int r=0;r<s.length();r++){
            char c=s.charAt(r);
            rmap.put(c,rmap.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && rmap.get(c).equals(tmap.get(c))){
                have++;
            }
            while(have==need){
                if(r-l+1<reslen){
                    reslen=r-l+1;
                    res[0]=l;
                    res[1]=r;
                }
                char lc=s.charAt(l);
                rmap.put(lc,rmap.get(lc)-1);
                // if(rmap.get(lc)==0) rmap.remove(lc);
                if(tmap.containsKey(lc) && tmap.get(lc)>rmap.get(lc)){
                    have--;
                }
                l++;
            }
        }
        if(reslen==Integer.MAX_VALUE) return "";
        return s.substring(res[0],res[1]+1);
    }
}
