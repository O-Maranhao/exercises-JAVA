class Solver {
    public static void main (String[] args) {
        Time time = new Time(0, 0, 0);
        
        while (true) {
            String[] line = IO.inputPartsPrintingLine();

            if      (line[0].equals("end"))   { break;                                                                              }
            else if (line[0].equals("show"))  { IO.println(time);                                                      }
            else if (line[0].equals("init"))  { time = new Time( IO.strToInt(line[1]), IO.strToInt(line[2]), IO.strToInt(line[3])); }
            else if (line[0].equals("set"))   { time.setHour  ( IO.strToInt(line[1]) );
                                                time.setMinute( IO.strToInt(line[2]) );
                                                time.setSecond( IO.strToInt(line[3]) ); }
            else if (line[0].equals("next"))  { time.nextSecond();                                                                  }
            else                              { IO.println("fail: comando invalido");                                               }
        }
    }
}
