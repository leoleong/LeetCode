/**
 * Problem:
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * 	- Only one letter can be changed at a time
 * 	- Each intermediate word must exist in the dictionary
 * 
 * For example, Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * Return:
 * [
 * 	["hit","hot","dot","dog","cog"],
 * 	["hit","hot","lot","log","cog"]
 * ]
 * 
 * Note:
 * 	- All words have the same length.
 * 	- All words contain only lowercase alphabetic characters.
 */
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

	public static void main(String[] args) {

		String start = "nape";
		String end = "mild";
		Set<String> dict = new HashSet<String>();
		String[] strings = new String[] { "dose", "ends", "dine", "jars",
				"prow", "soap", "guns", "hops", "cray", "hove", "ella", "hour",
				"lens", "jive", "wiry", "earl", "mara", "part", "flue", "putt",
				"rory", "bull", "york", "ruts", "lily", "vamp", "bask", "peer",
				"boat", "dens", "lyre", "jets", "wide", "rile", "boos", "down",
				"path", "onyx", "mows", "toke", "soto", "dork", "nape", "mans",
				"loin", "jots", "male", "sits", "minn", "sale", "pets", "hugo",
				"woke", "suds", "rugs", "vole", "warp", "mite", "pews", "lips",
				"pals", "nigh", "sulk", "vice", "clod", "iowa", "gibe", "shad",
				"carl", "huns", "coot", "sera", "mils", "rose", "orly", "ford",
				"void", "time", "eloy", "risk", "veep", "reps", "dolt", "hens",
				"tray", "melt", "rung", "rich", "saga", "lust", "yews", "rode",
				"many", "cods", "rape", "last", "tile", "nosy", "take", "nope",
				"toni", "bank", "jock", "jody", "diss", "nips", "bake", "lima",
				"wore", "kins", "cult", "hart", "wuss", "tale", "sing", "lake",
				"bogy", "wigs", "kari", "magi", "bass", "pent", "tost", "fops",
				"bags", "duns", "will", "tart", "drug", "gale", "mold", "disk",
				"spay", "hows", "naps", "puss", "gina", "kara", "zorn", "boll",
				"cams", "boas", "rave", "sets", "lego", "hays", "judy", "chap",
				"live", "bahs", "ohio", "nibs", "cuts", "pups", "data", "kate",
				"rump", "hews", "mary", "stow", "fang", "bolt", "rues", "mesh",
				"mice", "rise", "rant", "dune", "jell", "laws", "jove", "bode",
				"sung", "nils", "vila", "mode", "hued", "cell", "fies", "swat",
				"wags", "nate", "wist", "honk", "goth", "told", "oise", "wail",
				"tels", "sore", "hunk", "mate", "luke", "tore", "bond", "bast",
				"vows", "ripe", "fond", "benz", "firs", "zeds", "wary", "baas",
				"wins", "pair", "tags", "cost", "woes", "buns", "lend", "bops",
				"code", "eddy", "siva", "oops", "toed", "bale", "hutu", "jolt",
				"rife", "darn", "tape", "bold", "cope", "cake", "wisp", "vats",
				"wave", "hems", "bill", "cord", "pert", "type", "kroc", "ucla",
				"albs", "yoko", "silt", "pock", "drub", "puny", "fads", "mull",
				"pray", "mole", "talc", "east", "slay", "jamb", "mill", "dung",
				"jack", "lynx", "nome", "leos", "lade", "sana", "tike", "cali",
				"toge", "pled", "mile", "mass", "leon", "sloe", "lube", "kans",
				"cory", "burs", "race", "toss", "mild", "tops", "maze", "city",
				"sadr", "bays", "poet", "volt", "laze", "gold", "zuni", "shea",
				"gags", "fist", "ping", "pope", "cora", "yaks", "cosy", "foci",
				"plan", "colo", "hume", "yowl", "craw", "pied", "toga", "lobs",
				"love", "lode", "duds", "bled", "juts", "gabs", "fink", "rock",
				"pant", "wipe", "pele", "suez", "nina", "ring", "okra", "warm",
				"lyle", "gape", "bead", "lead", "jane", "oink", "ware", "zibo",
				"inns", "mope", "hang", "made", "fobs", "gamy", "fort", "peak",
				"gill", "dino", "dina", "tier" };

		for (String string : strings) {
			dict.add(string);
		}

		List<List<String>> result = findLadders(start, end, dict);

		for (List<String> path : result) {
			System.out.println(path.toString());
		}
	}

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict) {

		Queue<String> queue = new ArrayDeque<String>();
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, Integer> levels = new HashMap<String, Integer>();
		int eof = Integer.MAX_VALUE;

		// store shortest solutions
		dict.add(start);
		queue.add(end);
		levels.put(end, 1);
		while (!queue.isEmpty()) {
			String current = queue.poll();
			int level = levels.get(current);
			if (level >= eof) {
				break;
			}
			for (int i = 0; i < current.length(); i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					StringBuilder sb = new StringBuilder(current);
					if (sb.charAt(i) == j) {
						continue;
					}
					sb.setCharAt(i, j);
					String str = sb.toString();
					if (str.equals(start)) {
						eof = level + 1;
					}
					if (dict.contains(str)) {
						if (levels.containsKey(str) && levels.get(str) <= level) {
							continue;
						}
						if (map.containsKey(str)
								&& map.get(str).contains(current)) {
							continue;
						}
						if (map.containsKey(str)) {
							map.get(str).add(current);
							map.put(str, map.get(str));
						} else {
							List<String> values = new ArrayList<String>();
							values.add(current);
							map.put(str, values);
						}
						levels.put(str, level + 1);
						queue.offer(str);
					}
				}
			}
		}

		// generate all solutions
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> path = new ArrayList<String>();
		if (map.containsKey(start)) {
			path.add(start);
			dfs(result, path, map, start, end);
		}

		return result;
	}

	private static void dfs(List<List<String>> result, List<String> path,
			Map<String, List<String>> map, String start, String end) {

		if (start.equals(end)) {
			result.add(new ArrayList<String>(path));
			return;
		}

		for (String next : map.get(start)) {
			path.add(next);
			dfs(result, path, map, next, end);
			path.remove(path.size() - 1);
		}
	}
}
