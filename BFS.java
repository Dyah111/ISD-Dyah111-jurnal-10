import java.util.*;

public class BFS {
    private Map<Character, List<Character>> adjList;

    public BFS() {
        adjList = new HashMap<>();
    }

    public void addEdge(char src, char dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    public List<Character> bfs(char start) {
        List<Character> bfsOrder = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Queue<Character> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            char vertex = queue.poll();
            bfsOrder.add(vertex);

            for (char neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return bfsOrder;
    }

    public static void main(String[] args) {
        BFS g = new BFS();

        g.addEdge('A', 'D');
        g.addEdge('A', 'B');
        g.addEdge('B', 'E');
        g.addEdge('C', 'B');
        g.addEdge('D', 'G');
        g.addEdge('E', 'C');
        g.addEdge('E', 'H');
        g.addEdge('F', 'E');
        g.addEdge('G', 'H');
        g.addEdge('H', 'F');
        g.addEdge('H', 'I');
        g.addEdge('I', 'F');

        System.out.println("BFS Order: " + g.bfs('A'));
    }
}
