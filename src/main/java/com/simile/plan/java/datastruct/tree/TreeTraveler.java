package com.simile.plan.java.datastruct.tree;

/**
 * @Author yitao
 * @Created 2023/02/13
 */
public class TreeTraveler {

    public TreeNode dfs(Tree tree, String target) {
        if (tree.root != null) {
            return dfsCore(tree.root, target);
        }
        return null;
    }

    TreeNode dfsCore(TreeNode parent, String target) {
        TreeNode result = null;
        if(parent.id.equals(target)){
            return parent;
        }
        if (parent.childs != null) {
            for (TreeNode child : parent.childs) {
                if ((result = dfsCore(child, target)) != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public TreeNode bfs(Tree tree, String target) {
        if (tree.root != null) {
            if(tree.root.id.equals(target)){
                return tree.root;
            }
            return bfsCore(tree.root, target);
        }
        return null;
    }

    TreeNode bfsCore(TreeNode parent, String target) {
        //TODO
        TreeNode result = null;
        if (parent.childs != null) {
            for (TreeNode child : parent.childs) {
                if(child.id.equals(target)){
                    return child;
                }
//                if ((result = bfsCore(child, target)) != null) {
//                    return result;
//                }
            }
        }
        return null;
    }

}
