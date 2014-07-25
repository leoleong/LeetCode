package detail;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		intervals.add(new Interval(18, 20));

		List<Interval> result = insert(intervals, new Interval(4, 9));

		for (Interval interval : result) {
			System.out.println(interval.start + "--" + interval.end);
		}
	}

	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		List<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}
		result.add(newInterval);

		return result;
	}

	// Definition for an interval.
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
