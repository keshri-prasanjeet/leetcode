class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        if(len == 1) return s;
        String space = "";
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        System.out.println(splitted.length);
        for(int i=splitted.length-1;i>=0;i--){
            if(splitted[i].length() >0){
                sb.append(space);
                sb.append(splitted[i]);
                space = " ";
            }
        }
        return sb.toString();
    }
}