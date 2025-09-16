package main; 

import controller.BancoController;

/**
 * Classe principal para inicialização do Sistema Bancário.
 * 
 * Esta classe é responsável apenas por instanciar o controller principal
 * e iniciar a execução do sistema, seguindo o padrão MVC.
 */
public class Main {

    public static void main(String[] args) {
        // Instancia o controller principal do sistema
        BancoController bancoController = new BancoController();
        
        // Inicia a execução do sistema bancário
        bancoController.iniciarSistema();
    }
}