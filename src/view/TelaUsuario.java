package view;
import controller.ConexaoBD;
import controller.UsuarioController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import model.ModelUsuario;
import static view.Principal.*;
public class TelaUsuario {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        ConexaoBD conex=new ConexaoBD();
        ModelUsuario mod = new ModelUsuario();
        UsuarioController control = new UsuarioController();
        conex.conexao();
        //tela usuario
        do{
        System.out.println("\n▀█▀ █▀▀ █   ▄▀█   █ █ █▀ █ █ ▄▀█ █▀█ █ █▀█\n" +
" █  ██▄ █▄▄ █▀█   █▄█ ▄█ █▄█ █▀█ █▀▄ █ █▄█"+"\033[0m");
        /*menu inicial*/
	System.out.println("=========================");
	System.out.println("|     1 - Cadastrar     |");
	System.out.println("|     2 - Listar        |");
	System.out.println("|     3 - Excluir       |");
        System.out.println("|     4 - Pesquisar     |");
	System.out.println("|     5 - Alterar       |");
        System.out.println("|     6 - Voltar        |");
	System.out.println("|     0 - Exit          |");
	System.out.println("=========================");
        System.out.println("Opção ->");
                
        /*dividindo a string por espaço*/
        Principal.linha=teclado.next();
        String[]arrayTokens = Principal.linha.split(" ");
        for (String s: arrayTokens)
            System.out.println(s);
        
        /*opção usuario*/
        if(arrayTokens[0].equals("cadastrar")||arrayTokens[0].equals("1")) {
            Scanner line=new Scanner(System.in);
            System.out.println("Digite o nome:");
            mod.setNome(line.nextLine());
            
            System.out.println("Digite o email:");
            mod.setEmail(line.nextLine());
            
            System.out.println("Digite o endereco:");
            mod.setEndereco(line.nextLine());
            
            System.out.println("Digite o cpf:");
            mod.setCpf(line.nextLine());
            
            System.out.println("Digite o datainsercao:");
            mod.setDataInsercao(line.nextLine());
            
            System.out.println("Digite o nascimento:");
            mod.setDataNascimento(line.nextLine());
            
            control.SalvarUsuario(mod);
	} 
        
        /*opção listar*/
        if(arrayTokens[0].equals("listar")||arrayTokens[0].equals("2")) {
            /*metodo preencher tabela*/
            ArrayList <Object[]>dados =new ArrayList();
            conex.executaSql("select *from usuario order by id");
            /*trocar o codigo para pesquisar*/
                try{
                    conex.rs.first();
                    do{
                        dados.add(new Object[]{conex.rs.getInt("id"),conex.rs.getString("nome"),conex.rs.getString("email"),conex.rs.getString("endereco"),conex.rs.getString("cpf"),conex.rs.getString("datanascimento"),conex.rs.getString("datadecadastro")});
                    }while(conex.rs.next());
                }catch(SQLException ex){
                    System.out.print("Erro ao preencher arraylist:/nErro:"+ex);
                }
                int i=dados.size()-1;
                System.out.println("ID  | NOME  |   EMAIL   |  ENDEREÇO  | CPF   |  DATA DE NASCIMENTO  |   DATA DE INSERÇÃO");
                while(i>=0){
                    System.out.println(Arrays.toString(dados.get(i)));
                    i--;
                }
            Limpar();
	}
        
        /*opção emprestimo*/
        if(arrayTokens[0].equals("excluir")||arrayTokens[0].equals("3")) {
            Principal.opcao="excluir";
            Limpar();
	}
        
        /*menu multas*/
        if(arrayTokens[0].equals("pesquisar")||arrayTokens[0].equals("4")) {
           Principal.opcao="pesquisar";
           Limpar();
	}
        if(arrayTokens[0].equals("alterar")||arrayTokens[0].equals("5")) {
            Principal.opcao="alterar";
            Limpar();
	}
        /*opção sair-exit*/
        if(arrayTokens[0].equals("voltar")||arrayTokens[0].equals("6")) {
            Limpar();
            Principal.main(null);
            opcao="principal";
	}
        
    }while(opcao.equals("usuario"));
}
}
    

