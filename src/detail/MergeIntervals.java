package detail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {

	}

	public static List<Interval> merge(List<Interval> intervals) {

		if (intervals.size() < 1) {
			return intervals;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		List<Interval> result = new ArrayList<Interval>();
		Interval newInterval = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.end < newInterval.start) {
				result.add(interval);
			} else if (interval.start > newInterval.end) {
				result.add(newInterval);
				newInterval = interval;
			} else {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
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
