class Animal{

    String species;
    String sound;
    int age;
    
    //Construtor
    // Animal(){
    // }

    Animal(String species, String sound){
        this.species = species; //This é o atributo lá de cima, a característica do animal que deve ser atualizada, recebe a característica definida pelo parâmetro
        this.sound = sound;
        this.age = 0;
    }
    // aqui vai o inicializador
    public void inicializar(String species, String sound){ // colocando os paraM~etros que o inicializar pede
            this.species = species; //This é o atributo lá de cima, a característica do animal que deve ser atualizada, recebe a característica definida pelo parâmetro
            this.sound = sound;
            this.age = 0;
        }

        
    public String toString(){ // Pega o código e transformar num texto
        String str = ""; //criando um objeto string bem vazio
        str = str + "Esp = " + this.species; //This representa o objeto que chamou o método
        str = str + "Som = " + this.sound;
        str = str + "Ida = " + this.age;
        return str;
    }
    void envelhecer(int numEstagios){
        if(this.age < 4){
            this.age += numEstagios;
        }
        if(this.age>=4){
            IO.println("warning: " + this.species + " morreu");
        }
    }
    public String fazerBarulho(){
        if(this.age == 0){
            return "---";
        }else if(this.age>=4){
            return "RIP";
        }else{
            return this.sound;
        }
    }
    public String show(){
             return this.species + ":" + this.age + ":"+ this.sound;
    }
}

