enum Label{ //
    GIVE("give"),
    TAKE("take"),
    PLUS("plus"); //Possíveis valores
    
    private String descricao;
    
    Label(String descricao){
        this.descricao = descricao;
    }
    
    @Override
    public String toString(){
        return descricao;
    }
}