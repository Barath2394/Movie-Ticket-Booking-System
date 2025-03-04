public class Node {
    Showtime showtime;
    Node left, right;

    public Node(Showtime showtime) {
        this.showtime = showtime;
        left = right = null;
    }
}

