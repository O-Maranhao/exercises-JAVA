import java.util.*;
import java.text.DecimalFormat;
public class Pig{
    private boolean broken;
    private ArrayList<Coin> coins;
    private ArrayList<Item> items;
    private int volumeMax;
    private int volume;
    private double value;
    
    //Construtor
    public Pig(int volumeMax){
        this.broken = false;
        this.volume = 0;
        this.volumeMax = volumeMax;
        this.coins = new ArrayList<Coin>();
        this.items = new ArrayList<Item>();
    }
    //Metodos
    public boolean addCoin(Coin coin){
        if(coin.getVolume()+this.volume>volumeMax){
           IO.println("fail: the pig is full");
           return false;
        }
        if(isBroken()){
           IO.println("fail: the pig is broken");
           return false;
        }
        this.coins.add(coin);
        this.volume+=coin.getVolume();
        this.value+=coin.getValue();
        return true;
    }
    
    public boolean addItem(Item item){
        if(item.getVolume()+this.volume>volumeMax){
           IO.println("fail: the pig is full");
           return false;
        }
        if(isBroken()){
           IO.println("fail: the pig is broken");
           return false;
        }
        this.items.add(item);
        this.volume+=item.getVolume();
        return true;
    }
    
    public boolean breakPig(){
        this.broken = true;
        return true;
    }
    
    public ArrayList<Coin> extractCoins() throws Exception{
        if(!isBroken()){
            throw new MsgException("fail: you must break the pig first\n[]");
        }
        //Melhor forma de fazer uma cópia é essa
        // ArrayList<Coin> extracted = new ArrayList<Coin>(coins);
        // coins.clear();
        ArrayList<Coin> extracted = new ArrayList<Coin>();
        for(int i=0; i<this.coins.size();i++){
            Coin coin = this.coins.remove(i);
            this.value-=coin.getValue();
            i--;
            extracted.add(coin);
        }
        this.value = 0;
        return extracted;
    }
    public ArrayList<Item> extractItems() throws Exception{
        if(!isBroken()){
            throw new MsgException("fail: you must break the pig first\n[]");
        }
        ArrayList<Item> extracted = new ArrayList<>();
        for(int i=0; i<this.items.size();i++){
            Item item = this.items.remove(i);
            i--;
            extracted.add(item);
        }
        return extracted;
    }
    
    public String toString(){
        
        DecimalFormat df = new DecimalFormat ("0.00");
        
        String ss="";
        ss+="state="+(!broken ? "intact" : "broken")+" : coins=[";
        if(!coins.isEmpty()){
            for(int i=0; i<coins.size();i++){
                Coin moe = this.coins.get(i);
                
                ss+= moe.toString();
                if(i<this.coins.size()-1){
                    ss+= ", ";
                }
            }
        }
        ss+="] : items=[";
        if(!items.isEmpty()){
            for(int i=0; i<items.size();i++){
                Item it = this.items.get(i);
                
                ss+= it.toString();
                if(i<this.items.size()-1){
                    ss+= ", ";
                }
            }
        }

        ss+="] : value="+df.format(this.value)+" : volume="+(!broken ? this.volume+"/"+this.volumeMax : "0/"+this.volumeMax);
        
        return ss;
    }
    
    // //Uns get
    public int getVolume(){
        return 0;
    }
    public double getValue(){
        return 0;    
    }
    public int getVolumeMax(){
        return 0;    
    }
    
    
    // //IsBroken separado pois está de castigo
    public boolean isBroken(){
        return broken;
    }
    
}