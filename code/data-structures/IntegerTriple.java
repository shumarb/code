public class IntegerTriple implements Comparable<IntegerTriple> {
    private int weight;
    private String endVertex;
    private String startVertex;

    public IntegerTriple(int weight, String startVertex, String endVertex) {
        this.endVertex = endVertex;
        this.startVertex = startVertex;
        this.weight = weight;
    }

    public int compareTo(IntegerTriple newIntegerTriple) {
        if (this.getsWeight() < newIntegerTriple.getsWeight()) {
            return -1;
        } else if (this.getsWeight() > newIntegerTriple.getsWeight()) {
            return 1;
        } else {
            if (this.getsStartVertex().compareTo(newIntegerTriple.getsStartVertex()) < 0) {
                return -1;
            } else if (this.getsStartVertex().compareTo(newIntegerTriple.getsStartVertex()) > 0) {
                return 1;
            } else {
                if (this.getsEndVertex().compareTo(newIntegerTriple.getsEndVertex()) < 0) {
                    return -1;
                } else if (this.getsEndVertex().compareTo(newIntegerTriple.getsEndVertex()) > 0) {
                    return 1;
                }
                return 0;
            }
        }
    }

    public int getsWeight() {
        return this.weight;
    }

    public String getsEndVertex() {
        return this.endVertex;
    }

    public String getsStartVertex() {
        return this.startVertex;
    }
}
