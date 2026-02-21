public abstract class Veiculo{
    private String id;
    protected String type;
    protected int horaEntrada;
    
    public Veiculo(String id, String type){
        this.id = id;
        this.type = type;
    }
    
    public void setEntrada(int horaEntrada){
        this.horaEntrada = horaEntrada;
    }
    public int getEntrada(){
        return horaEntrada;
    }
    
    public String getType(){
      return this.type; 
    }
    
    public String getId(){
        return this.id;
    }
    
    public abstract float calcularValor(int horaSaida);

}