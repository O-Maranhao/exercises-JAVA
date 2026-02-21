class Solver {
    public static void main(String[] args) {
        Pig pig = new Pig(0);

        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            try{
                if (line[0].equals("end")) {
                    break;
                } else if (line[0].equals("init")) {
                    pig = new Pig(IO.strToInt(line[1]));
                } else if (line[0].equals("show")) {
                    IO.println(pig);
                } else if (line[0].equals("addCoin")) {
                    Coin coin = parseCoin(line[1]);
                    pig.addCoin(coin);
                } else if(line[0].equals("addItem")){
                    Item item = new Item(line[1], IO.strToInt(line[2]));
                    pig.addItem(item);
                } else if(line[0].equals("extractCoins")){
                    IO.println(pig.extractCoins());
                } else if(line[0].equals("extractItems")){
                    IO.println(pig.extractItems());
                } else if(line[0].equals("break")){
                    pig.breakPig();
                } else {
                    IO.println("fail: comando invalido");
                }
            } catch(Exception e){
                String message = e.getMessage();
                if(message != null){
                    IO.println(e.getMessage());
                }
            }
        }
    }
    //Pra controlar as instâncias da moeda
    private static Coin parseCoin(String value){
        switch(value){
            case "10": return Coin.C10;
            case "25": return Coin.C25;
            case "50": return Coin.C50;
            case "100": return Coin.C100;
            default: return null;
        }
    }
}