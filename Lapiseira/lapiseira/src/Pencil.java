import java.util.ArrayList;

public class Pencil {
    private float thickness; // Isso é a grossura
    private Lead tip; //Esse é o bico
    private ArrayList<Lead> barrel; //tamanho do barril do grafite, não precisa do () aqui

    public Pencil(float thickness){
        this.thickness = thickness;
        this.tip = null;
        this.barrel = new ArrayList<Lead>(); //na inicialização precisa
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value){
        this.thickness = value;
    }

    public boolean hasLead() {
        if(this.tip != null){
           return true;
        } else{
            return false;
        }
        
    }

    public boolean insert(Lead grafite) {
        if(hasLead()){
            IO.println("fail: ja existe grafite"); 
            return false;
        } 
        
        if(this.thickness != grafite.getThickness()){
            IO.println("fail: calibre incompatível");
            return false;
        } 
        
         this.barrel.add(grafite); //o .add é um método dentro do ArrayList, que adiciona ao seu array a quanidade de grafite
         return true;

    }

    public Lead remove() {
        if(!hasLead()){
            IO.println("fail: nao existe grafite");
            return null;
        }   else {
            Lead backup = this.tip;
            this.tip = null;
            return backup;
        }
        
    }

    public boolean pull(){
        if(this.tip!=null){
            IO.println("fail: ja existe grafite no bico");
            return false;
        }
        if(this.barrel.size()==0){
            IO.println("fail: nao ha grafites no tambor");
            return false;
        }
        else{
            this.tip=this.barrel.remove(0);
            return true;
        }
    }

    public void writePage() {
        if(!hasLead()){
            IO.println("fail: nao existe grafite no bico");
            return;
        }
        
        if(this.tip.getSize() <= 10){ //10 mm, se não for tem que printar um erro
            IO.println("fail: tamanho insuficiente");
            return;
        }
        
        
        if(this.tip.getSize() - this.tip.usagePerSheet() < 10){
            IO.println("fail: folha incompleta");
            this.tip.setSize(10);
            return;
        }
        
        this.tip.setSize(this.tip.getSize() - this.tip.usagePerSheet());

     }
    
    public String toString() {
        String saida = "calibre: " + this.thickness + ", bico: ";
        saida +=(tip != null ? "[" + tip.toString()+ "]": "[]");
        saida += ", tambor: <";
        
        for(Lead lead : barrel){//Variável que recebe os elementos do Vetor : O Vetor que ela vai receber
            saida += "[" + lead.toString() + "]";
        }
        
        return saida + ">";
    }
}