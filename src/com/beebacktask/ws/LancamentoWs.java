package com.beebacktask.ws;

import java.util.ArrayList;

import com.beebacktask.model.Lancamento;

public class LancamentoWs {

	private static ArrayList<Lancamento> lstTarefas;

	public static ArrayList<Lancamento> getLstTarefas() {
		if(lstTarefas == null)
			lstTarefas = new ArrayList<Lancamento>();
		
		return lstTarefas;
	}
	
	public static void carregarLancamento(){
		/**
		 * Será implementado a consulta via web service.
		 */
		
		if(lstTarefas == null){
			Lancamento l1 = new Lancamento();
			l1.setLancamentoId(1);
			l1.setDsTitulo("Tarefa 1");
			l1.setDtTarefaFim("hoje");
			l1.setIcPrioridade("");
			getLstTarefas().add(l1);
			
			Lancamento l2 = new Lancamento();
			l2.setLancamentoId(2);
			l2.setDsTitulo("Tarefa 2");
			l2.setDtTarefaFim("hoje");
			l2.setIcPrioridade("1");
			getLstTarefas().add(l2);
			
			Lancamento l3 = new Lancamento();
			l3.setLancamentoId(3);
			l3.setDsTitulo("Tarefa 3");
			l3.setIcPrioridade("2");
			l3.setDtTarefaFim("amanhã");
			getLstTarefas().add(l3);
			
			Lancamento l4 = new Lancamento();
			l4.setLancamentoId(4);
			l4.setDsTitulo("Tarefa 4");
			l4.setIcPrioridade("2");
			l4.setDtTarefaFim("15 março");
			getLstTarefas().add(l4);
		}
	}
	
	public static boolean inserirTarefa(Lancamento l){
		/*
		 * Será inserido a inserção via web service
		 */
		getLstTarefas().add(l);
		
		return true;
	}
	public static boolean removerTarefa(int lancamentoId, int listPosition){
		/*
		 * Será inserido a remoção via web service
		 */
		
		getLstTarefas().remove(listPosition);
		
		return true;
	}
	
}
