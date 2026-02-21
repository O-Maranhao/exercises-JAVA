class Person{
    int age;
    String name;
    
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    //Funções
    public int getAge(){
        return this.age;
    }
    public String getName(){
        return this.name;
    }
    
    @Override
    public String toString(){
        return this.name + ":" + this.age; 
    }
}