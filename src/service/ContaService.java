/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.ContaCorrente;
import java.io.*;
import javax.swing.JOptionPane;

public class ContaService {
    public ContaCorrente criarConta(){
        try {
            FileWriter fw = new FileWriter("contas.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta"));
            String titular = JOptionPane.showInputDialog("Digite o titular");
            double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo"));
            
            bw.write(numero + "," + titular + "," + saldo);
            bw.newLine();
            bw.close();
            
            ContaCorrente conta = new ContaCorrente(numero, titular, saldo);
            return conta;
        } catch (IOException ex){
            System.out.println("Erro!");
            return null;
        }
    }
    
    public ContaCorrente lerConta(){
        
        try{
            FileReader fr = new FileReader("contas.txt");
            BufferedReader br = new BufferedReader(fr);
            
            String linha = br.readLine();
            System.out.println(linha);
            
            String[] partes = linha.split(",");
            
            int numero = Integer.parseInt(partes[0]);
            double saldo = Double.parseDouble(partes[2]);
           
            ContaCorrente conta = new ContaCorrente(numero, partes[1], saldo);
            
            return conta;
        } catch (IOException ex){
            System.out.println("Erro! " + ex.getMessage());
            return null;
        }
    }
}
