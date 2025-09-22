/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import exception.SaldoInsuficienteException;
import strategy.TarifaStrategy;

public class ContaCorrente extends Conta{
    
    public ContaCorrente(int numero, String titular, double saldo){
        super(numero, titular, saldo);
    }
    
    @Override
    public void Sacar(double valor){
       try{
           if(this.saldo < valor){
               throw new SaldoInsuficienteException("O valor solicitado é maior que o saldo");
           }
           
           this.saldo = this.saldo - valor;
           System.out.println("Saldo atual - " + this.saldo);
       } catch(SaldoInsuficienteException ex){
           System.out.println(ex.getMessage());
       }
       
    }
    
}
