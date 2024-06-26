package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2UsingTopoSortBFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] topoSort = new int[numCourses];
        int nodesProcessed = 0;

        ArrayList<Integer>[] adjacencyList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjacencyList[i] = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int[] edge : prerequisites) {
            adjacencyList[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer curNode = q.poll();
            topoSort[nodesProcessed++] = curNode;

            for (Integer neighbour : adjacencyList[curNode]) {
                inDegree[neighbour] -= 1;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }

        }

        if (nodesProcessed == numCourses)
            return topoSort;

        return new int[0];
    }
}
