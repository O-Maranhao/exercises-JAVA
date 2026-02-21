public class Car extends Veiculo{
    
     public Car(String id){
        super(id, "Carro");
    }
    
    @Override
    public float calcularValor(int horaSaida){
        Float valor;
        valor = horaSaida/(float)10.00;
        if(valor<5){
            valor = (float)5;
        }
        return (float)valor;
    }
}