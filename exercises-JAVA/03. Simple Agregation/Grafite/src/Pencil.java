public class Pencil {
    private float thickness;
    private Lead tip;
    
    //CONTRUTOR
    public Pencil(float thickness){
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness(){
        return thickness;
    }

    public void setThickness(float value){
        this.thickness = value;
    }
    
    public boolean hasLead(){
        return tip != null;
    }

    public boolean insert(Lead grafite){
        if(hasLead()){
            IO.println("fail: ja existe grafite");
            return false;
        }
        if(grafite.getThickness() != this.thickness){
            IO.println("fail: calibre incompativel");
            return false;
        }
        this.tip = grafite;
        return true;
    }

    public Lead remove(){
        if(!hasLead()){
            IO.println("fail: nao existe grafite");
            return null;
        }
        
        Lead removed = this.tip;
        this.tip = null;
        return removed;
        
    }
    
    //WRITE THE PAGE I WRITE THE PAGE I WRITE
    public void writePage(){
        if(!hasLead()){
            IO.println("fail: nao existe grafite");
            return;
        }
        int size = tip.getSize();
        int gasto = tip.usagePerSheet();
        
        if(size <= 10){
            IO.println("fail: tamanho insuficiente");
            return;
        }
        int tamanhoFinal = size - gasto;
        
        if(tamanhoFinal<10){
            tip.setSize(10);
            IO.println("fail: folha incompleta");
        } else{
            tip.setSize(tamanhoFinal);
        }
        
    }
    
    //TO STRING
    public String toString() {
        String saida = "calibre: " + this.thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}
