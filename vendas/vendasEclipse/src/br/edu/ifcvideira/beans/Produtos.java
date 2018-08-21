package br.edu.ifcvideira.beans;

public class Produtos {

	private int cd_produto;
	private String nm_produto;
	private double vl_produto;
	private int qt_estoque_produto;
	
	public int getQt_estoque_produto() {
		return qt_estoque_produto;
	}
	public void setQt_estoque_produto(int qt_estoque_produto) {
		this.qt_estoque_produto = qt_estoque_produto;
	}
	public int getCd_produto() {
		return cd_produto;
	}
	public void setCd_produto(int cd_produto) {
		this.cd_produto = cd_produto;
	}
	public String getNm_produto() {
		return nm_produto;
	}
	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}
	public double getVl_produto() {
		return vl_produto;
	}
	public void setVl_produto(double vl_produto) {
		this.vl_produto = vl_produto;
	}
	
}
