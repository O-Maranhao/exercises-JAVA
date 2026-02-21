class Solver {
    public static void main (String[] args) {
        Theater theater = new Theater(0);


        while (true) {
            String[] parts = IO.inputPartsPrintingLine();
            
            String cmd = parts[0];
            
            if      ( cmd.equals("end")    )  { break;                                                      }
            else if ( cmd.equals("show")   )  {
                                                IO.println(theater);                                        }
            else if ( cmd.equals("init")   )  { int capacity = Integer.parseInt(parts[1]);
                                                theater = new Theater(capacity);                            }
            else if ( cmd.equals("reserve") ) { String nome = parts[1];
                                                int telefone = Integer.parseInt(parts[2]);
                                                int index = Integer.parseInt(parts[3]);
                                                theater.reserve(nome, telefone, index);                     }
            else if ( cmd.equals("cancel")  ) { String nome = parts[1];
                                                theater.cancel(nome);                                       }
            else                              { IO.println("fail: comando invalido");                       }
        }
    }
}
