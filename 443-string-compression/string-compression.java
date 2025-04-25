class Solution {
    public int compress(char[] chars) {
        int len = chars.length;
        char a = chars[0];
        int count = 1;
        char[] compressed = new char[len];
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<len;i++){
            if(a==chars[i]){
                count++;
            }
            else{
                if(count == 1){
                    sb.append(a);
                }
                else{
                    sb.append(a);
                    sb.append(Integer.toString(count));
                }
                a = chars[i];
                count = 1;
            }
        }
        if(count == 1){
            sb.append(a);
        }
        else{
            sb.append(a);
            sb.append(Integer.toString(count));
        }
        for(int i=0;i<sb.length();i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}