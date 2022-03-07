package algorithmWithLeetcode.bfs.topologicalsort;

import java.util.*;

public class CourseSchedule210 {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] res = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null || prerequisites.length < 1
                || prerequisites[0] == null || prerequisites[0].length < 1) {
            return null;
        }

        // 构建图: 每个index上又一个list，表示该课的先修课有哪些
        List[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList();
        }

        // 入度，有几个箭头指向我
        // 装课
        int[] inDegree = new int[numCourses];
        for (int[] course : prerequisites) {
            graph[course[1]].add(course[0]);
            inDegree[course[0]]++;
        }
        System.out.println(Arrays.toString(graph));
        System.out.println(Arrays.toString(inDegree));


        // 将入度为0的点放入Queue中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int numOfChoose = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            res[numOfChoose++] = curCourse;
            for (int i = 0; i < graph[curCourse].size(); i++) {
                int nextCourse = (int) graph[curCourse].get(i);
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        if (numOfChoose == numCourses) {
            return res;
        }
        return new int[0];
    }

}
