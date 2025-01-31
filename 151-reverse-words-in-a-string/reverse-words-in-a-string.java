class Solution {
    public String reverseWords(String s) {
        //split the words from the stirng
        //run a loop from behind for this split array of strings
        //if the split is empty then skip this
        //merge these together in a final stringbuilder that would get converted to the string that we return 

        int len = s.length();
        if(len==1) return s;
        String[] splitted = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String space = "";
        for(int i=splitted.length-1;i>=0;i--){
            if(splitted[i].length()!=0){
                sb.append(space);
                space = " ";
                sb.append(splitted[i]);
            }
        }
        return sb.toString();
    }
}