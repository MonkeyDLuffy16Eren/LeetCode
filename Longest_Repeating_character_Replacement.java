class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen=0;
        int maxFreq=0;
        for(int i=0;i<n;i++){
            int[] arr= new int[26];
            for(int j=i;j<n;j++){
                arr[s.charAt(j)-'A']++;
                maxFreq = Math.max(maxFreq, arr[s.charAt(j)-'A']);
                int changes = (j-i+1)- maxFreq;

                if(changes <= k){
                    maxLen = Math.max(maxLen,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxLen;
    }
} 