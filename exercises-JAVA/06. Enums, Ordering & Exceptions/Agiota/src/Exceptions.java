class ClienteInexistenteException extends Exception {
    @Override
    public String getMessage(){
        return "fail: cliente nao existe";
    }
} //Vantagens de se usar exception: organização pois o tratamento de erro não fica no mesmo lugar, assim como o teste pra ver se os métodos funcionam

class ClientException extends Exception{
    private boolean existe;

    public ClientException(boolean existe) {
        this.existe = existe;
    }

    @Override
    public String getMessage() {
        if (this.existe)
            return "fail: cliente ja existe";
        else
            return "fail: cliente nao existe";
    }
}



class ClienteException extends Exception{
    public ClienteException(String message){
        super(message); //chama o construto de Exception
    }
}