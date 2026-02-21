import java.util.ArrayList;

public class Client implements Comparable<Client>{
    String name;
    int limite;
    int balance = 0;
    ArrayList<Operation> operations;
    
    public Client(String name, int limite){
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<Operation>();
        this.balance = 0;
    }
    public String toString(){
        String ss = "";
        ss += name +" "+ this.getBalance() + "/" + limite + "\n";
        for(int i = 0; i< this.operations.size(); i++){
            ss+= "id:" + this.operations.get(i).getId() + " " + this.operations.get(i).getLabel()+":"+ name + " " + this.operations.get(i).getValue() + "\n";
        }
        return ss;
    }
    public String getName(){
        return name;
    }
    public int getLimite(){
        return limite;
    }
    public ArrayList<Operation> getOperations(){
        return operations;
    }
    
    public void addOperation(Operation oper){
        balance = this.getBalance();
        operations.add(oper);
    }
    
    public int compareTo(Client other) {
        return this.name.compareTo(other.name);
    }
    public int getBalance(){ //percorre o vetor de operações
        int saldo = 0;
        for(int i = 0; i<operations.size();i++){
            if(operations.get(i).getLabel()== Label.GIVE){
                saldo+=operations.get(i).getValue();
            } else if(operations.get(i).getLabel()== Label.TAKE){
                saldo-=operations.get(i).getValue();
            } else if(operations.get(i).getLabel()== Label.PLUS){
                saldo+=operations.get(i).getValue();
            }
        }
        return saldo;
    }
}
