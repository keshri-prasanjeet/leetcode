class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] globalMap = new int[26];
        for(char a: s1.toCharArray()){
            globalMap[a-'a']++;
        }

        int left = 0;
        int right = 0;

        while(left < s2.length() && right< s2.length()){
            if(globalMap[s2.charAt(left)-'a'] > 0){
                //found something that mathches
                // System.out.println("Did match char " + s2.charAt(left));
                int[] localMap = Arrays.copyOf(globalMap, globalMap.length);
                right = left;
                while(right < s2.length() && localMap[s2.charAt(right)-'a']>0){
                    // System.out.println("Did match char inside while" + s2.charAt(right));
                    localMap[s2.charAt(right)-'a']--;
                    right++;
                }
                int sum = 0;
                for(int num: localMap) sum+=num;
                if(sum==0) return true;
            }
            else{
                // System.out.println("Did not match char " + s2.charAt(left));
            }
            left++;
        }
        return false;
    }
}