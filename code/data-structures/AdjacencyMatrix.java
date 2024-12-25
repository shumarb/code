class AdjacencyMatrix extends BasicOperations {
    private int[][] adjacencyMatrix;

    private boolean isFormData() {
        return myRandom.nextBoolean();
    }

    private void insertion() {
        displaysLine();
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(3, 7);
        System.out.println("Forming an adjacency matrix with " + numberOfElements + " elements.");
        System.out.println("All elements are initially zero. The following updates certain elements to be non-zero: ");
        displaysNewLine();
        adjacencyMatrix = new int[numberOfElements][numberOfElements];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (isFormData() && i != j) {
                    int edgeWeight = myRandom.nextInt(-100, 101);
                    System.out.println(" * Update: Indices [" + i + "][" + j + "] & [" + j + "]" + i + "] = " + edgeWeight);
                    adjacencyMatrix[i][j] = edgeWeight;
                    adjacencyMatrix[j][i] = edgeWeight;
                }
            }
        }
        displaysLine();
    }
    
    private void displaysLetter(int number) {
        String letter = "";
        switch(number) {
            case 0: letter = "A"; break;
            case 1: letter = "B"; break;
            case 2: letter = "C"; break;
            case 3: letter = "D"; break;
            case 4: letter = "E"; break;
            case 5: letter = "F"; break;
            case 6: letter = "G"; break;
            default: letter = "";
        }
        System.out.print(letter + "\t");
    }
    
    private void displaysMatrix() {
        System.out.println("Adjacency Matrix:");
        displaysNewLine();
        System.out.print("\t\t");
        for (int m = 0; m < adjacencyMatrix.length; m++) {
            System.out.print(" ");
            displaysLetter(m);
            System.out.print("\t");
        }
        displaysNewLine();
        System.out.print("\t\t");
        for (int m = 0; m < adjacencyMatrix.length; m++) {
            System.out.print("___\t\t");
        }
        displaysNewLine();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            displaysNewLine();
            displaysLetter(i);
            System.out.print(" | ");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print("\t" + adjacencyMatrix[i][j] + "\t");
            }
            displaysNewLine();
        }
        displaysLine();
    }
    
    private void run() {
        insertion();
        displaysMatrix();
    }

    public static void main(String[] args) {
        AdjacencyMatrix obj = new AdjacencyMatrix();
        obj.run();
    }
}
