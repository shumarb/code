import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdjacencyList extends BasicOperations {
    private List<ArrayList<IntegerPair>> adjacencyList = new ArrayList<ArrayList<IntegerPair>> ();
    private List<String> verticesList = new ArrayList <> ();

    private void displaysAdjacencyList() {
        System.out.println("Adjacency List: ");
        for (int i = 0; i < adjacencyList.size(); i++) {
            displaysNewLine();
            System.out.print(" * Vertex " + getsVertex(i) + " | ");
            ArrayList<IntegerPair> neighboursList = adjacencyList.get(i);
            for (int j = 0; j < neighboursList.size(); j++) {
                IntegerPair currentIntegerPair = neighboursList.get(j);
                System.out.print("[" + currentIntegerPair.getsEndVertex() + ", W: " + currentIntegerPair.getsWeight() + "]");
                if (j != neighboursList.size() - 1) {
                    System.out.print(", ");
                }
                if (j == neighboursList.size() - 1) {
                    displaysNewLine();
                }
            }
        }
        displaysLine();
    }

    private List<String> formsPossibleNeighboursList(String currentVertex) {
        List<String> availableVerticesList = new ArrayList<> ();
        for (int i = 0; i < verticesList.size(); i++) {
            if (!getsVertex(i).equals(currentVertex)) {
                availableVerticesList.add(getsVertex(i));
            }
        }
        return availableVerticesList;
    }

    private IntegerPair getsIntegerPair(ArrayList<IntegerPair> adjList, String neighbour) {
        for (int i = 0; i < adjList.size(); i++) {
            IntegerPair currentIntegerPair = adjList.get(i);
            if (currentIntegerPair.getsEndVertex().equals(neighbour)) {
                return currentIntegerPair;
            }
        }
        return null;
    }

    private String getsVertex(int vertexNumber) {
        String vertex = "";
        switch(vertexNumber) {
            case 0: vertex = "A"; break;
            case 1: vertex = "B"; break;
            case 2: vertex = "C"; break;
            case 3: vertex = "D"; break;
            case 4: vertex = "E"; break;
            case 5: vertex = "F"; break;
            case 6: vertex = "G"; break;
            default: vertex = "";
        }
        return vertex;
    }

    private int getsVertex(String vertexName) {
        int vertexNumber = 0;
        switch(vertexName) {
            case "A": vertexNumber = 0; break;
            case "B": vertexNumber = 1; break;
            case "C": vertexNumber = 2; break;
            case "D": vertexNumber = 3; break;
            case "E": vertexNumber = 4; break;
            case "F": vertexNumber = 5; break;
            case "G": vertexNumber = 6; break;
            default: vertexNumber = 0;
        }
        return vertexNumber;
    }

    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        int numberOfVertices = myRandom.nextInt(3, 7);
        for (int i = 0; i < numberOfVertices; i++) {
            verticesList.add(getsVertex(i));
        }
        System.out.println("Forming an Adjacency List with " + numberOfVertices + " vertices: " + verticesList);
        displaysNewLine();
        for (int i = 0; i < verticesList.size(); i++) {
            String currentVertex = getsVertex(i);
            List<String> possibleNeighboursList = formsPossibleNeighboursList(currentVertex);
            ArrayList<IntegerPair> neighboursList = new ArrayList<> ();
            System.out.println(" * Vertex " + currentVertex + " | Possible neighbours: " + possibleNeighboursList);
            for (int j = 0; j < possibleNeighboursList.size(); j++) {
                int weight = myRandom.nextInt(-100, 101);
                IntegerPair incomingIntegerPair = new IntegerPair(possibleNeighboursList.get(j), weight);
                neighboursList.add(incomingIntegerPair);
                Collections.sort(possibleNeighboursList);
            }
            adjacencyList.add(i, neighboursList);
            if (i != verticesList.size() - 1) {
                displaysNewLine();
            }
        }
        updatesAdjacencyList();
        displaysLine();
    }

    private boolean isContainNeighbour(ArrayList <IntegerPair> neighbourAdjList, String neighbour) {
        for (int i = 0; i < neighbourAdjList.size(); i++) {
            IntegerPair currPair = neighbourAdjList.get(i);
            if (currPair.getsEndVertex().equals(neighbour)) {
                return true;
            }
        }
        return false;
    }

    private void updatesAdjacencyList() {
        // 1. If 2 vertices are connected to one another by an edge,
        // ensure each vertex is in the other vertex's adjacency list
        for (int i = 0; i < adjacencyList.size(); i++) {
            String currentVertex = getsVertex(i);
            ArrayList<IntegerPair> currentVertexAdjList = adjacencyList.get(i);
            for (int j = 0; j < currentVertexAdjList.size(); j++) {
                IntegerPair currentPair = currentVertexAdjList.get(j);
                String neighbourVertex = currentPair.getsEndVertex();
                int weight = currentPair.getsWeight();
                if (!isContainNeighbour(adjacencyList.get(getsVertex(neighbourVertex)), currentVertex)) {
                    adjacencyList.get(getsVertex(neighbourVertex)).add(new IntegerPair(currentVertex, weight));
                }
            }
        }

        // 2. If 2 vertices are connected to one another by an edge,
        // ensure the weight of the edge connecting the vertices to each other is the same
        for (int i = 0; i < adjacencyList.size(); i++) {
            String currentVertex = getsVertex(i);
            ArrayList<IntegerPair> currentVertexAdjList = adjacencyList.get(i);
            for (int j = 0; j < currentVertexAdjList.size(); j++) {
                IntegerPair currentPair = currentVertexAdjList.get(j);
                IntegerPair toCheckPair = getsIntegerPair(adjacencyList.get(getsVertex(currentPair.getsEndVertex())), currentVertex);
                if (toCheckPair.getsWeight() != currentPair.getsWeight()) {
                    toCheckPair.setsWeight(currentPair.getsWeight());
                }
            }
        }

        for (int i = 0; i < adjacencyList.size(); i++) {
            Collections.sort(adjacencyList.get(i));
        }
    }

    private void run() {
        insertion();
        displaysAdjacencyList();
    }

    public static void main(String[] args) {
        AdjacencyList obj = new AdjacencyList();
        obj.run();
    }

}
