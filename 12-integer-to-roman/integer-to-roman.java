class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int quot = 0;
            if(num / 1000 > 0){
                quot = num / 1000;
                num  = num % 1000;
                loopingRoman(quot, sb, "M");
            }
            if(num / 900 > 0){
                num = num % 900;
                loopingRoman(1, sb, "CM");
            }
            if(num / 500 > 0){
                num = num % 500;
                loopingRoman(1, sb, "D");
            }
            if(num / 400 > 0){
                num = num % 400;
                loopingRoman(1, sb, "CD");
            }
            if(num / 100 > 0){
                quot = num / 100;
                num  = num % 100;
                loopingRoman(quot, sb, "C");
            }
            if(num / 90 > 0){
                num = num % 90;
                loopingRoman(1, sb, "XC");
            }
            if(num / 50 > 0){
                num = num % 50;
                loopingRoman(1, sb, "L");
            }
            if(num / 40 > 0){
                num = num % 40;
                loopingRoman(1, sb, "XL");
            }
            if(num / 10 > 0){
                quot = num / 10;
                num = num % 10;
                loopingRoman(quot, sb, "X");
            }
            if(num / 9 > 0){
                num = num % 9;
                sb.append("IX");
            }
            if(num / 5 > 0){
                num = num % 5;
                sb.append("V");
            }
            if(num / 4 > 0){
                num = num % 4;
                sb.append("IV");
            }
            if(num / 1 > 0){
                quot = num / 1;
                num = num % 1;
                loopingRoman(quot, sb, "I");
            }
        }
        return sb.toString();
    }
    private void loopingRoman(int quot, StringBuilder sb, String romanNum){
        while(quot > 0){
            sb.append(romanNum);
            quot--;
        }
    }
}