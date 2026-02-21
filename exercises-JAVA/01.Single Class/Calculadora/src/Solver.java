
class Solver {
    public static void main (String[] arg) {
        Calcu calculadora = new Calcu(0);
        calculadora.inicializar(0); //Desnecessário inicializar, quando criei o objeto, o new Calcu(0) já iniciou 
        while (true) {
            String line = IO.input(); //Isso serve para poder ler a linha inteira, uam alternativa para economizar as linhas 7 a 9 é botar IO.inputParts()
            IO.println("$" + line); // Imprimir com esse símbolo, vai ser tipo um avaliador, vamos quebrar essa linha elementos do vetor
            String[] args = line.split(" "); //Split serve para poder dividir (quebrar a string), pra retornar o vetor com elementos separados a partir de um marcador ( no caso sendo espaço '  '), retornando como um vetor de string, o nome do vetor de String é args

            if      (args[0].equals("end"))   { break; }
            else if (args[0].equals("init")){ calculadora = new Calcu(IO.strToInt(args[1]));      }
            else if (args[0].equals("charge")){calculadora.recarregar (IO.strToInt(args[1]));}
            else if (args[0].equals("sum")){calculadora.somar(IO.strToFloat(args[1]), IO.strToFloat(args[2])); } 
            else if (args[0].equals("div")) {calculadora.dividir(IO.strToFloat(args[1]), IO.strToFloat(args[2])); }
            
            else if (args[0].equals("show"))  { IO.println( calculadora.toString() );  } // desnecessário usar o toString, o println já assume que é esse método
            else                              { IO.println("fail: comando invalido");  }
        }
    }
}