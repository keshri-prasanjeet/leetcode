class Solution {
    List<String> allIpAddresses;
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        allIpAddresses = new ArrayList<>();
        if(len < 4 || len > 12) return allIpAddresses;
        findIpAddresses(s, new StringBuilder(), 0, 0);
        return allIpAddresses;
    }

    private void findIpAddresses(String s, StringBuilder sb, int index, int segmentCount){
        if(index == s.length() && segmentCount == 4){
            allIpAddresses.add(sb.toString());
            return;
        }
        if(index == s.length() || segmentCount == 4) return;

        for(int substrLen = 1; substrLen <=3 && index + substrLen <= s.length(); substrLen++){
            String part = s.substring(index, index+substrLen);
            if(substrLen > 1 && part.startsWith("0")) break;

            int intValue = Integer.parseInt(part);
            if(intValue > 255) break;

            int lenBefore = sb.length();

            if(segmentCount > 0) sb.append(".");
            sb.append(part);

            findIpAddresses(s, sb, index + substrLen, segmentCount+1);

            sb.setLength(lenBefore);

        }
    }
}