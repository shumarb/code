public class IntegerPair implements Comparable<IntegerPair> {
    private int weight;
    private String endVertex;

    public IntegerPair(String endVertex, int weight) {
        this.weight = weight;
        this.endVertex = endVertex;
    }

    public int compareTo(IntegerPair incomingIntegerPair) {
        if (this.getsEndVertex().compareTo(incomingIntegerPair.getsEndVertex()) < 0) {
            return -1;
        } else if (this.getsEndVertex().compareTo(incomingIntegerPair.getsEndVertex()) > 0) {
            return 1;
        } else {
            if (this.getsWeight() - incomingIntegerPair.getsWeight() < 0) {
                return -1;
            } else if (this.getsWeight() - incomingIntegerPair.getsWeight() > 0) {
                return 1;
            }
            return 0;
        }
    }

    public int getsWeight() {
        return this.weight;
    }

    public String getsEndVertex() {
        return this.endVertex;
    }

    public void setsWeight(int weight) {
        this.weight = weight;
    }
}
