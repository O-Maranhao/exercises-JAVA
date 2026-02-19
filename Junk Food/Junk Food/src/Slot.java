import java.text.DecimalFormat;

public class Slot{
    private String name;
    private float price;
    private int quantity;

    public Slot(String name, float price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;   
    }

    //Métodos get
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }
    //Métodos set
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    ////toString
    public String toString(){
        String str="";
        str += "[ " + this.name + " : " + this.quantity + " U :"+ df.format(price) +" R$]";
        return str;
    }
    //Método só pra ter o dígito pica
    DecimalFormat df = new DecimalFormat("0.00");
}