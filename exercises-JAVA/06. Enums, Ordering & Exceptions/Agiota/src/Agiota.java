import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Comparador implements Comparator<Client> {
    public int compare(Client c1, Client c2) {
        return c1.getName().compareTo(c2.getName());
    }
}

class Agiota {
    private ArrayList<Client> aliveList; //lista de clientes vivos
    private ArrayList<Client> deathList; // lista de clientes não vivos
    private ArrayList<Operation> aliveOper;
    private ArrayList<Operation> deathOper;
    int nextOperId = 0;

    private int searchClient(String name){ // Método de Pesquisa 
        for(int i=0; i< this.aliveList.size();i++){
            Client cli = this.aliveList.get(i);
            if(cli.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    private void pushOperation(Client client, String name, Label label, int value) {
        Operation oper = new Operation(name, label, value);
        oper.setId(nextOperId++);
        this.aliveOper.add(oper);
        client.addOperation(oper);
    }


    private void sortAliveList(){
        this.aliveList.sort(new Comparator<Client>(){
        @Override
        public int compare(Client c1, Client c2) {
            // Exemplo: ordena por nome
            return c1.getName().compareTo(c2.getName());
        }
        });

        Collections.sort (this.aliveList); //para inteiros

        this.aliveList.sort(new Comparator<Client>() {
        @Override
        public int compare(Client c1, Client c2) {
            int cmp = Integer.compare(c1.getLimite(), c2.getLimite());
            if (cmp != 0) {
                return cmp;
            }
                return c1.getName().compareTo(c2.getName());
            }
        });


        Collections.sort (this.aliveList, new Comparator<Client>() {
            public int compare(Client c1, Client c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });

        Collections.sort (this.aliveList, new Comparador());
    }

    public Agiota(){
        this.aliveList = new ArrayList<Client>();
        this.deathList = new ArrayList<Client>();
        this.aliveOper = new ArrayList<Operation>();
        this.deathOper = new ArrayList<Operation>();
    }

    public Client getClient(String name){
        int clidId = searchClient(name);
        
        if(clidId == -1){
            return null;
        }
        
        return aliveList.get(clidId);
    }

    public void addClient(String name, int limite) throws ClienteException{
        if(searchClient(name) != -1){ // Se encontrar cliente com esse nome
            throw new ClienteException("fail: cliente ja existe");
        }
        Client client = new Client(name, limite);
        this.aliveList.add(client);
    }

    public void give(String name, int value) throws Exception{
        Client cli = this.getClient(name);
        
        if(cli == null){
            throw new ClienteException("fail: cliente nao existe");
        }
        if(cli.getBalance() + value > cli.getLimite()){
            throw new ClienteException("fail: limite excedido");
        }
        
        this.pushOperation(cli, name, Label.GIVE, value);
    }

    public void take(String name, int value) throws Exception{
        Client cli = this.getClient(name);
        
        if(cli == null){
            throw new ClienteException("fail: cliente nao existe");
        }
        
        this.pushOperation(cli, name, Label.TAKE, value);
    }
        

    public void kill(String name) throws Exception {
    int cliId = this.searchClient(name);
    if (cliId == -1) {
        throw new ClienteException("fail: cliente nao existe");
    }
    Client cli = this.aliveList.remove(cliId);
    // Iterator nesse troço aqui serve pra remover elementos da lista sem quebrar o loop
    Iterator<Operation> it = this.aliveOper.iterator();
    while (it.hasNext()) {
        Operation oper = it.next();
        if (oper.getName().equals(cli.getName())) {
            this.deathOper.add(oper);
            it.remove(); // remove com segurança da aliveOper
        }
    }
    this.deathList.add(cli);
}


    public void plus() throws Exception{
         for (int i = 0; i<this.aliveList.size(); i++) {
             Client client = this.aliveList.get(i);
             int aumento = (int) Math.ceil(client.getBalance() * 0.10);
             this.pushOperation( client, client.getName(), Label.PLUS, aumento);
         }
        for (int i=0; i<this.aliveList.size(); i++) {
            Client client = this.aliveList.get(i);
            if ( client.getBalance() > client.getLimite() ) {
                this.kill( client.getName() );
                i--;
           }
        }
    }

  @Override

    public String toString() {
        String ss = "";
        
        this.sortAliveList();
        // aliveList
        for (int i = 0; i < this.aliveList.size(); i++) {
            Client client = this.aliveList.get(i);
            ss += ":) " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
            
        }
    
        // aliveOper
        for (int i = 0; i < this.aliveOper.size(); i++) {
            Operation oper = this.aliveOper.get(i);
            ss += "+ " + oper + "\n";
        }
    
        // deathList
        for (int i = 0; i < this.deathList.size(); i++) {
            Client client = this.deathList.get(i);
            ss += ":( " + client.getName() + " " + client.getBalance() + "/" + client.getLimite() + "\n";
        }
    
        // deathOper
        for (int i = 0; i < this.deathOper.size(); i++) {
            Operation oper = this.deathOper.get(i);
            ss += "- " + oper + "\n";
        }
        return ss;
}

}