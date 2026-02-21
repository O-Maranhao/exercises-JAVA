class Solver {
    public static void main (String[] arg) {
        Carro carro = new Carro();

        while (true) {
            String[] line = IO.inputParts();

            if      (line[0].equals("end"))   { break;                                 }
            else if (line[0].equals("init"))  { carro = new Carro();                   }
            else if (line[0].equals("enter")) { carro.enter();                         }
            else if (line[0].equals("leave")) { carro.leave();                         }
            else if (line[0].equals("drive")) { carro.drive( IO.strToInt(line[1]) );   }
            else if (line[0].equals("fuel"))  { carro.fuel( IO.strToInt(line[1]) );    }
            else if (line[0].equals("show"))  { IO.println( carro.toString() );        }
            else                              { IO.println("fail: comando invalido");  }
        }
    }
}
