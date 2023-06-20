package storage;

import java.util.Optional;

public class TreeNode<T extends Comparable<T>> implements Node<T> {

  private final Point<T> point;
  private final Optional<Point<T>> prevPoint;

  private Node<T> leftChild;
  private Node<T> rightChild;

  public TreeNode(Point<T> point) {
    this.point = point;
    this.prevPoint = Optional.empty();
    this.leftChild = new LeafNode<>();
    this.rightChild = new LeafNode<>();
  }

  public TreeNode(Point<T> point, Point<T> prevPoint) {
    this.point = point;
    this.prevPoint = Optional.of(prevPoint);
    this.leftChild = new LeafNode<>();
    this.rightChild = new LeafNode<>();
  }

  public Point<T> getPoint() {
    return this.point;
  }

  public Optional<Point<T>> getPrevious() {
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

  public int comparePointOnDimension(Point<T> other, int dimension) {
    return this.point.compareByDimensions(other, dimension);
  }

  @Override
  public boolean isLeaf() {
    return false;
  }
}