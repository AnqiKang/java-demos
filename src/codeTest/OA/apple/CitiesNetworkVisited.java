package codeTest.OA.apple;

/**
 * 2019-11-05 --1
 */

import java.util.ArrayList;
import java.util.List;

public class CitiesNetworkVisited {
    public static void main(String[] args) {
        //int[] cities = {0, 9, 0, 2, 6, 8, 0, 8, 3, 0};
        int[] cities = {0, 0, 0, 1, 6, 1, 0, 0};
        List<List<Integer>> graph = construct(cities);
        System.out.println(graph);

        List<List<Integer>> paths = new ArrayList<>();
        dfs(paths, graph, new ArrayList<>(), 0, 0);
        System.out.println(paths);

        int maxVisited = maxPath(paths);
        System.out.println(maxVisited);
    }

    private static int maxPath(List<List<Integer>> paths) {
        int max = 0;
        for (List list : paths) {
            int cur = (int) list.stream().count();
            if (max < cur) {
                max = cur;
            }
        }
        return max + 1;
    }

    private static void dfs(List<List<Integer>> paths, List<List<Integer>> graph,
                            List<Integer> path, int odd, int index) {


        if (graph.get(index).size() == 0 || odd == 1 && index % 2 != 1 || odd > 1 && index % 2 == 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph.get(index).size(); i++) {
            int curCity = graph.get(index).get(i);

            //path.add(curCity);

            if (curCity % 2 == 1) {
                odd++;
            }
            if (odd <= 1) {
                path.add(curCity);
            }

            dfs(paths, graph, path, odd, curCity);

            if (path.size() != 0 && odd < 2) {
                path.remove(path.size() - 1);
            }
            odd--;
        }
    }


    private static List<List<Integer>> construct(int[] cities) {
        int numOfCities = cities.length;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numOfCities; i++) {
            graph.add(i, new ArrayList<>());
        }
        //System.out.println(graph);
        for (int i = 1; i < graph.size(); i++) {
            graph.get(cities[i]).add(i);
        }

        return graph;
    }


}
