public class Moto extends Veiculo{
    
    public Moto(String id){
        super(id, "Moto");
    }
    
    public float calcularValor(int horaSaida){
        float valor;
        valor = horaSaida/20;
        return (float)valor;
    }
}