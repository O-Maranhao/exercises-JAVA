import java.text.DecimalFormat;

class Circle extends Shape{ // tipo herança só que de interface, classes normais usam extends
    //Atributos
    public Point2D center;
    public double radius;

    public Circle( Point2D center, double radius ){
        super("Circ"); //Isso aqui é pra chamar o construtor da classe pai
        //this.name = "Circ";
        this.center = center;
        this.radius = radius; //estamos contruindo para evitar que seja um ponteiro nulo
    }

    public boolean inside( Point2D p ){
        if(this.center.distance(p)> this.radius){
            return true;
        } else{
            return false;
        }
    }
    public double getArea(){ //estamos criando um método que é uma extensão de um método abstrato de Shape
        double a = Math.PI * this.radius * this.radius;
        return a;
    }
    public double getPerimeter(){
        return Math.PI * 2 * this.radius;
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00"); //double x = 4.3; System.out.println( d.format(x) ); //4.30
        return "Circ" + ": " + "C=(" + d.format(this.center.x) + ", " + d.format(this.center.y) + "), R=" + d.format(this.radius);
    }
}