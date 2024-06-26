package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Using Striver - Khan Algo (Topo sort using BFS)
public class CourseSchedule1UsingTopoSortBFS {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
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
            nodesProcessed += 1;

            for (Integer neighbour : adjacencyList[curNode]) {
                inDegree[neighbour] -= 1;
                if (inDegree[neighbour] == 0) {
                    q.offer(neighbour);
                }
            }

        }

        if (nodesProcessed == numCourses)
            return true;

        return false;
    }

    public static void main(String[] args) {
//        int[][] prereq = {
//                {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 1}
//        };
//        int V = 5;

        int[][] prereq = {{1, 0}};
        int V = 2;

        System.out.println(canFinish(V, prereq));

    }

}
