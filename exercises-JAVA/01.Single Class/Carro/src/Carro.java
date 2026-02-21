public class Carro{
    
    public int passageiros = 0;
    public int passageirosMax;
    public int gasolina = 0;
    public int gasolinaMax;
    public int km;
    
    public Carro(){
        this.passageirosMax = 2;
        this.gasolinaMax = 100;
        
    }
    
    public void enter(){
        if(passageiros >= passageirosMax){
            IO.println("fail: limite de pessoas atingido");
            return;
        }
        passageiros+=1;
    }
    
    public void leave(){
        if(passageiros<=0){
            IO.println("fail: nao ha ninguem no carro");
            return;
        }
        passageiros-=1;
    }
    
    public void drive(int distancia){
        if(passageiros <= 0){
            IO.println("fail: nao ha ninguem no carro");
            return;
        }
        if (gasolina <=0){
            IO.println("fail: tanque vazio");
            return;
        }
        if(gasolina<distancia){
            IO.println("fail: tanque vazio apos andar " + gasolina + " km");
            km += gasolina;
            gasolina = 0;
            return;
        }
        km += distancia;
        gasolina -= distancia;
    }
    
    public void fuel(int value){
        if(gasolina + value > gasolinaMax){
            gasolina = gasolinaMax;
            return;
        }
        
        gasolina += value;
    }
    
    public String toString(){
        return ("pass: " + passageiros + ", gas: " + gasolina + ", km: " + km);
    }
    
}