public class Kid{
    private int age;
    private String name;
    
    //Métodos
    public Kid(String name, int age){
        this.name = name;
        this.age = age;   
    }
    //métodos get
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    //Métodos Set
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String toString(){
        return "Nome: "+this.name+", Idade: "+this.age;
    }
}