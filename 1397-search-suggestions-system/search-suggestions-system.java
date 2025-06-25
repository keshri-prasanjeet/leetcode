class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Trie trie = new Trie();
        Arrays.sort(products);
        for (String p : products) {
            trie.insert(p);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            String key = searchWord.substring(0, i);
            List<String> pres = trie.prefix.get(key);
            if (pres == null) {
                res.add(new ArrayList<>());
            } else {
                if (pres.size() > 3) {
                    res.add(trie.prefix.get(key).subList(0, 3));
                } else {
                    res.add(trie.prefix.get(key));
                }
            }
        }
        return res;
    }

    class Trie {
        TrieNode root;
        Map<String, List<String>> prefix;

        public Trie() {
            root = new TrieNode();
            prefix = new HashMap<>();
        }

        public void insert(String word) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuilder();
            for (Character ch : word.toCharArray()) {
                String key = sb.append(ch).toString();
                if (!prefix.containsKey(key)) {
                    prefix.put(key, new ArrayList<>());
                }
                prefix.get(key).add(word);
                if (cur.children[ch - 'a'] == null) {
                    cur.children[ch - 'a'] = new TrieNode();
                }
                cur = cur.children[ch - 'a'];
            }
        }
    }

    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
}