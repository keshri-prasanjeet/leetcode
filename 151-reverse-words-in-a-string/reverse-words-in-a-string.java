class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder master = new StringBuilder();
        boolean once = false;
        boolean manyWords = false;
        for(int i=0;i<len;i++){
            if(i==0 && s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i)== ' ' || i==len-1){
                if(sb.length() > 0){
                    if(once==true) sb.append(' ');
                    once = true;
                    master.insert(0,sb);
                    sb.setLength(0);
                    manyWords = true;
                }
            }
        }
        if(sb.length() > 0){
            if(manyWords == true) sb.append(' ');
            master.insert(0,sb);
            sb.setLength(0);
        }
        return master.toString();
    }
}