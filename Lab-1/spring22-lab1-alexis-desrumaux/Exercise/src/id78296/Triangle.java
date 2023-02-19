package id78296;

import comp132.Point;

public class Triangle {
  private Point a;
  private Point b;
  private Point c;

  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double findArea() {
    double preResult = this.a.getX() * this.b.getY() - this.b.getX() * this.a.getY() + this.b.getX() * this.c.getY() - this.c.getX() * this.b.getY() + this.c.getX() * this.a.getY() - this.a.getX() * this.c.getY();
    if (preResult < 0)
      preResult *= -1;
    return preResult / 2;
  }
}