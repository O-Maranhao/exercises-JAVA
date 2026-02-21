class Point2D {
    public double x;
    public double y;

    public Point2D( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public double distance( Point2D p ) {
        double cH = this.x - p.x; //cateto horizontal
        double cV = this.y - p.y; //catteto vertical
        return Math.sqrt( cH*cH + cV*cV ); //tio pit
    }

    @Override
    public String toString() {
        return "";
    }
}
