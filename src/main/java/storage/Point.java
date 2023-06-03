package storage;

public class Point<T extends Comparable<T>> {

  private final T[] points;

  /**
   * Instantiate the values within this point. The first indexed value maps to the 0th dimension and
   * so on in increasing order.
   *
   * @param points the values for the point
   */
  @SafeVarargs
  public Point(T... points) {
    this.points = points;
  }

  /**
   * Retrieve this point's number of dimensions.
   * @return the number of dimensions in this point
   */
  public int numDimensions() {
    return this.points.length;
  }

  /**
   * Returns the value for the given dimension index of the point. A dimension index for a (x, y, z)
   * point would look like 0 for x, 1 for y, and 2 for z.
   *
   * @param dimension the index of the dimension
   * @return the value at the dimension index
   * @throws IllegalArgumentException if the given dimension is out of bounds
   */
  public T getValue(int dimension) throws IllegalArgumentException {
    if(isDimensionOutOfBounds(dimension)) {
      throw new IllegalArgumentException("Dimension out of bounds for this point ("
          + this.points.length + "). Given: " + dimension);
    }

    return this.points[dimension];
  }

  /**
   * Compares this point with another point and returns a value to determine ordering. Zero means
   * the points are equal on the given dimension, 1 means this point should follow the other point,
   * and -1 means this point should precede the other point.
   *
   * @param other the second point to compare to
   * @param dimension the dimension to compare on
   * @return the ordering result of the two points
   * @throws IllegalArgumentException if the dimension is out of bounds for either point
   */
  public int compareByDimensions(Point<T> other, int dimension) throws IllegalArgumentException {
    if(isDimensionOutOfBounds(dimension) || other.isDimensionOutOfBounds(dimension))  {
      throw new IllegalArgumentException("Cannot compare, dimension out of bounds for one or both points.");
    }

    return this.points[dimension].compareTo(other.points[dimension]);
  }

  /**
   * Determines if the given dimension is out of bounds for this point.
   *
   * @param dimension the dimension
   * @return if this dimension is out of bounds
   */
  private boolean isDimensionOutOfBounds(int dimension) {
    return dimension >= points.length || dimension < 0;
  }

}
