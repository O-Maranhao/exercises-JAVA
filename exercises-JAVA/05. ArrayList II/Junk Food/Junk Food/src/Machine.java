import java.util.ArrayList;
import java.text.DecimalFormat;

public class Machine{
    private ArrayList<Slot> slots;
    private float profit;
    private float cash;
    private int capacity;

    public Machine(int capacity){
        this.slots = new ArrayList<>(); //não precisa colocar o tipo de objeto
        for(int i=0; i<capacity; i++){
            this.slots.add(new Slot("empty", 0f, 0));
        }
    }

    //Método Get slot
    public Slot getSlot(int index){
        if(this.slots.get(index)!=null){
            return this.slots.get(index);//Retorna o objeto 
        }
        return null;
    }
    //Set Slot
    public void setSlot(int index, Slot slot){ //set(onde vai ser colocado, o que vai ser colocado, o elemento)
        this.slots.set(index, slot);
    }
    //Clear Slot
    public void clearSlot(int index){
        this.slots.remove(index);
    }
    //Inserir Dinheiro
    public void insertCash(float cash){
        this.cash = cash;
    }
    //Conseguir o dinheiro
    public float getCash(){
        return this.cash;
    }
    //Retirar o dinheiro
    public float withdrawCash(){
        float backup = this.cash;
        this.cash = 0;
        return backup;
    }

    //Troco
    public float change(int index){ 
        this.profit -= this.cash - this.slots.get(index).getPrice();
        return this.cash-this.slots.get(index).getPrice();
    }
    //Comprar
    public void buy(int index){
        Slot slotc = this.slots.get(index); //esse comando é pra gente acessar os métodos do slot, .get(index)
        if(this.slots.get(index)==null){
            IO.println("fail: indice nao existe");
            return;
            } else if(slotc.getPrice()>getCash()){ //funciona também se eu botar this.slots.get(index).getPrice
            IO.println("fail: saldo insuficiente");
            return;
            } else if(slotc.getQuantity()<=0){
            IO.println("fail: espiral sem produtos");
            return;
            } else{
            this.cash -= this.slots.get(index).getPrice(); // Dinheiro subtrai o preço do produto
            this.slots.get(index).setQuantity((this.slots.get(index).getQuantity())-1); // Decrementa quantidade
            change(index);
            return;
            }
    }
    
   
}