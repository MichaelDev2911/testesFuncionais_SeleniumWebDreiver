package pages;

import core.BasePage;

public class MovimentacaoPage extends BasePage {

	public void setDataMovimentacao(String data) {
		escrever("data_transacao", data);
	}
	
	public void setDataPagamento(String data) {
		escrever("data_pagamento", data);
	}
	
	public void setDescricao(String descricao) {
		escrever("descricao", descricao);
	}
	
	public void setInteressado(String interessado) {
		escrever("interessado", interessado);
	}
	
	public void setValor(String valor) {
		escrever("valor", valor);
	}
	
	public void setConta(String conta) {
		selecionarCombo("conta", conta);
	}
}
