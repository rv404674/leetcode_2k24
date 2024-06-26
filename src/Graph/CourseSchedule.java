package Graph;

import java.util.LinkedList;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new LinkedList<>();

        for (int[] a : prerequisites) {
            graph[a[0]].add(a[1]);
        }

        // 0 - not visited
        // -1 - visiting
        // 1 - visited
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(graph, visited, i))
                    return false;
            }
        }

        return true;
    }

    // Return false if cycle is detected
    public static boolean dfs(LinkedList<Integer>[] graph, int[] visited, int curNode) {
        if (visited[curNode] == -1)
            return false;

        if (visited[curNode] == 1)
            return true;

        visited[curNode] = -1; // Mark as visiting

        for (int neighbour : graph[curNode]) {
            if (!dfs(graph, visited, neighbour))
                return false;
        }

        visited[curNode] = 1; // Mark as visited
        return true;
    }

    public static void main(String[] args) {

    }
}
