class Solution {
    List<String> solution;
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        solution = new ArrayList<>();
        if(len < 4 || len > 12) return solution;
        findIPs(s, 0, 0, new StringBuilder());
        return solution;
    }

    private void findIPs(String s, int index, int segCount, StringBuilder sb){
        if(index == s.length() && segCount == 4){
            solution.add(sb.toString());
            return;
        }

        if(index == s.length() || segCount == 4) return;

        for(int len = 1; len <=3 && index + len <= s.length(); len++){
            String octet = s.substring(index, index+len);

            if(len > 1 && octet.startsWith("0")) break;

            if(Integer.parseInt(octet) > 255) break;

            int prevLen = sb.length();

            if(segCount > 0) sb.append(".");
            sb.append(octet);

            findIPs(s, index+len, segCount+1, sb);

            sb.setLength(prevLen);

        }
    }
}