/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import static view.Principal.Limpar;
import static view.Principal.opcao;

/**
 *
 * @author gislan
 */
public class TelaEmprestimo {
    public static void main(String[] args) {
        Scanner teclado =new Scanner(System.in);
        //tela usuario
        do{
        System.out.println("\n▀█▀ █▀▀ █   ▄▀█   █▀▀ █▀▄▀█ █▀█ █▀█ █▀▀ █▀ ▀█▀ █ █▀▄▀█ █▀█\n" +
" █  ██▄ █▄▄ █▀█   ██▄ █ ▀ █ █▀▀ █▀▄ ██▄ ▄█  █  █ █ ▀ █ █▄█"+"\033[0m");
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
            Principal.opcao="cadastrar";
            Limpar();
	} 
        
        /*opção livro*/
        if(arrayTokens[0].equals("listar")||arrayTokens[0].equals("2")) {
            Principal.opcao="listar";
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
