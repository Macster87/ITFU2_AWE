public class Container {

    private Container predecessor;
    private Container successor;

    private String content;

    public Container (String content, Container predecessor, Container successor) {
        this.content = content;
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public Container(String content) {
        this.content = content;
    }

    public Container getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Container predecessor) {
        this.predecessor = predecessor;
    }

    public Container getSuccessor() {
        return successor;
    }

    public void setSuccessor(Container successor) {
        this.successor = successor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        if(content.equals("") || content == null) {
            return "===[ ]";
        }
        return "-[ "+content+" ]";
    }
}
