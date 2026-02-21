class Operation {
    private int id;
    private String name;
    private Label label;
    private int value;

    public Operation( String name, Label label, int value ){
        this.name = name; 
        this.label = label;
        this.value = value;
    }
    @Override
    public String toString() {
        return "id:" + this.id + " " + this.label + ":" + this.name + " " + this.value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Operation)) return false;
        Operation other = (Operation) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public Label getLabel() {
        return this.label;
    }
    public int getValue() {
        return this.value;
    }
}
