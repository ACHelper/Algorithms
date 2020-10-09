class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean evenNow = false;
        int level = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            List<TreeNode> curLevel = new ArrayList<>();
            
            while (!q.isEmpty()) {
                TreeNode temp = q.poll();
                curLevel.add(temp);
            }
            
            if (evenNow) {
                for (TreeNode cur : curLevel) {
                    if (cur.val % 2 == 1) {
                        return false;
                    }   
                }
            } else {
                for (TreeNode cur : curLevel) {
                    if (cur.val % 2 == 0) {
                        return false;
                    }
                }
            }
            
            
            TreeNode prevN = curLevel.get(0);
            int prev = prevN.val;
            int i = 0;
            if (level % 2 == 0) {
                // Strictly increasing
                for (TreeNode cur : curLevel) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    if (cur.val <= prev) {
                        return false;
                    }                    
                    prev = cur.val;
                }
            } else {
                for (TreeNode cur : curLevel) {
                    if (i == 0) {
                        i++;
                        continue;
                    }
                    if (cur.val >= prev) {
                        return false;
                    }                    
                    prev = cur.val;
                }
            }
            
            
            for (TreeNode cur : curLevel) {
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            
            // TODO put children intor tree
            evenNow = !evenNow;
            level++;
        }
        
        return true;
    }
}