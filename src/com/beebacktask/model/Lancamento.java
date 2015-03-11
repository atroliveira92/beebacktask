package com.beebacktask.model;
import java.io.Serializable;

public class Lancamento implements Serializable{
	
	private int LancamentoId;
	private int UserId;
	private int LancamentoSubNivelId;
	private String DsTitulo;
	private String DsTextoDetalhado;
	private String DtLancamento;
	private String HrLancamento;
	public boolean isIcSelected() {
		return IcSelected;
	}
	public void setIcSelected(boolean icSelected) {
		IcSelected = icSelected;
	}
	private boolean IcAtivo;
	private boolean IcSelected;
	
	private int MensagensNaoVisualizadas;
	
	public int getLancamentoId() {
		return LancamentoId;
	}
	public void setLancamentoId(int lancamentoId) {
		LancamentoId = lancamentoId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getLancamentoSubNivelId() {
		return LancamentoSubNivelId;
	}
	public void setLancamentoSubNivelId(int lancamentoSubNivelId) {
		LancamentoSubNivelId = lancamentoSubNivelId;
	}
	public String getDsTitulo() {
		return DsTitulo;
	}
	public void setDsTitulo(String dsTitulo) {
		DsTitulo = dsTitulo;
	}
	public String getDsTextoDetalhado() {
		return DsTextoDetalhado;
	}
	public void setDsTextoDetalhado(String dsTextoDetalhado) {
		DsTextoDetalhado = dsTextoDetalhado;
	}
	public String getDtLancamento() {
		return DtLancamento;
	}
	public void setDtLancamento(String dtLancamento) {
		DtLancamento = dtLancamento;
	}
	public String getHrLancamento() {
		return HrLancamento;
	}
	public void setHrLancamento(String hrLancamento) {
		HrLancamento = hrLancamento;
	}
	public boolean isIcAtivo() {
		return IcAtivo;
	}
	public void setIcAtivo(boolean icAtivo) {
		IcAtivo = icAtivo;
	}
	public int getMensagensNaoVisualizadas() {
		return MensagensNaoVisualizadas;
	}
	public void setMensagensNaoVisualizadas(int mensagensNaoVisualizadas) {
		MensagensNaoVisualizadas = mensagensNaoVisualizadas;
	}
	public String getTipoPublicacao() {
		return TipoPublicacao;
	}
	public void setTipoPublicacao(String tipoPublicacao) {
		TipoPublicacao = tipoPublicacao;
	}
	public String getTipoPublicacaoCaminhoImg() {
		return TipoPublicacaoCaminhoImg;
	}
	public void setTipoPublicacaoCaminhoImg(String tipoPublicacaoCaminhoImg) {
		TipoPublicacaoCaminhoImg = tipoPublicacaoCaminhoImg;
	}
	public int getComentariosNaoVisualizados() {
		return ComentariosNaoVisualizados;
	}
	public void setComentariosNaoVisualizados(int comentariosNaoVisualizados) {
		ComentariosNaoVisualizados = comentariosNaoVisualizados;
	}
	public int getTipo() {
		return Tipo;
	}
	public void setTipo(int tipo) {
		Tipo = tipo;
	}
	public int getUserIdResponsavel() {
		return UserIdResponsavel;
	}
	public void setUserIdResponsavel(int userIdResponsavel) {
		UserIdResponsavel = userIdResponsavel;
	}
	public String getDtTarefaInicio() {
		return DtTarefaInicio;
	}
	public void setDtTarefaInicio(String dtTarefaInicio) {
		DtTarefaInicio = dtTarefaInicio;
	}
	public String getDtTarefaFim() {
		return DtTarefaFim;
	}
	public void setDtTarefaFim(String dtTarefaFim) {
		DtTarefaFim = dtTarefaFim;
	}
	public String getDtModificado() {
		return DtModificado;
	}
	public void setDtModificado(String dtModificado) {
		DtModificado = dtModificado;
	}
	public String getIcStatus() {
		return IcStatus;
	}
	public void setIcStatus(String icStatus) {
		IcStatus = icStatus;
	}
	public String getDtStatus() {
		return DtStatus;
	}
	public void setDtStatus(String dtStatus) {
		DtStatus = dtStatus;
	}
	public String getDsTextoDetalhadoStatus() {
		return DsTextoDetalhadoStatus;
	}
	public void setDsTextoDetalhadoStatus(String dsTextoDetalhadoStatus) {
		DsTextoDetalhadoStatus = dsTextoDetalhadoStatus;
	}
	public String getDtAgendamentoAlerta() {
		return DtAgendamentoAlerta;
	}
	public void setDtAgendamentoAlerta(String dtAgendamentoAlerta) {
		DtAgendamentoAlerta = dtAgendamentoAlerta;
	}
	public String getIcPrioridade() {
		return IcPrioridade;
	}
	public void setIcPrioridade(String icPrioridade) {
		IcPrioridade = icPrioridade;
	}
	public boolean isIcCompartilhaGrupo() {
		return IcCompartilhaGrupo;
	}
	public void setIcCompartilhaGrupo(boolean icCompartilhaGrupo) {
		IcCompartilhaGrupo = icCompartilhaGrupo;
	}
	public String getNmUsuario() {
		return NmUsuario;
	}
	public void setNmUsuario(String nmUsuario) {
		NmUsuario = nmUsuario;
	}
	public String getNmUsuarioResponsavel() {
		return NmUsuarioResponsavel;
	}
	public void setNmUsuarioResponsavel(String nmUsuarioResponsavel) {
		NmUsuarioResponsavel = nmUsuarioResponsavel;
	}
	public int getIsDateLate() {
		return IsDateLate;
	}
	public void setIsDateLate(int isDateLate) {
		IsDateLate = isDateLate;
	}
	private String TipoPublicacao;
	private String TipoPublicacaoCaminhoImg;
	private int ComentariosNaoVisualizados;
	private int Tipo;
	private int UserIdResponsavel;
	private String DtTarefaInicio;
	private String DtTarefaFim;
	private String DtModificado;
	private String IcStatus;
	private String DtStatus;
	private String DsTextoDetalhadoStatus;
	private String DtAgendamentoAlerta;
	private String IcPrioridade;
	private boolean IcCompartilhaGrupo;
	private String NmUsuario;
    private String NmUsuarioResponsavel;
    private int IsDateLate;

}