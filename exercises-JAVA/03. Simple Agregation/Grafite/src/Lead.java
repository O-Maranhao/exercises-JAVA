import java.text.DecimalFormat;

public class Lead {
    private float thickness; //calibre
    private String hardness; //dureza
    private int size; //tamanho em mm
    
    //Construtor CONSTRÓI Construtor CONSTRÓI Construtor
    public Lead(float thickness, String hardness, int size){
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }
    
    //MÉTODO DE GET get GET get GET get GET
    public float getThickness() {
        return thickness;
    }

    public String getHardness() {
        return hardness;
    }

    public int getSize(){
        return size;
    }

    //MÉTODOS DE SET set SET set SET set SET set SET
    public void setSize(int size){
        this.size = size;
    }
    
    //MÉTODO DE USAGE PERRRRRRRRRRRRRRR SHEEEEEEEEEEEEEEEET
    public int usagePerSheet(){
        int tamGas = 0;
        switch(hardness){
            case "HB":
                tamGas = 1;
                break;
            case "2B":
                tamGas = 2;
                break;
            case "4B":
                tamGas = 4;
                break;
            case "6B":
                tamGas = 6;
                break;
        }
        return tamGas;
    }
    
    //TO STRING TO STRING TO STRING TO STRING TO STRING
    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + this.hardness + ":" + size;
    }
}
