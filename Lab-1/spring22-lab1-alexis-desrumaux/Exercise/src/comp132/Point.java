package comp132;

public class Point {
  private double x;
  private double y;

  public Point() {
    this.x = 0;
    this.y = 0;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public void inverse() {
    this.x *= -1;
    this.y *= -1;
  }
}