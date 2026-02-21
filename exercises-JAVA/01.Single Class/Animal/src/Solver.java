class Solver {
    public static void main (String[] arg) {
        Animal animal = new Animal("desconhecido", "desconhecido");
        //to String: pega as características do objeto e converte em texto
        animal.inicializar("desconhecido","desconhecido");
        
        while(true){
         String line = IO.input();
         IO.println("$"+line);
         String[] args = line.split(" ");
         
         if(args[0].equals("end")){
             break;
         }
         else if(args[0].equals("init")){
             animal = new Animal(args[1], args[2]);
         }
         else if(args[0].equals("grow")){
             animal.envelhecer(IO.strToInt(args[1]));
         }
         else if(args[0].equals("noise")){
             IO.println(animal.fazerBarulho());
         }
         else if(args[0].equals("show")){
             IO.println(animal.show());
         }
         else{
             IO.println("fail: comando invalido");
         }
         
        }
    }
}

