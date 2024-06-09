import java.util.*;

public class DFS {

    private Map<Character, List<Character>> adjList;

    public DFS() {
        adjList = new HashMap<>();
    }

    public void addEdge(char src, char dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.get(src).add(dest);
    }

    public List<Character> dfs(char start) {
        List<Character> dfsOrder = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            char vertex = stack.pop();

            if (!visited.contains(vertex)) {
                dfsOrder.add(vertex);
                visited.add(vertex);

                for (char neighbor : adjList.getOrDefault(vertex, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return dfsOrder;
    }

    public static void main(String[] args) {
        DFS g = new DFS();

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

        System.out.println("DFS Order: " + g.dfs('A'));
    }
}