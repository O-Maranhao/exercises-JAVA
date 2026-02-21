class Solver {
public static void main (String[] args) {
Motorcycle moto = new Motorcycle(1);

while (true) {
String[] line = IO.inputPartsPrintingLine();

if ( line[0].equals("end") ) { break; }
else if ( line[0].equals("show") ) { IO.println( moto.toString() ); }
else if ( line[0].equals("init") ) { moto = new Motorcycle( IO.strToInt(line[1]) ); }

else if ( line[0].equals("enter") ) { moto.insert( new Person( line[1], IO.strToInt(line[2]))); }
else if ( line[0].equals("leave") ) { Person p = moto.remover(); if (p!= null) IO.println(p); }
else if ( line[0].equals("buy") ) { moto.buyTime(IO.strToInt(line[1])); }
else if ( line[0].equals("drive") ) { moto.drive(IO.strToInt(line[1])); }
else if ( line[0].equals("honk") ) { moto.honk(); }
else { IO.println("fail: comando invalido"); }
}
}
}