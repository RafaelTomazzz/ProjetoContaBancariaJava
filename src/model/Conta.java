/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import strategy.TarifaStrategy;
/**
 *
 * @author Administrador
 */
public abstract class Conta {
    public int numero;
    public String titular;
    public double saldo;
    public TarifaStrategy tarifa;
    
    public Conta(int numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public double calcularTaxa() {
        return tarifa.calcularTarifa(this.saldo);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public abstract void Sacar(double valor);
    
    public double Depositar(double valor){
        this.saldo =+ valor;
        return this.saldo;
    }
    
    public void ImprimirDados(){
        System.out.println("Numero da conta - " + this.numero + " | Titular da conta - " + this.titular + " | Saldo - " + this.saldo);
    }
}
