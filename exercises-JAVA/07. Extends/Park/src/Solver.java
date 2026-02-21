class Solver {
    public static void main(String[] args) {
        Park park = new Park();
        
        while (true) {
            String[] line = IO.inputPartsPrintingLine();
            try{
                if (line[0].equals("end")) {
                    break;
                // } else if (line[0].equals("tempo")) {
                //     park.passaTempo(IO.strToInt(line[1]));
                } else if (line[0].equals("show")) {
                    IO.println(park);
                } else if (line[0].equals("tempo")) {
                    park.passarTempo(IO.strToInt(line[1]));
                } else if (line[0].equals("estacionar")) {
                    park.estacionar(line[1],line[2]);
                } else if (line[0].equals("pagar")) {
                    park.pagar(line[1]);
                // } else if (line[0].equals("addCoin")) {
                //     Coin coin = parseCoin(line[1]);
                //     pig.addCoin(coin);
                // } else if(line[0].equals("addItem")){
                //     Item item = new Item(line[1], IO.strToInt(line[2]));
                //     pig.addItem(item);
                // } else if(line[0].equals("extractCoins")){
                //     IO.println(pig.extractCoins());
                // } else if(line[0].equals("extractItems")){
                //     IO.println(pig.extractItems());
                // } else if(line[0].equals("break")){
                //     pig.breakPig();
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

}