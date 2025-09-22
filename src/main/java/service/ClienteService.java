package main.java.service;

import java.util.List;
import main.java.model.Cliente;
import main.java.model.exception.IdadeNaoPermitidaException;

/**
 * Classe de negócio para realizar operações sobre os clientes do banco.
 * 
 */
public class ClienteService {

	private List<Cliente> clientesDoBanco;

	public ClienteService(List<Cliente> clientesDoBanco) {
		this.clientesDoBanco = clientesDoBanco;
	}
	
	/**
	 * Retorna uma lista com todos os clientes do banco.
	 * @return lista com todos os clientes do banco
	 */
	public List<Cliente> getClientesDoBanco() {
		return clientesDoBanco;
	}
	
	/**
	 * Pesquisa por um cliente a partir do seu ID.
	 * @param idCliente id do cliente a ser pesquisado
	 * @return o cliente pesquisado ou null, caso não seja encontrado
	 */
	public Cliente pesquisaCliente(int idCliente) {
		for (Cliente cliente : clientesDoBanco) {
			if(cliente.getId() == idCliente)
				return cliente;
		}
		return null;
	}
	
	/**
	 * Adiciona um novo cliente à lista de clientes do banco.
	 * @param novoCliente novo cliente a ser adicionado
	 */
	public void adicionaCliente(Cliente novoCliente) {
		clientesDoBanco.add(novoCliente);
	}

	/**
	 * Remove cliente da lista de clientes do banco.
	 * @param idCliente ID do cliente a ser removido 
	 * @return true se o cliente foi removido. False, caso contrário.
	 */
	public boolean removeCliente(int idCliente) {
		boolean clienteRemovido = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if(cliente.getId() == idCliente){
				clientesDoBanco.remove(i);
				clienteRemovido = true;
				break;
			}
		}
		
		return clienteRemovido;
	}

	/**
	 * Informa se um determinado cliente está ativo ou não.
	 * @param idCliente ID do cliente cujo status será verificado
	 * @return true se o cliente está ativo. False, caso contrário. 
	 */
	public boolean clienteAtivo(int idCliente) {
		boolean clienteAtivo = false;
		
		for (int i = 0; i < clientesDoBanco.size(); i++) {
			Cliente cliente = clientesDoBanco.get(i);
			if(cliente.getId() == idCliente)
				if(cliente.isAtivo()){
					clienteAtivo = true;
					break;
				}
		}
		
		return clienteAtivo;
	}

	/**
	 * Ativa um cliente específico.
	 * @param idCliente ID do cliente a ser ativado
	 * @return true se o cliente foi ativado com sucesso, false caso não seja encontrado
	 */
	public boolean ativarCliente(int idCliente) {
		Cliente cliente = pesquisaCliente(idCliente);
		if (cliente != null) {
			cliente.setAtivo(true);
			return true;
		}
		return false;
	}

	/**
	 * Desativa um cliente específico.
	 * @param idCliente ID do cliente a ser desativado
	 * @return true se o cliente foi desativado com sucesso, false caso não seja encontrado
	 */
	public boolean desativarCliente(int idCliente) {
		Cliente cliente = pesquisaCliente(idCliente);
		if (cliente != null) {
			cliente.setAtivo(false);
			return true;
		}
		return false;
	}

	/**
	 * Limpa a lista de clientes, ou seja, remove todos eles. 
	 */
	public void limpa() {
		this.clientesDoBanco.clear();
	}
	
	/**
	 * Valida se a idade do cliente está dentro do intervalo permitido (18 - 65).
	 * @param idade a idade do possível novo cliente
	 * @return true se a idade é válida
	 * @throws IdadeNaoPermitidaException se a idade não estiver no intervalo permitido
	 */
	public boolean validaIdade(int idade) throws IdadeNaoPermitidaException {
		if(idade < 18 || idade > 65)
			throw new IdadeNaoPermitidaException();
		
		return true;
	}
}