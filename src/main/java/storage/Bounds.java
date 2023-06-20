package storage;

public record Bounds<T extends Comparable<T>>(
    Point<T> topLeft,
    Point<T> bottomRight) {


  boolean insideBounds(Point<T> point) {
    if(topLeft.numDimensions() != point.numDimensions() || bottomRight.numDimensions() != point.numDimensions()) {
      throw new IllegalArgumentException("Number of dimensions not equal to bounds");
    }

    for(int dimension = 0; dimension < point.numDimensions(); dimension++) {
      if(topLeft.compareByDimensions(point, dimension) > 0 || bottomRight.compareByDimensions(point, dimension) < 0) {
        return false;
      }
    }
    return true;
  }


  @Override
  public String toString() {
    return "[ " + topLeft.toString() + " -> " + bottomRight.toString() + " ]";
  }
}
