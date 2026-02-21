import java.util.*;


class MsgException extends Exception {
    public MsgException(String message) {
        super(message);
    }
}


abstract class Funcionario {
    protected String nome;
    protected int bonus;
    protected int diarias;
    private int maxDiarias;


    public Funcionario(String nome, int maxDiarias) {
        this.nome = nome;
        this.bonus = 0;
        this.diarias = 0;
        this.maxDiarias = maxDiarias;
    }


    public String getNome() {
        return this.nome;
    }


    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


    //se atingiu o máximo, lance uma MsgException
    //se não atingiu o máximo, adicione mais uma diária
    public void addDiaria() throws MsgException {
        // if (this instanceof Terceirizado) {
        //     throw new MsgException("fail: terc nao pode receber diaria");
        // }


        if (this.diarias >= this.maxDiarias) {
            throw new MsgException("fail: limite de diarias atingido");
        }
        
        this.diarias ++;
    }


    //retorna bonus + diarias * 100
    public int getSalario() {
        return this.bonus + this.diarias * 100;
    }
}


class Professor extends Funcionario {
    protected String classe;


    //inicializa classe e muda maxDiarias para 2
    public Professor(String nome, String classe) {
        super(nome,2);
        // this.maxDiarias = 2;
        this.classe = classe;
    }


    public String getClasse() {
        return this.classe;
    }
    
    //lógica do salário do professor
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        int salClasse = 0;
        switch (this.classe) {
            case "A":
                salClasse = 3000;
                break;
            case "B":
                salClasse = 5000;
                break;
            case "C":
                salClasse = 7000;
                break;
            case "D":
                salClasse = 9000;
                break;
            case "E":
                salClasse = 11000;
                break;
        }
        return super.getSalario() + salClasse;
    }


    @Override
    public String toString() {
        // prof:david:C:7000
        return "prof:"+this.nome+":"+this.classe+":"+this.getSalario();
    }
}


class STA extends Funcionario {
    protected int nivel;


    //inicializa nivel e muda maxDiarias para 1
    public STA(String nome, int nivel) {
        super(nome,1);
        this.nivel = nivel;
    }
    
    public int getNivel() {
        return this.nivel;
    }


    //lógica do salário do sta
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        return super.getSalario() + 3000 + 300 * this.nivel;
    }


    @Override
    public String toString() {
        // sta:gilmario:3:3900
        return "sta:"+this.nome+":"+this.nivel+":"+this.getSalario();
    }
}


class Terceirizado extends Funcionario {
    protected int horas;
    protected boolean isSalubre;


    // $addTer helder 40 sim
    public Terceirizado(String nome, int horas, String isSalubre) {
        super(nome,0);
        this.horas = horas;
        this.isSalubre = isSalubre.equals("sim"); // ? true : false;
    }


    public int getHoras() {
        return this.horas;
    }


    public String getIsSalubre() {
        return this.isSalubre ? "sim" : "nao";
    }


    // lance uma MsgException com um texto diferente
    @Override
    public void addDiaria() throws MsgException {
        throw new MsgException("fail: terc nao pode receber diaria");
    }


    //lógica do salário do terceirizado
    //usa o super.getSalario() para pegar bonus e diarias
    @Override
    public int getSalario() {
        return super.getSalario() + 4 * this.horas + (this.isSalubre ? 500 : 0);
    }


    @Override
    public String toString() {
        // ter:helder:40:sim:660
        return "ter:"+this.nome+":"+this.horas+":"+this.getIsSalubre()+":"+this.getSalario();
    }
}


class UFC {
    // private List<Funcionario> funcionarios;
    private Map<String, Funcionario> funcionarios;
    
    public UFC() {
        // funcionarios = new ArrayList<Funcionario>();
        funcionarios = new TreeMap<>();
    }    
    


    @Override
    public String toString() {
        String res = "";
        for (Funcionario func : this.funcionarios.values()) {
            res += func + "\n";
            // res += func.toString() + " ";
        }
        res += "";
        return res;


        //mais eficiente, mas sintaxe menos facil
        // String res = "{ ";
        // for (Map.Entry<String,Funcionario> par : this.funcionarios.entrySet()) {
        //     res += par.getValue().toString() + " ";
        // }
        // res += "}";
        // return res;


		// Iterating over the Map.entrySet() using map.forEach
        // for (Map.Entry<String, String> entry : businessDays.entrySet())
        // {
        // 	System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        // }


        //uma alternativa, apenas para lista
        // String res = "{ ";
        // for (int i=0; i<this.funcionarios.size(); i++) {
        //     Funcionario func = this.funcionarios.get(i);
        //     res += func.toString() + " ";
        // }
        // res += "}";
        // return res;


        // String res = "{ ";
        // for (int i=0; i<this.funcionarios.values().size(); i++) {
        //     Funcionario func = this.funcionarios.values().get(i);
        //     res += func.toString() + " ";
        // }
        // res += "}";
        // return res;
    }


    public Funcionario getFuncionario(String nome) {
        return this.funcionarios.get(nome);
    }


    public void addFuncionario(Funcionario funcionario) {
        // this.funcionarios.add(funcionario);
        this.funcionarios.put(funcionario.getNome(), funcionario);
    }
    
    public void rmFuncionario(String nome) {
        this.funcionarios.remove(nome);
    }


    //reparte o bonus para todos os funcionarios
    public void setBonus(int bonus) throws MsgException {
        if ( this.funcionarios.size() == 0 ) {
            throw new MsgException("fail: sem funcionarios");
        }


        for (Funcionario func : this.funcionarios.values()) {
            func.setBonus(bonus/this.funcionarios.size());
        }        
    }
}


public class Solver {
    public static void main(String[] arg) {
        UFC ufc = new UFC();


        while (true) {
            String line = input();
            println("$" + line);
            String[] args = line.split(" ");


            try {
                if      (args[0].equals("end"))          { break; }
                else if (args[0].equals("addProf"))      { ufc.addFuncionario(new Professor(args[1], args[2])); }
                else if (args[0].equals("addSta"))       { ufc.addFuncionario(new STA(args[1], (int) number(args[2]))); }
                else if (args[0].equals("addTer"))       { ufc.addFuncionario(new Terceirizado(args[1], (int) number(args[2]), args[3])); }
                else if (args[0].equals("rm"))           { ufc.rmFuncionario(args[1]); }
                else if (args[0].equals("showAll"))      { print(ufc); }
                else if (args[0].equals("show"))         { println(ufc.getFuncionario(args[1])); }
                else if (args[0].equals("addDiaria"))    { ufc.getFuncionario(args[1]).addDiaria(); }
                else if (args[0].equals("setBonus"))     { ufc.setBonus((int) number(args[1])); }
                else                                     { println("fail: comando invalido"); }
            } catch (MsgException me) {
                println(me.getMessage());
                // e.printStackTrace(System.out);
            }
        }
    }


    private static Scanner scanner = new Scanner(System.in);
    private static String  input()                { return scanner.nextLine();        }
    private static double  number(String value)   { return Double.parseDouble(value); }
    public  static void    println(Object value)  { System.out.println(value);        }
    public  static void    print(Object value)    { System.out.print(value);          }
}
