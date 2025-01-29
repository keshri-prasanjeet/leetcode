class Solution {
    public int romanToInt(String s) {

        Map<String, Integer> exceptions = Map.of(
            "IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900);

        Map<Character, Integer> romanVals = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int number = 0;
        
        for(int i=0;i<s.length();i++){
            if(i+2<=s.length()){
                String sub = s.substring(i,i+2);
                if(exceptions.containsKey(sub)){
                    number+=exceptions.get(sub);
                    i++;
                    continue;
                }
            }
            number += romanVals.get(s.charAt(i));
        }

        return number;

    }
}