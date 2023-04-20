import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        int idx = 0;
			Map<Integer, String> mapNum = new HashMap<>();
			Map<String, Integer> mapStr = new HashMap<>();
			for (String player : players) {
				mapNum.put(idx, player);
				mapStr.put(player, idx);
				idx++;
			}

			for (String calling : callings) {
				int order = mapStr.get(calling);
				String front = mapNum.get(order - 1);
				mapNum.put(order - 1, calling);
				mapNum.put(order, front);
				mapStr.put(calling, order - 1);
				mapStr.put(front, order);
			}

			int playerSize = players.length;
			List<String> resultsList = new ArrayList<>();
			for (int i = 0; i < playerSize; i++) {
				resultsList.add(mapNum.get(i));
			}

			String[] answer = resultsList.toArray(new String[playerSize]);
			return answer;
    }
}