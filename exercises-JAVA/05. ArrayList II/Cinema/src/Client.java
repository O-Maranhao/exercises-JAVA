class Client {
    private String name;
    private int telefone;
    
    public Client(String name, int telefone) {
        this.name = name;
        this.telefone = telefone;
    }
    
    public String getName() {
        return name;
    }
    
    public int getTelefone() {
        return telefone;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
    return name + ":" + telefone;
    }
}