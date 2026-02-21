import java.util.ArrayList;


class Theater {
    private ArrayList<Client> seats;
    
    public Theater(int capacity) {
        seats = new ArrayList<Client>();
        for(int i = 0; i < capacity; i++) {
            seats.add(null);
        }
    }
    
    private int search(String name) {
        for (int i=0; i<this.seats.size(); i++) {
            if (this.seats.get(i) != null) {
                if ( this.seats.get(i).getName().equals( name ) ) {
                    return i;
                }
            }
        }
        
        return -1;
    }
    
    public boolean verifyIndex(int index) {
        if ( index >= 0 && index < this.seats.size() ) {
            return true;
        } else {
            return false;
        }
    }
    
    public void reserve(String name, int telefone, int index) {
        if(!verifyIndex(index)) {
            IO.println("fail: cadeira nao existe");
            return;
        }
        if(seats.get(index) != null) {
            IO.println("fail: cadeira ja esta ocupada");
            return;
        }
        int indexName = search(name);
        if(indexName != -1) {
            IO.println("fail: cliente ja esta no cinema");
            return;
        }
        
        Client cli = new Client(name, telefone);
        this.seats.set(index, cli);
    }
    
    public void cancel(String name) {
        int index = search(name);
        if(index == -1) {
            IO.println("fail: cliente nao esta no cinema");
            return;
        }
        seats.set(index, null);
    }
    
    public ArrayList<Client> getSeats() {
        return this.seats;
    }


    public Client getClient(int index) {
        return this.seats.get(index);
    }


    public String toString() {
        // return this.seats.toString();
        String str = "[";
        // for ( Client cli : this.seats ) {
        for ( int i=0; i<this.seats.size(); i++ ) {
            Client cli = this.seats.get(i);
            
            if (i!=0) {
                str += " ";
            }
            
            if (cli == null) {
                str += "-";
            } else {
                str += cli;
            }
        }




        // for ( Client cli : this.seats ) {
        //     // cli = this.seats.get(i);
        //     if (cli == null) {
        //         str += "- ";
        //     } else {
        //         str += cli + " ";
        //     }
        // }




        str += "]";
        return str;
    }
}
