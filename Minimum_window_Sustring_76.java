class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int n = s.length(),m = t.length();
        int l=0,r=0,minLen =Integer.MAX_VALUE,sIndex = -1,count =0;
        //preInsert step..
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }
        while(r < n){
            if(hash[s.charAt(r)] > 0) count++; //i get one amount a t;
            hash[s.charAt(r)]--;

            while(count == m){  //try shrinking it...
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }

                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
            }
            r++;  
        }
        return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
    }
}