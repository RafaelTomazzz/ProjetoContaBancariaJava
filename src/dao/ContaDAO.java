/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.*;
import model.ContaCorrente;

public class ContaDAO {
    public boolean InserirConta(ContaCorrente conta){
        String sql = "INSERT INTO clientes (numero, titular, saldo) VALUES (?, ?, ?)";
        try(Connection con = Conexao.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, conta.getNumero());
            stmt.setString(2, conta.getTitular());
            stmt.setDouble(3, conta.getSaldo());
            stmt.executeUpdate();
            
            return true;
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<ContaCorrente> ListarContas(){
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
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            ContaCorrente conta = new ContaCorrente(
                rs.getInt("numero"),
                rs.getString("titular"),
                rs.getDouble("saldo")
            );
            
            return conta;
            
        } catch(SQLException ex){
            return null;
        }
    }
    
    
    public void atualizarSaldo(int numero, double saldo) {
        ContaCorrente conta = this.buscarPorNumero(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada!");
            return;
        }

        String sql = "UPDATE clientes SET saldo = ? WHERE numero = ?";
        try (Connection con = Conexao.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, saldo);
            stmt.setInt(2, numero);
            stmt.executeUpdate();

            System.out.println("Saldo atualizado com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean ExcluirConta(int numero){
        String sql = "DELETE FROM clientes WHERE numero = ?";
        
        try(Connection con = Conexao.getConnection()){
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, numero);
            stmt.executeUpdate();
            
            return true;
        } catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean transferir(int numeroOrigem, int numeroDestino, double valor){
        String sql = "UPDATE clientes SET saldo = ? WHERE numero = ?";
        ContaCorrente contaO = this.buscarPorNumero(numeroOrigem);
        ContaCorrente contaD = this.buscarPorNumero(numeroDestino);
        
        try{
            Connection con = Conexao.getConnection();
            con.setAutoCommit(false);

            try{
                PreparedStatement stmtO = con.prepareStatement(sql);
                stmtO.setDouble(1, contaO.getSaldo() - valor);
                stmtO.setInt(2, contaO.getNumero());

                PreparedStatement stmtD = con.prepareStatement(sql);
                stmtD.setDouble(1, contaD.getSaldo() + valor);
                stmtD.setInt(2, contaD.getNumero());

                stmtO.executeUpdate();
                stmtD.executeUpdate();

                con.commit();
            } catch(SQLException ex){
                con.rollback();
                return false;
            }
            
            return true;
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
        
}
