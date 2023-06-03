package storage;

public class LeafNode<T extends Comparable<T>> implements Node<T> {

  @Override
  public boolean isLeaf() {
    return true;
  }
}
