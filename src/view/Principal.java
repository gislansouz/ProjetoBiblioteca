package view;
import controller.ConexaoBD;
import java.util.Scanner;

public class Principal{
    public static void main(String Args[]){
        ConexaoBD conex=new ConexaoBD();
        conex.conexao();
        Scanner teclado =new Scanner(System.in);
        /*tela principal*/
        do{
        System.out.println("\n█▀ █ █▀ ▀█▀ █▀▀ █▀▄▀█ ▄▀█   █▄▄ █ █▄▄ █   █ █▀█ ▀█▀ █▀▀ █▀▀ ▄▀█\n"+
"▄█ █ ▄█  █  ██▄ █ ▀ █ █▀█   █▄█ █ █▄█ █▄▄ █ █▄█  █  ██▄ █▄▄ █▀█"+"\033[0m");
        
        /*menu inicial*/
	System.out.println("=========================");
	System.out.println("|     1 - Usuario       |");
	System.out.println("|     2 - Livros        |");
	System.out.println("|     3 - Emprestimo    |");
	System.out.println("|     4 - Multas        |");
	System.out.println("|     0 - Exit          |");
	System.out.println("=========================\n");
        System.out.println("Opção ->");
        
        /*dividindo a string por espaço*/
        linha=teclado.nextLine();
        String[]arrayTokens = linha.split(" ");
        
        /*opção usuario*/
        if(arrayTokens[0].equals("usuario")||arrayTokens[0].equals("1")) {
            opcao="usuario";
            Limpar();
            TelaUsuario.main(null);
	} 
        
        /*opção livro*/
        if(arrayTokens[0].equals("livros")||arrayTokens[0].equals("2")) {
            Limpar();
            opcao="livros";
            TelaLivros.main(null);
	}
        
        /*opção emprestimo*/
        if(arrayTokens[0].equals("empretimo")||arrayTokens[0].equals("3")) {
            Limpar();
            opcao="emprestimo";
            TelaEmprestimo.main(null);
	}
        
        /*menu multas*/
        if(arrayTokens[0].equals("multas")||arrayTokens[0].equals("4")) {
           Limpar();
           TelaMultas.main(null);
	}
        
        /*opção sair-exit*/
        if(arrayTokens[0].equals("exit")||arrayTokens[0].equals("0")) {
            Limpar();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!Programa Encerrado!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            conex.desconecta();
            System.exit(0);
	}
        
        /*opção limpar para linux*/
        if(arrayTokens[0].equals("limpar")||arrayTokens[0].equals("clear")) {
           Limpar();
	}
        
    }while(opcao.equals("principal"));
    }
    public static String opcao="principal";
    public static String linha;
    public static void Limpar() {
         System.out.print("\033\143");//Limpar terminal
    }
}


