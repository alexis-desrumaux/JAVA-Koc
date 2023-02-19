/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: Alexis Desrumaux, 0078296
********************************************************************************/

package comp132;

import java.util.*;

import comp132.Point;
import id78296.Triangle;

public class FirstClass {

	public static void whichQuadrant(Point p) {
		if (p.getX() < 0 && p.getX() >= -7) {
			if (p.getY() <= 7 && p.getY() > 0) {
				System.out.printf("x: %f, y: %f, quadrant: II\n", p.getX(), p.getY());
			} else if (p.getY() < 0 && p.getY() >= -7) {
				System.out.printf("x: %f, y: %f, quadrant: III\n", p.getX(), p.getY());
			}
		} else if (p.getX() > 0 && p.getX() <= -7) {
			if (p.getY() <= 7 && p.getY() > 0) {
				System.out.printf("x: %f, y: %f, quadrant: I\n", p.getX(), p.getY());
			} else if (p.getY() < 0 && p.getY() >= -7) {
				System.out.printf("x: %f, y: %f, quadrant: IV\n", p.getX(), p.getY());
			}
		}
	}

	public static void main(String[] args) {
		System.out.printf("%s\n", "My Programming Exercise");
		Scanner scanner = new Scanner(System.in);

		Point point1 = new Point();
		Point point2 = new Point();
		System.out.printf("Enter x1: ");
		point1.setX(scanner.nextDouble());
		System.out.printf("Enter y1: ");
		point1.setY(scanner.nextDouble());
		System.out.printf("Enter x2: ");
		point2.setX(scanner.nextDouble());
		System.out.printf("Enter y2: ");
		point2.setY(scanner.nextDouble());
		point2.inverse();
		double result = distance(point1.getX(), point1.getY(), point2.getX(), point2.getY());
		System.out.printf("The distance between (%.2f,%.2f) and (%.2f,%.2f) is %f\n", point1.getX(), point1.getY(), point2.getX(), point2.getY(), result);
		whichQuadrant(point1);
		whichQuadrant(point2);
		System.out.println("Enter n:");
		int n = scanner.nextInt();
		for (int i = 0; i != n; i += 1) {
			System.out.println("Enter x1 and y1:");
			Point t1 = new Point();
			t1.setX(scanner.nextDouble());
			t1.setY(scanner.nextDouble());
			System.out.println("Enter x2 and y2:");
			Point t2 = new Point();
			t2.setX(scanner.nextDouble());
			t2.setY(scanner.nextDouble());
			System.out.println("Enter x3 and y3:");
			Point t3 = new Point();
			t3.setX(scanner.nextDouble());
			t3.setY(scanner.nextDouble());
			Triangle triangle = new Triangle(t1, t2, t3);
			System.out.printf("The area of the triangle is %f\n", triangle.findArea());
		}
		scanner.close();
	}

	// computes the distance between two points (x1,y1) and (x2,y2)
	private static double distance(double x1, double y1, double x2, double y2) {

		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

	}

}
