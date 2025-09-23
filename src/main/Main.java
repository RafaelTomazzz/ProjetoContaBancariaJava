/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;
import java.io.*;
import javax.swing.JOptionPane;
import service.ContaService;
import model.ContaCorrente;
import java.util.*;
import dao.ContaDAO;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ContaService contaService = new ContaService();
        
        //ContaCorrente conta = contaService.criarConta();
        ArrayList<ContaCorrente> contas = contaService.lerContas();
        
        int n = contas.size();
        
        while(n >= 1){
            ContaCorrente lerconta = contas.get(n - 1);
            System.out.println(n + " | Numero: " + lerconta.numero + " - Titular: " + lerconta.titular + " - Saldo: " + lerconta.saldo);
            n--;
        }
        
        int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número conta que deseja selecionar"));
        ContaCorrente contaSelecionada = contaService.selecionarConta(numero);
        
        JOptionPane.showMessageDialog(null, "Conta selecionada\n\n" + "Numero: " + contaSelecionada.getNumero() + " - Titular: " + contaSelecionada.getTitular() + " - Saldo: " + contaSelecionada.getSaldo());
        
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("Oque deseja realizar? 1 - Saque  2 - Depósito"));
        
        switch(opcao){
            case 1: 
                double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantia do saque"));
                contaSelecionada.Sacar(valorSaque);
                
                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! Saldo atual - " + contaSelecionada.getSaldo());
                break;
            case 2:    
                try{
                    double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantia do saque"));
                    contaSelecionada.Depositar(valorDeposito);
                    
                    JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso! Saldo atual - " + contaSelecionada.getSaldo());
                } catch(NumberFormatException ex){
                    System.out.println("Erro!Você entrou com um valor não numérico." + ex.getMessage());
                }
        }
        /*
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
        */
        ContaDAO contaDAO = new ContaDAO();
        
        /*
        ContaCorrente contaA = new ContaCorrente(458935, "Rafael Tomaz", 12900.0);
        contaDAO.InserirConta(contaA);
        ContaCorrente contaB = new ContaCorrente(147855, "Renato Tomaz", 4000.0);
        contaDAO.InserirConta(contaB);
        ContaCorrente contaC = new ContaCorrente(153269, "Gustavo Tomaz", 5000.0);
        contaDAO.InserirConta(contaC);
        ContaCorrente contaD = new ContaCorrente(156329, "Vitoria Martinez", 2800.0);
        contaDAO.InserirConta(contaD);
        ContaCorrente contaE = new ContaCorrente(632987, "Stelia Martinez", 4050.0);
        contaDAO.InserirConta(contaE);
        ContaCorrente contaF = new ContaCorrente(569874, "Luiz Gomes", 3800.0);
        contaDAO.InserirConta(contaF);
        ContaCorrente contaG = new ContaCorrente(632798, "Iris Thaina", 5000.0);
        contaDAO.InserirConta(contaG);
        ContaCorrente contaH = new ContaCorrente(795432, "Isabel Gomes", 6800.0);
        contaDAO.InserirConta(contaH);
        */
        
        List<ContaCorrente> contas = contaDAO.ListarContas();
        contas.stream()
                .forEach(conta -> System.out.println("Titular: " + conta.getTitular() + " - Numero: " + conta.getNumero() + " - Saldo: " + conta.getSaldo()));;
    }
    
}
