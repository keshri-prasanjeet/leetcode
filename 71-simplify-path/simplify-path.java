class Solution {
    public String simplifyPath(String path) {
        Stack<String> pathMaker = new Stack<>();
        String[] directories = path.split("/");
        for(String directory:directories){
            if(!directory.isEmpty()){
                if(!directory.equals("..")){
                    if(!directory.equals(".")){
                        pathMaker.push(directory);
                    }
                }
                else{
                    if(!pathMaker.isEmpty()){
                        pathMaker.pop();
                    }
                }
            }
        }
        StringBuilder canonicalPath = new StringBuilder();
        while(!pathMaker.isEmpty()){
            canonicalPath.insert(0, pathMaker.pop());
            canonicalPath.insert(0, "/");
        }
        return canonicalPath.length() == 0 ? "/" : canonicalPath.toString();
    }
}