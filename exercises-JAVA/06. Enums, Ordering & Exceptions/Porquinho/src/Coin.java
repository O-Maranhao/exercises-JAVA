import java.text.DecimalFormat;

public class Coin{
    private double value;
    private int volume;
    private String label;
    
    //Vamo ver as possibilidades de moeda, como é estático e queremos permitir apenas esses tipos de moeda
    //dizemos que é estático pois para acessar não se precisa criar um objeto, são métodos
    //Usar isso no trabalho de POO
    public static Coin C10 = new Coin(0.10, 1, "C10");
    public static Coin C25 = new Coin(0.25, 2, "C25");
    public static Coin C50 = new Coin(0.50, 3, "C50");
    public static Coin C100 = new Coin(1.00, 4, "C100");
    
    private Coin(double value,int volume,String label){ //construtor privado, pois só os negócio de cima que realmente cria as moedas
        this.value = value;
        this.volume = volume;
        this.label = label;
    }
    
    //Métodos
    public double getValue(){
        return value;
    }
    public int getVolume(){
        return volume;
    }
    public String getLabel(){
        return label;
    }
    
    public String toString(){
        String ss="";
        ss += df.format(getValue());
        ss += ":" ;
        ss += getVolume();
        return ss;
    }
    
    DecimalFormat df = new DecimalFormat("0.00");
}