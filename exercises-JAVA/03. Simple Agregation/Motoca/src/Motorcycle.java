class Motorcycle{
    private Person person;
    private int power;
    private int time;
    
    public Motorcycle(int power){
        this.power = power;
        this.time = 0;
    }
    
    public Motorcycle(){
        this.power = 1;
        this.time = 0;
        this.person = null;
    }
    
    //Método pra Inserir pessoas na moto
    public boolean insert(Person person){
        if(this.person != null){ //primeiro verdadeiro
            IO.println("fail: busy motorcycle");
            return false;
        } else{
            this.person = person;
            return true;
        }
    }
    //Método pra botar o Power
    public void init(int power){
        this.power = power;
        this.time = 0;
        this.person = null;
    }
    
    //Método de Remover
    public Person remover(){
        if(this.person != null){
            Person marcelo; //O marcelinho foi criado pra poder retornar o valor da pessoa que foi removida, pois ela vai se tornar nula antes do comando de retornar quem ela é
            marcelo = this.person;
            this.person = null;
            return marcelo; //vai lá marcelinho
            
        } else{
            IO.println("fail: empty motorcycle");
            return null;
        }
    }
    //Método pra comprar (????) tempo (vai que a moto é alugada né
    public void buyTime(int buy){
        this.time+=buy;
    }
    //Método pra Dirigiig
    public void drive(int driveTime){
        if(this.time<=0){
            IO.println("fail: buy time first");
            return;
        }
        if(person == null){
            IO.println("fail: empty motorcycle");
            return;
        }
        if(this.person.age>10){
            IO.println("fail: too old to drive");
            return;
        }if(this.time<driveTime){
            IO.println("fail: time finished after " + this.time + " minutes");
            this.time = 0;
            return;
        } else{
            this.time -= driveTime;
            return;
        }
    }
    //Fon fon
    public String honk(){
        String e = "e".repeat(this.power);
        String sound = "P" + e + "m";
        IO.println(sound);
        return sound;
    }
    //toString
    @Override
    public String toString(){
        if(this.person == null){
            return "power:" + this.power + ", time:" + this.time+", person:(empty)";
        } else{
            return "power:" + this.power + ", time:" + this.time+", person:("+this.person.name+":"+this.person.age+")";

        }
    }
}