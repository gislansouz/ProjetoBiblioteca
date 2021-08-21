/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;

/**
 *
 * @author gislan
 */
public class ConexaoBD {
   
    public Statement stm;
    public ResultSet rs;
    private final String driver="org.postgresql.Driver";
    private final String caminho="jdbc:postgresql://localhost:5432/ProjetoBiblioteca";
    private final String usuario="postgres";
    private final String senha="postgres";
    public Connection con;
    
    public void conexao (){
        try{
        System.setProperty("jdbc,Drivers",driver);
        con=DriverManager.getConnection(caminho, usuario, senha);
        System.out.print("Conexão efetuada com sucesso\n");
    } catch (SQLException ex){
        System.out.print("Erro ao conectar com o banco de dados:\n"+ex.getMessage());
    }
}

    
    public void executaSql(String sql){
        try{
            stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql); 
    }catch(SQLException ex){
        System.out.print("Erro ao conectar com o banco de dados:\n"+ex.getMessage());
    }
    }       
public void desconecta(){
        try {
            con.close();
             System.out.print("BD desconectado com sucesso!\n"); 
        } catch (SQLException ex) {
            System.out.print("Erro ao fechar conexão com BD:\n"+ex.getMessage());
        }

}
}
