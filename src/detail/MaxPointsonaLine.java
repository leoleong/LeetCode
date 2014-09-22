/**
 * Problem:
 * Given n points on a 2D plane, 
 * find the maximum number of points that lie on the same straight line.
 */
package detail;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsonaLine {

	public static void main(String[] args) {

		Point[] points = new Point[] { new Point(2, 3), new Point(3, 3),
				new Point(-5, 3) };
		int result = maxPoints(points);
		System.out.println(result);
	}

	private static int maxPoints(Point[] points) {

		if (points == null) {
			return 0;
		}
		if (points.length < 3) {
			return points.length;
		}

		Map<Double, Integer> map;
		int result = 0;

		for (int i = 0; i < points.length - 1; i++) {
			map = new HashMap<Double, Integer>();
			int samePoint = 0;
			int cur = 1;
			for (int j = i + 1; j < points.length; j++) {
				double slope = 0;
				int num = 0;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					samePoint++;
					continue;
				} else if (points[i].x == points[j].x) {
					slope = Double.MAX_VALUE;
				} else if (points[i].y == points[j].y) {
					slope = 0;
				} else {
					slope = (double) (points[i].y - points[j].y)
							/ (double) (points[i].x - points[j].x);
				}
				if (map.containsKey(slope)) {
					num = map.get(slope);
					num++;
				} else {
					num = 2;
				}
				map.put(slope, num);
				cur = Math.max(cur, num);
			}
			result = Math.max(result, cur + samePoint);
		}

		return result;
	}

	// Definition for a point.
	private static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}
