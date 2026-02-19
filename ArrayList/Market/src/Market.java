import java.util.ArrayList;

class Market{
    private ArrayList<Person> counters; //Estamos aqui criando um ArrayList, é tipo um Vetor que vimos em FUP, a diferença
    private ArrayList<Person> queue;
    
    public Market(int counterCount){
        this.queue = new ArrayList<Person>();
        this.counters = new ArrayList<Person>(counterCount); // deve ser inicializador com o Array
        for(int i=0; i<counterCount; i++){
        this.counters.add(null);
        }   
    }
    
    private boolean validateIndex(int index) {
        if ( index >= 0 && index < this.counters.size() ) {
            return true;
        } else {
            return false;
        }
    }
    
    public void arrive(Person person){
        this.queue.add(person);
    }
    
    public boolean call(int index){
        if(this.queue.isEmpty()){
            IO.println("fail: sem clientes");
            return false;
        }
        if(this.counters.get(index)!=null){
            IO.println("fail: caixa ocupado");
            return false;
        }
        this.counters.set(index, queue.remove(0));
        return true;
    }

    public Person finish(int index){
        if(!validateIndex(index)){
            IO.println("fail: caixa inexistente");
            return null;
        } else if(this.counters.get(index) == null){
            IO.println("fail: caixa vazio");
        }
        Person person = this.counters.get(index);
        this.counters.set(index,null);
        return null;
    }

    @Override
    public String toString() {
        String str = "";
        
        str += "Caixas: [";
        // for (Person person : this.counters) {
        for (int i=0; i<this.counters.size(); i++) {
            Person person = this.counters.get(i);

            str += (person != null ? person : "-----");

            if (i < this.counters.size() - 1) str += ", ";
        }
        str += "]\n";

        str += "Espera: " + this.queue;

        return str;
    }
}
