class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        // Split by "/" to get path parts
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // skip empty or current directory
                continue;
            } 
            else if (part.equals("..")) {
                // go one directory up
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                // valid folder name -> push
                stack.push(part);
            }
        }

        // Build final simplified path
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        // If stack empty -> root
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
