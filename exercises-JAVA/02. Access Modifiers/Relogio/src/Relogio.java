class Time{
    private int hour;
    private int minute;
    private int second;
    
    //Construtor
    Time(int hour, int minute, int second){
        //HORA HORA HORA
        if(hour>=0 && hour<=23){
            this.hour = hour;
        }else{
            IO.println("fail: hora invalida");
        }
        //MINUTO MINUTO
        if(minute>=0 && minute <=59){
            this.minute = minute;
        }else{
            IO.println("fail: minuto invalido");
        }
        //SEGUNDO SEGUNDO
        if(second>= 0 && second<=59){
            this.second = second;
        }else{
            IO.println("fail: segundo invalido");
        }
    }
     
    //To String
    @Override // Vê se o toString tá correto
    public String toString(){
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }
    
    //Funções de SET SET SET SET SET SET
    public void setHour(int Hournumber){
        if(Hournumber>=0 && Hournumber<=23){
            this.hour = Hournumber;
        }else{
            IO.println("fail: hora invalida");
        }
    }
    
    public void setMinute(int Minutenumber){
        if(Minutenumber>=0 && Minutenumber <=59){
            this.minute = Minutenumber;
        } else{
            IO.println("fail: minuto invalido");
        }
    }
    public void setSecond(int Secondnumber){
        if(Secondnumber>= 0 && Secondnumber<=59){
            this.second = Secondnumber;
        } else{
            IO.println("fail: segundo invalido");
        }
    }
    
    //NEXT SEGUNDO PAPAI
    public void nextSecond(){
        this.second+=1;
        if(this.second >= 60){
            this.second = 0;
            this.minute+=1;
        }
        if(this.minute >= 60){
            this.minute = 0;
            this.hour+=1;
        }
        if(this.hour >= 24){
            this.hour = 0;
        }
    }
    
    
    //Funções de GET GET GET GET GET GET 
    public int getHour(){
        return this.hour;
    }
    public int getMinute(){
        return this.minute;
    }
    public int getSecond(){
        return this.second;
    }
    
}