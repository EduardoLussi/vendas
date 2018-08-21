package br.edu.ifcvideira.beans;

public class Compras {

	private double vl_compra;
	private int qt_comprada_compra;
	Produtos produtoCompra = new Produtos();
	
	public int getQt_comprada_compra() {
		return qt_comprada_compra;
	}
	public void setQt_comprada_compra(int qt_comprada_compra) {
		this.qt_comprada_compra = qt_comprada_compra;
	}
	public Produtos getProdutoCompra() {
		return produtoCompra;
	}
	public void setProdutoCompra(Produtos produtoCompra) {
		this.produtoCompra = produtoCompra;
	}
	public double getVl_compra() {
		return vl_compra;
	}
	public void setVl_compra(double vl_compra) {
		this.vl_compra = vl_compra;
	}
	
}
