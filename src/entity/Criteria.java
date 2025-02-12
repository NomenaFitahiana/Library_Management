package entity;

public class Criteria {
   private String column;
   private Object value;

   public Criteria(String column, Object value){
    this.column = column;
    this.value = value;
   }

   public String getColumn(){
    return this.column;
   }

   public Object getValue(){
    return this.value;
   }

   @Override
    public String toString() {
        return "Criteria { column = " + column +
                        ", value = " + value +
                      "}";
    }


}
