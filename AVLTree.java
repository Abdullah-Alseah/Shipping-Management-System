class AVL {
    Product product;
    AVL left, right;
    int height;

    public AVL(Product product){
        this.product = product;
        this.height = 1;
    }
}

public class AVLTree {
    private AVL root;
    private  static  final int MAX_QUANTITY = 1000;

    public int height(AVL node){
        return node == null? 0 : node.height;
    }
    private int getBalance(AVL node){
        return node == null? 0 : height(node.left) - height(node.right);
    }

    private AVL rightRotate(AVL y){
        AVL x = y.left;
        AVL T  = x.right;

        x.right = y;
        y.left = T;

        y.height = Math.max(height(y.left), height(y.right) + 1);
        x.height = Math.max(height(x.left), height(x.right) + 1);

        return x;
    }

    private AVL leftRotate(AVL x) {
        AVL y = x.right;
        AVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }
    public void insert(Product product) {
        if (product.price < 0 || product.quantity < 0 || product.quantity > MAX_QUANTITY) {
            System.out.println("Invalid product data!");
            return;
        }
        root = insertRec(root, product);
    }

    private AVL insertRec(AVL node, Product product){
        if (node == null) return new AVL(product);

        if (product.id < node.product.id)
            node.left = insertRec(node.left, product);
        else if (product.id > node.product.id)
            node.right = insertRec(node.right, product);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // (AVL Rotations)
        if (balance >  1 && product.id < node.left.product.id ) return rightRotate(node);
        if (balance < -1 && product.id > node.right.product.id) return leftRotate(node);

        if (balance > 1 && product.id > node.left.product.id){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && product.id < node.right.product.id){
            node.right = rightRotate(node);
            return leftRotate(node);
        }
        return node;
    }
    public Product search(int id) {
        AVL node = searchRec(root, id);
        return node != null ? node.product : null;
    }

    private AVL searchRec(AVL node, int id) {
        if (node == null || node.product.id == id)
            return node;
        if (id < node.product.id)
            return searchRec(node.left, id);
        return searchRec(node.right, id);
    }

    public void inorderPrint() {
        inorderRec(root);
    }

    private void inorderRec(AVL node) {
        if (node != null) {
            inorderRec(node.left);
            node.product.print();
            inorderRec(node.right);
        }
    }

}
