//import java.text.DecimalFormat;

abstract class Shape{ //podemos colocar abstract aqui na frente, pois Shape nunca vai ser instanciada diretamente
    protected String name;
    
    //Uma interface é uma lista de métodos que é abstrata, como assinar um contrato que vai ser obrigado a botar corpo, codificar todos os métodos
    //construtor sem nada
    // public Shape(){
    //     this.nome = "";
    // }
    public Shape(String name) { //Toda forma geométrica possui um nome, seja círculo ou retângulo
        this.name = name;
    } //esse construtor aqui é inútil

    public String getName() {
        return this.name;
    }
    
    //isso aqui tudo é só a declaração de métodos
    public boolean inside( Point2D p ) {
        return false;
    }
    
    public double getArea(){
        return 0.0;
    } //estamos só declarando esse método pois, apesar de cada circulo e retangulo terem um getArea diferente, é necessário declarar aqui pois vamos usar isso aqui quando quisermos ver o arrayList de Formas
    public double getPerimeter(){
        return 0.0;
    }

    public String getInfo() {
        //DecimalFormat d = new DecimalFormat("0.00"); //double x = 4.3; System.out.println( d.format(x) ); //4.30
        return String.format("%s: A=%.2f P=%.2f", this.name, this.getArea(), this.getPerimeter());
    }
    @Override //vamo chamar Abstrato
    
    public String toString() {
        return "";
    }
}