package entity;

public class Order {
    private String  column;
    private String order;

    public Order(String column, String order){
        this.column = column;
        this.order = order;
    }

    public String getColumn(){
        return this.column;
       }
    
    public String getOrder(){
        return this.order;
       }

    @Override
       public String toString() {
           return "Order { column = " + column +
                           ", order = " + order +
                         "}";
       }
}
