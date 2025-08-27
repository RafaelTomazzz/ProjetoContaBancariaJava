/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import java.io.*;
import javax.swing.JOptionPane;
import service.ContaService;
import model.ContaCorrente;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContaService contaService = new ContaService();
        
        ContaCorrente conta = contaService.criarConta();
        
        ContaCorrente a_conta = contaService.lerConta();
        conta.ImprimirDados();
        
        double saque = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de saque"));
        conta.Sacar(saque);
        
        try{
            FileWriter filew = new FileWriter("conta_atualizada.txt");
            BufferedWriter fileb = new BufferedWriter(filew);
            
            fileb.write(conta.getNumero() + "," + conta.getTitular() + "," + conta.getSaldo());
            fileb.close();
            
        } catch (IOException ex){
            System.out.println("Erro! " + ex.getMessage());
        }
    }
    
}
