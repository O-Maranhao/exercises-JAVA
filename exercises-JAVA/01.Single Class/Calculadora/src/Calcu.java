import java.text.DecimalFormat;
class Calcu{
    
   float display;
   int battery;
   int batteryMax;
   
   //Agora o construtor
   Calcu(int batteryMax){
       this.batteryMax = batteryMax;
       this.battery = 0;
       this.display = 0;
   }
   
   void inicializar(int batteryMax){
       this.display = 0;
       this.batteryMax = batteryMax;
       this.battery = 0;
   }
   
   public String toString(){
       //Vamos retornar em duas casas decimais, vamos usar a classe Decimal Format
       DecimalFormat df = new DecimalFormat ("0.00");
       return String.format("display = %s, battery = %s", df.format(this.display), this.battery);
   }
   void recarregar(int carga){
       if(this.battery + carga> this.batteryMax){
            this.battery = this.batteryMax;
        }
        else{
            this.battery+=carga;
        }
   }
   void somar(float a, float b){
        if(this.battery==0){
            IO.printf("fail: bateria insuficiente\n");
        }
        else{
            this.display = a+b;
            this.battery -=1;
        }
   }
   void dividir(float a, float b){
        if(this.battery==0){
            IO.printf("fail: bateria insuficiente\n");
        }
        else if(b==0){
            IO.printf("fail: divisao por zero\n");
            this.battery -=1;
        }
        else{
            this.display = a/b;
            this.battery -=1;
        }
   }
   
}