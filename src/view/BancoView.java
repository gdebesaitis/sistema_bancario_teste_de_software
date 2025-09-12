package view;

import model.Cliente;
import model.ContaCorrente;
import java.util.List;

public class BancoView {

	public void exibirCliente(Cliente c) {
		if (c != null ) {
			System.out.println(c.toString());
		}
	}
	
	public void exibirConta(ContaCorrente cc) {
		if (cc != null) {
			System.out.println(cc.toString());
		}
	}
	
	public void exibirListaClientes(List<Cliente> clientes) {
		if (clientes == null || clientes.isEmpty()) {
			System.out.println("\nNenhum cliente cadastrado.");
			return;
		}
		
		System.out.println("\n==== LISTA DE CLIENTES ====");
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}
		System.out.println("=============================");
	}
	
	public void exibirContas(List<ContaCorrente> contas) {
		if (contas == null || contas.isEmpty()) {
			System.out.println("\nNenhuma conta encontrada.");
			return;
		}
		
		System.out.println("\n==== LISTA DE CONTAS ====");
		for(ContaCorrente cc : contas) {
			System.out.println(cc.toString());
		}
		System.out.println("=============================");
	}
	
	
	
	
	
}
