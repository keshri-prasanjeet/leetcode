class Solution {
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        int len = s.length();
        char[] word = new char[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='A' || 
                s.charAt(i)=='a' || 
                s.charAt(i)== 'e' || 
                s.charAt(i)=='E' || 
                s.charAt(i)=='i' || 
                s.charAt(i)=='I' || 
                s.charAt(i)=='o' || 
                s.charAt(i)=='O' || 
                s.charAt(i)=='u' || 
                s.charAt(i)=='U'){
                vowels.add(s.charAt(i));
            }
            word[i] = s.charAt(i);
        }
        int vowelLen = vowels.size()-1;
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='A' || 
                s.charAt(i)=='a' || 
                s.charAt(i)== 'e' || 
                s.charAt(i)=='E' || 
                s.charAt(i)=='i' || 
                s.charAt(i)=='I' || 
                s.charAt(i)=='o' || 
                s.charAt(i)=='O' || 
                s.charAt(i)=='u' || 
                s.charAt(i)=='U'){
                    word[i] = vowels.get(vowelLen--);
            }
        }
        return new String(word);
    }
}