package org.ikilig.algorithms.tree.binarytree;

/**
 * 二叉搜索树ADT
 *
 * @param <E> 元素类型参数
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
    private BinaryNode<E> root;  // 根节点的引用

    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * 清空整棵二叉搜索树
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * 判断是否为空树
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(E target) {
        return contains(target, this.root);
    }

    /**
     * 判断二叉搜索树是否包含某个元素
     *
     * @param target 查找的元素
     * @param tree   搜索的树
     * @return 如果找到返回true，否则返回false
     */
    private boolean contains(E target, BinaryNode<E> tree) {
        if (tree == null) {
            return false;
        }

        int compareResult = target.compareTo(tree.element);

        if (compareResult < 0) {
            return contains(target, tree.left);  // 只要不相等，最后都会走到null
        } else if (compareResult > 0) {
            return contains(target, tree.right);
        } else {
            return true;
        }
    }

    private BinaryNode<E> findMin(BinaryNode<E> tree) {
        if (tree == null) {
            return null;
        } else if (tree.left == null) {
            return tree;
        }
        return findMin(tree.left);
    }

    /**
     * 二叉搜索树节点
     *
     * @param <E> 元素类型参数
     */
    private static class BinaryNode<E> {
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;

        BinaryNode(E element) {
            this(element, null, null);
        }

        BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }
    }
}
