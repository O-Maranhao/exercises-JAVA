import java.text.DecimalFormat;

class Rectangle extends Shape{
    public Point2D p1;
    public Point2D p2;

    public Rectangle ( Point2D p1, Point2D p2 ){
        super("Rect"); //declarando o construtor (vazio do Shape)
        //this.nome = "Rect";
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean inside( Point2D p ){
        if(p.x > this.p1.x && p.x<=this.p2.x && p.y>this.p2.y && p.y<=this.p2.y){
            return true;
        } else{
            return false;
        }
    }
    public double getArea(){
        double dx = this.p2.x - this.p1.x;
        double dy = this.p2.y - this.p1.y;
        return dy*dx;
    }
    public double getPerimeter() { //Perimetro
        double dx = this.p2.x - this.p1.x;
        double dy = this.p2.y - this.p1.y;
        
        return 2*(dx+dy);
    }

    @Override
    public String toString() {
        DecimalFormat d = new DecimalFormat("0.00"); //double x = 4.3; System.out.println( d.format(x) ); //4.30
        return "Rect" + ": " + "P1=(" + d.format(this.p1.x) + ", " + d.format(this.p1.y) + ") P2=(" + d.format(this.p2.x) + ", " + d.format(this.p2.y)+ ")";
    }
}