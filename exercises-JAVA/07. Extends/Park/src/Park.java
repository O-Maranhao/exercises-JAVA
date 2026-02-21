import java.text.DecimalFormat;
import java.util.ArrayList;

public class Park{
    private ArrayList<Veiculo> veiculos;
    private int horaAtual; //usamos int e isso ai significa minutos
    
    public Park(){
        this.veiculos = new ArrayList<Veiculo>();
        this.horaAtual = 0;
    }
    
    private int procurarVeiculo(String id){
        // this.veiculos.get(id);
        // if(this.veiculos.get(id)!=null){
        //     return 1;
        // } else{
        //     return 0;
        // }
        for(int i=0; i<veiculos.size();i++){
            Veiculo fusca = veiculos.get(i);
            if(fusca.getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public void estacionar(String type, String id){
        switch(type){
            case "bike":
                Bike bik = new Bike(id);
                bik.setEntrada(horaAtual);
                this.veiculos.add(bik);
                break;
            case "moto":
                Moto mot = new Moto(id);
                mot.setEntrada(horaAtual);
                this.veiculos.add(mot);
                break;
            default:
                Car car = new Car(id);
                car.setEntrada(horaAtual);
                this.veiculos.add(car);
                break;
        }
    }
    
    public void pagar(String id){
        if(this.procurarVeiculo(id)!=(-1)){
            Veiculo palio = veiculos.get(procurarVeiculo(id));
            DecimalFormat df = new DecimalFormat("0.00");
            IO.println(palio.getType()+" chegou "+palio.getEntrada()+" saiu "+horaAtual+". Pagar R$ "+
            df.format(palio.calcularValor(horaAtual-palio.getEntrada()))); //GRANDE né, isso aqui diz o seguinte: o palio vai calcular o falor, que é o horário que ele ficou lá, ou seja, o horário de saida menos o de chegada, tudo respeitando o formato do df 
        }
    }


    public void passarTempo(int tempo){
        this.horaAtual+=tempo;
    }
    public String toString(){
        String ss="";
        if(!veiculos.isEmpty()){
            for(int i=0;i<veiculos.size();i++){
                Veiculo vei = this.veiculos.get(i);
                ss+= String.format(
                    "%10s-:-%10s-:-%s", //alinhar a direita 10 caracteres inserindo espaços
                    vei.getType(),
                    vei.getId(),
                    vei.getEntrada()
                )
                    .replace(' ', '_') //substituir espaço por underline
                    .replace('-', ' '); //substituir hífen por espaço
                ss+="\n";
            }
        }
        ss+="Hora atual: "+this.horaAtual;
        return ss;
        
    }
    
    
    
    
    
}