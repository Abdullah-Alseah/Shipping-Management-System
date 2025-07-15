public class Shipment {
    int id;
    String destination;
    double cost;
    String deliveryDate; // YYYY - MM - DD

    public Shipment(int id, String destination, double cost, String deliveryDate){
        this.id = id;
        this.destination = destination;
        this.cost = cost;
        this.deliveryDate = deliveryDate;
    }

    public void print(){
        System.out.println("ID: "+ id +", Destination: "+ destination +", Cost: "+ cost +", Date: "+ deliveryDate);
    }
}
