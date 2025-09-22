/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.ContaCorrente;

public class ContaDAO {
    public void InserirConta(ContaCorrente conta){
        String sql = "INSERT INTO clientes VALUES(numero, titular, saldo) AS (?, ?, ?)";
        try(Connection con = Conexao.getConnection()){
            PreparedStatement smtp = con.prepareStatement(sql);
            smtp.setInt(1, conta.getNumero());
            smtp.setString(2, conta.getTitular());
            smtp.setDouble(3, conta.getSaldo());
            smtp.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public List<ContaCorrente> ListarContar(){
        List<ContaCorrente> contas = new ArrayList<ContaCorrente>();
        String sql = "SELECT * FROM clientes";
        try(Connection con = Conexao.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while(rs.next()) {
                ContaCorrente conta = new ContaCorrente(
                    rs.getInt("numero"),
                    rs.getString("titular"),
                    rs.getDouble("saldo")
                );
                
                contas.add(conta);
            }
            
            return contas;
        } catch(SQLException ex){
            return null;
        }
    }
    
    public ContaCorrente buscarPorNumero(int numero){
        String sql = "SELECT * FROM clientes WHERE numero = ?";
        try(Connection con = Conexao.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, numero);
            
        } catch(SQLException ex){
        
        }
    
    }
}
