public class MovieShowtimesBST {
    private Node root;

    public MovieShowtimesBST() {
        root = null;
    }

    // Add a new showtime to the BST
    public void addShowtime(Showtime showtime) {
        root = addRecursive(root, showtime);
    }

    private Node addRecursive(Node node, Showtime showtime) {
        if (node == null) {
            return new Node(showtime);
        }
        if (showtime.compareTo(node.showtime) < 0) {
            node.left = addRecursive(node.left, showtime);
        } else if (showtime.compareTo(node.showtime) > 0) {
            node.right = addRecursive(node.right, showtime);
        }
        return node;
    }

    // Search for a showtime by time
    public void searchShowtime(String time) {
        Node result = searchRecursive(root, time);
        if (result != null) {
            System.out.println("Showtime found: " + result.showtime);
        } else {
            System.out.println("Showtime not found.");
        }
    }

    private Node searchRecursive(Node node, String time) {
        if (node == null || node.showtime.getTime().equals(time)) {
            return node;
        }
        if (time.compareTo(node.showtime.getTime()) < 0) {
            return searchRecursive(node.left, time);
        }
        return searchRecursive(node.right, time);
    }

    // Delete a showtime from the BST
    public void deleteShowtime(String time) {
        root = deleteRecursive(root, time);
    }

    private Node deleteRecursive(Node node, String time) {
        if (node == null) {
            return null;
        }
        if (time.compareTo(node.showtime.getTime()) < 0) {
            node.left = deleteRecursive(node.left, time);
        } else if (time.compareTo(node.showtime.getTime()) > 0) {
            node.right = deleteRecursive(node.right, time);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            node.showtime = findMin(node.right).showtime;
            node.right = deleteRecursive(node.right, node.showtime.getTime());
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Display all showtimes in sorted order
    public void displayShowtimes() {
        if (root == null) {
            System.out.println("No showtimes available.");
        } else {
            System.out.println("All Showtimes:");
            inorderTraversal(root);
        }
    }

    private void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.println(node.showtime);
            inorderTraversal(node.right);
        }
    }
}

