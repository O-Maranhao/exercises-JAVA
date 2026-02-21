class Solver {
    public static void main (String[] args) {
        Pet pet = new Pet(0, 0);
        
        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      (line[0].equals("end"))   { break;                                                                             }
            else if (line[0].equals("show"))  { IO.println( pet.toString() );                                                      }
            else if (line[0].equals("init"))  { pet = new Pet( IO.strToInt(line[1]), IO.strToInt(line[2])); }
            else if (line[0].equals("play"))  { pet.play();                                                                        }
            else if (line[0].equals("sleep")) { pet.sleep();                                                                       }
            else if (line[0].equals("shower")){ pet.shower();                                                                      }
            else                              { IO.println("fail: comando invalido");                                              }
        }
    }
}