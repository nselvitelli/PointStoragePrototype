package storage;

import java.util.Optional;

public class TreeNode<T extends Comparable<T>> implements Node<T> {

  private final Point<T> point;
  private final Point<T> prevPoint;

  private Node<T> leftChild;
  private Node<T> rightChild;

  public TreeNode(Point<T> point, Point<T> prevPoint) {
    this.point = point;
    this.prevPoint = prevPoint;
    this.leftChild = new LeafNode<>();
    this.rightChild = new LeafNode<>();
  }

  public Point<T> getPoint() {
    return this.point;
  }

  public Point<T> getPrevious() {
    return prevPoint;
  }

  public Node<T> getLeftChild() {
    return leftChild;
  }

  public Node<T> getRightChild() {
    return rightChild;
  }

  public void setLeftChild(Node<T> node) {
    this.leftChild = node;
  }

  public void setRightChild(Node<T> node) {
    this.rightChild = node;
  }

  public int compareOnDimension(TreeNode<T> other, int dimension) {
    return this.point.compareByDimensions(other.point, dimension);
  }

  @Override
  public boolean isLeaf() {
    return false;
  }
}