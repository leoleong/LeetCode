package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {

	private static Map<String, Set<String>> parent;
	private static Map<String, Integer> level;
	private static int min;

	public static void main(String[] args) {

		String start = "nape";
		String end = "mild";
		Set<String> dict = new HashSet<String>();
		String[] strings = new String[] { "dose", "ends", "dine", "jars", "prow", "soap", "guns", "hops", "cray", "hove", "ella", "hour",
				"lens", "jive", "wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull", "york", "ruts", "lily", "vamp", "bask",
				"peer", "boat", "dens", "lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx", "mows", "toke", "soto", "dork",
				"nape", "mans", "loin", "jots", "male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds", "rugs", "vole", "warp",
				"mite", "pews", "lips", "pals", "nigh", "sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns", "coot", "sera",
				"mils", "rose", "orly", "ford", "void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt", "rung",
				"rich", "saga", "lust", "yews", "rode", "many", "cods", "rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
				"jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins", "cult", "hart", "wuss", "tale", "sing", "lake", "bogy",
				"wigs", "kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns", "will", "tart", "drug", "gale", "mold", "disk",
				"spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas", "rave", "sets", "lego", "hays", "judy",
				"chap", "live", "bahs", "ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews", "mary", "stow", "fang", "bolt",
				"rues", "mesh", "mice", "rise", "rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils", "vila", "mode", "hued",
				"cell", "fies", "swat", "wags", "nate", "wist", "honk", "goth", "told", "oise", "wail", "tels", "sore", "hunk", "mate",
				"luke", "tore", "bond", "bast", "vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair", "tags",
				"cost", "woes", "buns", "lend", "bops", "code", "eddy", "siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn",
				"tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems", "bill", "cord", "pert", "type", "kroc", "ucla", "albs",
				"yoko", "silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole", "talc", "east", "slay", "jamb", "mill", "dung",
				"jack", "lynx", "nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled", "mile", "mass", "leon", "sloe", "lube",
				"kans", "cory", "burs", "race", "toss", "mild", "tops", "maze", "city", "sadr", "bays", "poet", "volt", "laze", "gold",
				"zuni", "shea", "gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo", "hume", "yowl", "craw",
				"pied", "toga", "lobs", "love", "lode", "duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe", "pele", "suez",
				"nina", "ring", "okra", "warm", "lyle", "gape", "bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope", "hang",
				"made", "fobs", "gamy", "fort", "peak", "gill", "dino", "dina", "tier" };
		for (String string : strings) {
			dict.add(string);
		}

		List<List<String>> result = findLadders(start, end, dict);

		for (List<String> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {

		Queue<String> queue = new ArrayDeque<String>();
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
		parent = new HashMap<String, Set<String>>();
		level = new HashMap<String, Integer>();
		min = Integer.MAX_VALUE;

		queue.offer(start);
		path.add(start);
		parent.put(start, new HashSet<String>());
		level.put(start, 1);
		while (!queue.isEmpty()) {
			String head = queue.poll();
			int len = level.get(head);
			if (len >= min) {
				break;
			}
			for (int i = 0; i < head.length(); i++) {
				StringBuilder sb = new StringBuilder(head);
				for (char ch = 'a'; ch <= 'z'; ch++) {
					if (head.charAt(i) == ch) {
						continue;
					}
					sb.setCharAt(i, ch);
					String str = sb.toString();
					if (str.equals(end)) {
						Set<String> child;
						if (parent.containsKey(head)) {
							child = parent.get(head);
						} else {
							child = new HashSet<String>();
						}
						child.add(end);
						min = len + 1;
						parent.put(head, child);
						level.put(end, len + 1);
					}
					if (dict.contains(str) && (!level.containsKey(str) || level.get(str) == len + 1)) {
						Set<String> set;
						if (parent.containsKey(head)) {
							set = parent.get(head);
						} else {
							set = new HashSet<String>();
						}
						set.add(str);
						queue.offer(str);
						parent.put(head, set);
						level.put(str, len + 1);
					}
				}
			}
		}

		dfs(result, path, start, end);

		return result;
	}

	private static void dfs(List<List<String>> result, List<String> path, String start, String end) {

		if (start.equals(end)) {
			result.add(new ArrayList<String>(path));
			return;
		}
		if (parent.get(start) == null) {
			return;
		}
		for (String str : parent.get(start)) {
			path.add(str);
			dfs(result, path, str, end);
			path.remove(path.size() - 1);
		}
	}
}
