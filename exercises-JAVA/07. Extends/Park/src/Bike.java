public class Bike extends Veiculo{

    public Bike(String id){
        super(id, "Bike");
    }
    
    @Override
    public float calcularValor(int horaSaida){
        return (float)3;
    }
    
}