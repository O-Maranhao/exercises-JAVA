class Pet{
    private int energiaMax;
    private int limpezaMax;
    
    private int energia;
    private int limpeza;
    
    private int idade;
    private boolean vida;
    
    //Construtor/Inicializador
    Pet(int energiaMax, int limpezaMax){
        this.energiaMax = energiaMax;
        this.limpezaMax = limpezaMax;
        
        this.energia = energiaMax;
        this.limpeza = limpezaMax;
        this.idade = 0;
        this.vida = true;
        
    }
    //To String
    public String toString(){
        return "E:" + this.energia + "/" + this.energiaMax + ", L:" + this.limpeza + "/" + this.limpezaMax +", I:" + this.idade ;
    }
    //Verificar se tá vivo
    public boolean verificar(){
        if(limpeza <= 0){
            IO.println("fail: pet morreu de sujeira");
            return false;
        } 
        if(energia <= 0){
            IO.println("fail: morreu de fraqueza");
            return false;
        }
        return true;
    }
    //Teste Alive
    private boolean testAlive(){
        if(vida){
            return true;
        } else{
            IO.println("fail: pet esta morto");
            return false;
        }
    }
    
    //Comandos
    public void play(){
        if(testAlive()){
            this.setEnergy(-2);
            this.setClean(-3);
            this.setAge(1);
            if(limpeza<=0){
                IO.println("fail: pet morreu de sujeira");
                this.limpeza = 0;
                this.vida = false;
            }
            if(energia<=0){
                IO.println("fail: pet morreu de fraqueza");
                this.energia = 0;
                this.vida = false;
            }
        }
        
    }
    public void shower(){
        if(testAlive()){
            this.setEnergy(-3);
            this.setClean(1);
            this.setAge(2);
            if(energia<=0){
                IO.println("fail: pet morreu de fraqueza");
                this.vida = false;
            }
        }
    }
    public void sleep(){
        if(testAlive()){
            this.dormir();
        }
    }
    
    //Métodos de Setar Energia, Limpeza e Idade
    public void setEnergy(int setE){
        this.energia = this.energia+setE;
        if(this.energia>this.energiaMax){
            this.energia = this.energiaMax;
        }
    }
    //LIMPEZA
    public void setClean(int setC){
        if(setC>=0){
            this.limpeza = this.limpezaMax;
            if(this.limpeza>this.limpezaMax){
                this.limpeza = this.limpezaMax;
            }
        } else{
            this.limpeza +=setC;
        }
    }
    //IDADE
    public void setAge(int setA){
        this.idade += setA;
    }
    //DORMIR
    public void dormir(){
        if(this.energia<=this.energiaMax - 5){
            this.idade += (this.energiaMax - this.energia);
            this.energia = this.energiaMax;
        }else{
                IO.println("fail: nao esta com sono");
            }
    }
    //Return ou Get
    public int getClean(){
        return this.limpeza;
    }
    public int getCleanMax(){
        return this.limpezaMax;
    }
    public int getEnergy(){
        return this.energia;
    }
    public int getEnergyMax(){
        return this.energiaMax;
    }
    public int getAge(){
        return this.idade;
    }
    
}