class ShipmentNode{
    Shipment shipment;
    ShipmentNode left, right;

    public ShipmentNode(Shipment shipment){
        this.shipment = shipment;
        this.left = this.right = null;
    }
}

public class ShipmentBST {
    private ShipmentNode root;

    public ShipmentNode getRoot(){return root;}

    public boolean insert(Shipment shipment){
        if (shipment.cost  < 0 || shipment.deliveryDate == null || shipment.deliveryDate.isEmpty()){
            System.out.println("Invalid Shipment Data..");
            return false;
        }
        root = insertRec(root, shipment);
        return true;
    }

    private ShipmentNode insertRec(ShipmentNode root, Shipment shipment){
        if (root == null) return new ShipmentNode(shipment);
        if (shipment.id < root.shipment.id)
            root.left = insertRec(root.left, shipment);
        else if (shipment.id > root.shipment.id)
            root.right = insertRec(root.right, shipment);
        return root;
    }

    public Shipment search(int id){
        ShipmentNode node = searchRec(root, id);
        return node != null ? node.shipment : null;
    }

    private ShipmentNode searchRec(ShipmentNode root, int id){
        if (root == null || root.shipment.id == id) return root;

        if (id < root.shipment.id)
            return searchRec(root.left, id);
        else
            return searchRec(root.right, id);
    }

    public  boolean update(int id, double newCost, String newDate){
        ShipmentNode node = searchRec(root,id);
        if (node == null) return false;

        if (newCost >= 0)
            node.shipment.cost = newCost;

        if (newDate != null && !newDate.isEmpty())
            node.shipment.deliveryDate = newDate;
        return true;
    }

    public void inorderPrint(){ inorderRec(root);}

    private void inorderRec(ShipmentNode root){
        if (root != null){
            inorderRec(root.left);
            root.shipment.print();
            inorderRec(root.right);
        }
    }
}
