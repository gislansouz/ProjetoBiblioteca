package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ModelUsuario;
/**
 *
 * @author gislan
 */
public class UsuarioController {
    ConexaoBD conex = new ConexaoBD();
    ModelUsuario mod = new ModelUsuario();
    
    public void SalvarUsuario(ModelUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuario(nome, email, endereco, cpf, datanascimento, datadecadastro) values (?,?,?,?,?,?)");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEmail());
            pst.setString(3, mod.getEndereco());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getDataNascimento());
            pst.setString(6, mod.getDataInsercao());
            pst.execute();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir dados.\nErro: "+ex.getMessage());
        }
        conex.desconecta();
    }
    
    public void EditarUsuario(ModelUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE usuario SET nome=?, email=?, endereco=?, cpf=?, datanascimento=? WHERE id=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEmail());
            pst.setString(3, mod.getEndereco());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getDataNascimento());
            pst.setInt(5, mod.getId());
            pst.execute();
            System.out.println("Dados alterados com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar dados.\nErro: "+ex.getMessage());
        }
        conex.desconecta();
    }
    
    public ModelUsuario BuscarUsuario(ModelUsuario mod){
        conex.conexao();
        conex.executaSql("select * from usuario where nome like '%"+mod.getPesquisa()+"%'");        
        try {
            conex.rs.first();
            mod.setId(conex.rs.getInt("id"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setEndereco(conex.rs.getString("endereco"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setDataInsercao(conex.rs.getString("datanascimento"));
            mod.setDataInsercao(conex.rs.getString("datainsercao"));
            
        } catch (SQLException ex){
            System.out.println("Erro ao buscar dados.\nErro: "+ex.getMessage());
        }
        conex.desconecta();
        return mod;
    }
    
    public void ExcluirUsuario(ModelUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuario where id=?");
            pst.setInt(1, mod.getId());
            pst.execute();
            System.out.println("Dados excluidos com sucesso");
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir dados.\nErro: "+ex.getMessage());
        }
        conex.desconecta();
    }
    
}
