class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int rLen = ransomNote.length();
        int mLen = magazine.length();
        if(mLen < rLen) return false;
        char[] ransomArray = ransomNote.toCharArray();
        char[] magazineArray = magazine.toCharArray();
        Arrays.sort(ransomArray);
        Arrays.sort(magazineArray);
        int j=0;
        int count = 0;
        for(int i=0;i<mLen;i++){
            if(ransomArray[j]==magazineArray[i]){
                count++;
                if(count == rLen) return true;
                j++;
            }
        }
        return false;
    }
}