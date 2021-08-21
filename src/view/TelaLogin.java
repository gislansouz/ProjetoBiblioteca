package view;
import controller.ConexaoBD;
import java.util.Scanner;
/**
 *
 * @author gislan
 */
public class TelaLogin {
    public static void main(String[] args) {
        ConexaoBD conex=new ConexaoBD();
        conex.conexao();
        Scanner teclado =new Scanner(System.in);
        String usuario,senha;
        System.out.println("\n█▀ █ █▀ ▀█▀ █▀▀ █▀▄▀█ ▄▀█   █▄▄ █ █▄▄ █   █ █▀█ ▀█▀ █▀▀ █▀▀ ▄▀█\n"+
"▄█ █ ▄█  █  ██▄ █ ▀ █ █▀█   █▄█ █ █▄█ █▄▄ █ █▄█  █  ██▄ █▄▄ █▀█"+"\033[0m");
        
        System.out.println("\nDigite o Usuário:");
        usuario=teclado.nextLine();
        System.out.println("Senha:");
        senha=teclado.nextLine();
    }
}
