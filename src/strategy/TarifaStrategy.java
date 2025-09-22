/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author rafae
 */
public enum TarifaStrategy {
    FIXA {
        public double calcularTarifa(double saldo) {
            return 10;
        }
    },
    PERCENTUAL {
        public double calcularTarifa(double saldo){
            return saldo * 0.01;
        }
    },
    ISENTA {
        public double calcularTarifa(double saldo){
            return 0;
        }
    };
    
    public abstract double calcularTarifa(double saldo);
}
