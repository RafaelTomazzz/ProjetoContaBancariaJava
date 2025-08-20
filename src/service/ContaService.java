/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.ContaCorrente;
import java.io.*;

public class ContaService {
    public ContaCorrente lerConta(){
        
        try{
            FileReader fr = new FileReader("conta.txt");
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
