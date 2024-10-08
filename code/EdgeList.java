import java.util.ArrayList;
import java.util.Collections;

class EdgeList extends BasicOperations {
    private ArrayList <IntegerTriple> edgeList = new ArrayList<> ();
    private ArrayList <String> verticesList = new ArrayList<> ();

    private void displaysEdgeList() {
        System.out.println("EdgeList: ");
        displaysNewLine();
        for (int i = 0; i < edgeList.size() - 1; i++) {
            IntegerTriple currentIntegerTriple = edgeList.get(i);
            System.out.println(" * [" + currentIntegerTriple.getsStartVertex() + 
                               " ---- " + currentIntegerTriple.getsEndVertex() + 
                               " | W: " + currentIntegerTriple.getsWeight() + 
                               "]"
            );
            displaysNewLine();
        }
        IntegerTriple lastIntegerTriple = edgeList.get(edgeList.size() - 1);
        System.out.println(" * [" + lastIntegerTriple.getsStartVertex() + 
                           " ---- " + lastIntegerTriple.getsEndVertex() + 
                           " | W: " + lastIntegerTriple.getsWeight() + "]"
        );
        displaysLine();
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

    private ArrayList<String> formsPossibleNeighboursList(String currentVertex) {
        ArrayList <String> availableVerticesList = new ArrayList <> ();
        for (int i = 0; i < verticesList.size(); i++) {
            if (!getsVertex(i).equals(currentVertex)) {
                availableVerticesList.add(getsVertex(i));
            }
        }
        return availableVerticesList;
    }

    private void insertion() {
        displaysLine();
        int numberOfVertices = myRandom.nextInt(3, 7);
        for (int i = 0; i < numberOfVertices; i++) {
            verticesList.add(getsVertex(i));
        }
        System.out.println("Forming an EdgeList with " + numberOfVertices + " vertices: " + verticesList);
        displaysNewLine();

        for (int i = 0; i < verticesList.size(); i++) {
            String startVertex = getsVertex(i);
            ArrayList <String> possibleNeighboursList = formsPossibleNeighboursList(startVertex);
            System.out.println(" * Vertex: " + startVertex + " | Available Vertices for Pairing: " + possibleNeighboursList);
            ArrayList <String> selectedNeighbours = new ArrayList <> ();
            for (int j = 0; j < possibleNeighboursList.size(); j++) {
                if (isFormData()) {
                    String endVertex;
                    do {
                        endVertex = possibleNeighboursList.get(myRandom.nextInt(0, possibleNeighboursList.size()));
                    } while (selectedNeighbours.contains(endVertex));
                    selectedNeighbours.add(endVertex);
                    if (isEligibleIntegerTriple(startVertex, endVertex)) {
                        IntegerTriple incomingIntegerTriple = new IntegerTriple(myRandom.nextInt(-100, 101), startVertex, endVertex);
                        System.out.println("  ** Inserting [" + incomingIntegerTriple.getsStartVertex() 
                                            + " --- " + incomingIntegerTriple.getsEndVertex() 
                                            + " | W: " + incomingIntegerTriple.getsWeight()
                                            + "]"
                        ); 
                        edgeList.add(incomingIntegerTriple);
                    }
                }
            }
            if (i != verticesList.size() - 1) {
                displaysNewLine();
            }
        }
        Collections.sort(edgeList);
        displaysLine();
    }

    private boolean isEligibleIntegerTriple(String startVertex, String endVertex) {
        for (int i = 0; i < edgeList.size(); i++) {
            IntegerTriple currentIntegerTriple = edgeList.get(i);
            if ((currentIntegerTriple.getsStartVertex().equals(startVertex) 
                    && currentIntegerTriple.getsEndVertex().equals(endVertex))
                || (currentIntegerTriple.getsStartVertex().equals(endVertex) 
                    && currentIntegerTriple.getsEndVertex().equals(startVertex))) {
                        return false;
            }
        }
        return true;
    }

    private boolean isFormData() {
        return myRandom.nextBoolean();
    }

    private void run() {
        insertion();
        displaysEdgeList();
    }

    public static void main(String[] args) {
        EdgeList obj = new EdgeList();
        obj.run();
    }
}
