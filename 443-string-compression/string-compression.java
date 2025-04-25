class Solution {
    public int compress(char[] chars) {
        int readIndex = 0;
        int writeIndex = 0;
        int len = chars.length;
        while(readIndex < len){
            char current = chars[readIndex++];
            int count = 1;
            while(readIndex < len && current==chars[readIndex]){
                count++;
                readIndex++;
            }
            chars[writeIndex++] = current;
            if(count > 1){
                for(char a: Integer.toString(count).toCharArray()){
                    chars[writeIndex++] = a;
                }
            }
        }
        return writeIndex;
    }
}