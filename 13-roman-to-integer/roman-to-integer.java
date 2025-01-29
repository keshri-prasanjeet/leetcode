class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> romanSymbols = new HashMap<>();
        romanSymbols.put('I', 1);
        romanSymbols.put('V', 5);
        romanSymbols.put('X', 10);
        romanSymbols.put('L', 50);
        romanSymbols.put('C', 100);
        romanSymbols.put('D', 500);
        romanSymbols.put('M', 1000);
        int number = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            char a = s.charAt(i);
            int curNum = romanSymbols.get(a);
            if(a=='I'){
                if(i+1<len){
                    if(s.charAt(i+1)=='X'){
                        curNum = 9;
                        i++;
                    }
                    else if(s.charAt(i+1)=='V'){
                        curNum = 4;
                        i++;
                    }
                }
            }
            if(a=='X'){
                if(i+1<len){
                    if(s.charAt(i+1)=='C'){
                        curNum = 90;
                        i++;
                    }
                    else if(s.charAt(i+1)=='L'){
                        curNum = 40;
                        i++;
                    }
                }
            }
            if(a=='C'){
                if(i+1<len){
                    if(s.charAt(i+1)=='M'){
                        curNum = 900;
                        i++;
                    }
                    else if(s.charAt(i+1)=='D'){
                        curNum = 400;
                        i++;
                    }
                }
            }
            number +=curNum;
        }
        return number;
    }
}