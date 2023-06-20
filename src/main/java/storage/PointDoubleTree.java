package storage;

import java.util.ArrayList;
import java.util.List;

public class PointDoubleTree {

  private Node<Double> root;
  private Point<Double> previouslyAddedPoint;

  public PointDoubleTree() {
    this.root = new LeafNode<>();
  }

  public void add(Point<Double> point) {
    if(this.root.isLeaf()) {
      this.root = new TreeNode<>(point);
    }
    else {
      add((TreeNode<Double>) this.root, point, 0);
    }
  }

  private void add(TreeNode<Double> tree, Point<Double> point, int dimensionToCompare) {
    Node<Double> childToTraverseTo;
    // point should be added to the right child
    if (tree.comparePointOnDimension(point, dimensionToCompare) < 0) {
      childToTraverseTo = tree.getRightChild();
      if(childToTraverseTo.isLeaf()) {
        tree.setRightChild(new TreeNode<>(point, this.previouslyAddedPoint));
        this.previouslyAddedPoint = point;
        return;
      }
    }
    else { //point added to the left child
      childToTraverseTo = tree.getLeftChild();
      if(childToTraverseTo.isLeaf()) {
        tree.setLeftChild(new TreeNode<>(point, this.previouslyAddedPoint));
        this.previouslyAddedPoint = point;
        return;
      }
    }
    int nextDimension = (dimensionToCompare + 1) % point.numDimensions();
    add((TreeNode<Double>) childToTraverseTo, point, nextDimension);
  }


  public List<TreeNode<Double>> getAllNodesWithinBounds(Bounds<Double> bounds) {
    List<TreeNode<Double>> nodes = new ArrayList<>();
    if(this.root.isLeaf()) {
      return nodes;
    }

    return null;
  }
}
