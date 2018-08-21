package br.edu.ifcvideira.beans;

public class Vendas {

	Produtos produtoVenda = new Produtos();
	private int qt_vendida_venda;
	private double vl_produto_venda;
	
	public double getVl_produto_venda() {
		return vl_produto_venda;
	}
	public void setVl_produto_venda(double vl_produto_venda) {
		this.vl_produto_venda = vl_produto_venda;
	}
	public int getQt_vendida_venda() {
		return qt_vendida_venda;
	}
	public void setQt_vendida_venda(int qt_vendida_venda) {
		this.qt_vendida_venda = qt_vendida_venda;
	}
	public Produtos getProdutoVenda() {
		return produtoVenda;
	}
	public void setProdutoVenda(Produtos produtoVenda) {
		this.produtoVenda = produtoVenda;
	}
	
}
