class Solver {
    public static void main (String[] args) {
        Pencil pencil = new Pencil( 0 );

        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      ( line[0].equals("end")    )  { break;                                                                               }
            else if ( line[0].equals("show")   )  { IO.println( pencil.toString() );                                                     }
            else if ( line[0].equals("init")   )  { pencil = new Pencil( IO.strToFloat(line[1]) );                                       }
            else if ( line[0].equals("insert") )  { pencil.insert( new Lead( IO.strToFloat(line[1]), line[2], IO.strToInt(line[3]) ) );  }
            else if ( line[0].equals("remove") )  { pencil.remove();                                                                     }
            else if ( line[0].equals("write")  )  { pencil.writePage();                                                                  }
            else                                  { IO.println("fail: comando invalido");                                                }
        }
    }
}
