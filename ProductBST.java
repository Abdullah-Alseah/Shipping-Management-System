class ProductNode{
    Product product;
    ProductNode left, right;

    public  ProductNode(Product product){
            this.product = product;
            this.left = this.right  = null;
    }
}

public class ProductBST {
    private ProductNode root;

    public ProductNode getRoot(){ return root; }

    private static final int MAX_QUANTITY = 1000;

    public boolean insert(Product product){
        ProductNode node = searchRec(root, product.id);
        if (node != null){
            System.out.println("The Product '"+product.name+"' With ID '"+product.id+"' Cannot Be Added Because It Already Exists.");
            return false;
        }
        if (product.price < 0){
            System.out.println("The Price Of The Product With ID: '" + product.id + "' IS Invalid.");
            if ( product.quantity < 0 || product.quantity > MAX_QUANTITY){
                System.out.println("The Quantity Of The Product With ID: '"+ product.id + "' IS Invalid.");
            }
            return  false;
        }
        if ( product.quantity < 0 || product.quantity > MAX_QUANTITY){
            System.out.println("The Quantity Of The Product With ID: '" + product.id + "' IS Invalid.");
            return false;
        }
        root = insertRec(root, product);
        return true;
    }

    private ProductNode insertRec(ProductNode root, Product product){
        if (root == null) return new ProductNode(product);
        if (product.id < root.product.id)
            root.left = insertRec(root.left, product);
        else if (product.id > root.product.id)
            root.right = insertRec(root.right, product);
        return root;
    }

    public Product search(int id){
        ProductNode node = searchRec(root, id);
        return node == null ? null : node.product;
    }

    private ProductNode searchRec(ProductNode root, int id){
        if (root == null || root.product.id == id) return root;

        if (id < root.product.id) return searchRec(root.left , id);

        else return searchRec(root.right , id);
    }

    public  boolean updatePrice(int id, double newPrice){
        ProductNode node = searchRec(root, id);
        if (node == null) {
            System.out.println("Product With ID '"+id+"' Does Not Exist.");
            return false;
        }
        if (newPrice >= 0) node.product.price = newPrice;
        return true;
    }

    public  boolean updateQuantity(int id, int newQuantity){
        ProductNode node = searchRec(root, id);
        if (node == null) {
            System.out.println("Product With ID '"+id+"' Does Not Exist.");
            return  false;
        }
        if (newQuantity >= 0 && newQuantity <= MAX_QUANTITY)
            node.product.quantity = newQuantity;
        return true;
    }

    public void delete(int id){
        root = deleteRec(root, id);
    }

    private ProductNode deleteRec(ProductNode root, int id){
        if (root == null) return null;
        if (id < root.product.id)
            root.left = deleteRec(root.left, id);
        else if (id > root.product.id)
            root.right = deleteRec(root.right, id);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.product = minValue(root.right);
            root.right = deleteRec(root.right, id);
        }
        return root;
    }

    private Product minValue(ProductNode node){
        Product min = node.product;
        while (node.left != null){
            node = node.left;
            min = node.product;
        }
        return min;
    }

    public void inorderPrint() { inorderRec(root);}

    private void inorderRec(ProductNode root){
        if (root != null){
            inorderRec(root.left);
            root.product.print();
            inorderRec(root.right);
        }
    }
}
