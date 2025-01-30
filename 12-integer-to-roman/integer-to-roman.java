class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int quot = 0;
            if(num / 1000 > 0){
                quot = num / 1000;
                num  = num % 1000;
                while(quot > 0){
                    sb.append('M');
                    quot--;
                }
            }
            // System.out.println("1000 Num is " + num);
            if(num / 900 > 0){
                // System.out.println("inside 900");
                quot = num / 900;
                num = num % 900;
                sb.append("CM");
            }
            // System.out.println("900 Num is " + num);
            if(num / 500 > 0){
                quot = num / 500;
                num = num % 500;
                sb.append("D");
            }
            // System.out.println("500 Num is " + num);
            if(num / 400 > 0){
                quot = num / 400;
                num = num % 400;
                // ans += "CD";
                sb.append("CD");
            }
            // System.out.println("400 Num is " + num);
            if(num / 100 > 0){
                quot = num / 100;
                num  = num % 100;
                while(quot > 0){
                    sb.append('C');
                    quot--;
                }
            }
            // System.out.println("Num is " + num);
            if(num / 90 > 0){
                quot = num / 90;
                num = num % 90;
                sb.append("XC");
            }
            // System.out.println("Num is " + num);
            if(num / 50 > 0){
                quot = num / 50;
                num = num % 50;
                sb.append("L");
            }
            // System.out.println("Num is " + num);
            if(num / 40 > 0){
                quot = num / 40;
                num = num % 40;
                sb.append("XL");
            }
            // System.out.println("Num is " + num);
            if(num / 10 > 0){
                quot = num / 10;
                num = num % 10;
                while(quot > 0){
                    sb.append("X");
                    quot--;
                }
            }
            // System.out.println("Num is " + num);
            if(num / 9 > 0){
                num = num % 9;
                sb.append("IX");
            }
            // System.out.println("Num is " + num);
            if(num / 5 > 0){
                num = num % 5;
                sb.append("V");
            }
            // System.out.println("Num is " + num);
            if(num / 4 > 0){
                num = num % 4;
                sb.append("IV");
            }
            // System.out.println("Num is " + num);
            if(num / 1 > 0){
                quot = num / 1;
                num = num % 1;
                while(quot > 0){
                    sb.append("I");
                    quot--;
                }
            }
            // System.out.println("Num is " + num);
        }
        return sb.toString();
    }
}