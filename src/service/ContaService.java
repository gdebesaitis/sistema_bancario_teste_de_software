package service;

import java.util.List;
import model.ContaCorrente;

/**
 * Classe de negócio para realizar operações sobre as contas do banco.
 * 
 */
public class ContaService {

	private List<ContaCorrente> contasDoBanco;

	public ContaService(List<ContaCorrente> contasDoBanco) {
		this.contasDoBanco = contasDoBanco;
	}

	/**
	 * Retorna uma lista com todas as contas do banco.
	 * @return lista com todas as contas do banco
	 */
	public List<ContaCorrente> getContasDoBanco() {
		return contasDoBanco;
	}

	/**
	 * Pesquisa por uma conta a partir do seu ID.
	 * @param idConta id da conta a ser pesquisada
	 * @return a conta pesquisada ou null, caso não seja encontrada
	 */
	public ContaCorrente pesquisaConta(int idConta) {
		for (ContaCorrente contaCorrente : contasDoBanco) {
			if(contaCorrente.getId() == idConta)
				return contaCorrente;
		}
		return null;
	}
	
	/**
	 * Adiciona uma nova conta à lista de contas do banco.
	 * @param novaConta nova conta a ser adicionada
	 */
	public void adicionaConta(ContaCorrente novaConta) {
		this.contasDoBanco.add(novaConta);
	}

	/**
	 * Remove conta da lista de contas do banco.
	 * @param idConta ID da conta a ser removida 
	 * @return true se a conta foi removida. False, caso contrário.
	 */
	public boolean removeConta(int idConta) {
		boolean contaRemovida = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			ContaCorrente conta = contasDoBanco.get(i);
			if(conta.getId() == idConta){
				contasDoBanco.remove(i);
				contaRemovida = true;
				break;
			}
		}
		
		return contaRemovida;
	}

	/**
	 * Informa se uma determinada conta está ativa ou não.
	 * @param idConta ID da conta cujo status será verificado
	 * @return true se a conta está ativa. False, caso contrário. 
	 */
	public boolean contaAtiva(int idConta) {
		boolean contaAtiva = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			ContaCorrente conta = contasDoBanco.get(i);
			if(conta.getId() == idConta)
				if(conta.isAtiva()){
					contaAtiva = true;
					break;
				}
		}
		
		return contaAtiva;
	}
	
	/**
	 * Transfere um determinado valor de uma conta Origem para uma conta Destino.
	 * Caso não haja saldo suficiente, o valor não será transferido.
	 * 
	 * @param idContaOrigem conta que terá o valor deduzido
	 * @param valor valor a ser transferido
	 * @param idContaDestino conta que terá o valor acrescido
	 * @return true, se a transferência foi realizada com sucesso.
	 */
	public boolean transfereValor(int idContaOrigem, double valor, int idContaDestino) {
		boolean sucesso = false;
		
		ContaCorrente contaOrigem = pesquisaConta(idContaOrigem);
		ContaCorrente contaDestino = pesquisaConta(idContaDestino);
		
		if (contaOrigem != null && contaDestino != null) {
			// Verificação de saldo comentada no código original - mantendo assim
			// if(contaOrigem.getSaldo() >= valor){
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				sucesso = true;
			// }
		}
	
		return sucesso;
	}

	/**
	 * Realiza um depósito em uma conta específica.
	 * @param idConta ID da conta que receberá o depósito
	 * @param valor valor a ser depositado
	 * @return true se o depósito foi realizado com sucesso
	 */
	public boolean depositar(int idConta, double valor) {
		ContaCorrente conta = pesquisaConta(idConta);
		if (conta != null && valor > 0) {
			conta.setSaldo(conta.getSaldo() + valor);
			return true;
		}
		return false;
	}

	/**
	 * Realiza um saque em uma conta específica.
	 * @param idConta ID da conta que terá o saque
	 * @param valor valor a ser sacado
	 * @return true se o saque foi realizado com sucesso
	 */
	public boolean sacar(int idConta, double valor) {
		ContaCorrente conta = pesquisaConta(idConta);
		if (conta != null && valor > 0 && conta.getSaldo() >= valor) {
			conta.setSaldo(conta.getSaldo() - valor);
			return true;
		}
		return false;
	}
}