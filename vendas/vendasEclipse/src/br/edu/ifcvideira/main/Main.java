package br.edu.ifcvideira.main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.edu.ifcvideira.beans.Compras;
import br.edu.ifcvideira.beans.Produtos;
import br.edu.ifcvideira.beans.Vendas;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Produtos> p = new ArrayList();
		ArrayList<Vendas> v = new ArrayList();
		ArrayList<Compras> c = new ArrayList();
		
		for (int i = 0; i == 0;) {
			
			int op = Integer.parseInt(JOptionPane.showInputDialog("Digite:\n"
					+ "1- Comprar\n"
					+ "2- Vender\n"
					+ "3- Ver Compras\n"
					+ "4- Ver Vendas\n"
					+ "5- Análise Compras e Vendas\n"
					+ "6- Alterar Preço Produto\n"
					+ "7- Sair\n"));
			
			if (op == 1) {
				
				Produtos prod = new Produtos();
				Compras compra = new Compras();
				
				prod.setCd_produto(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto")));
				
				if (p.size() < prod.getCd_produto()) {
					JOptionPane.showMessageDialog(null, "Produto inexistente, ele será adicionado com o código " + (int) (p.size() + 1));
					prod.setCd_produto(p.size() + 1);
					prod.setNm_produto(JOptionPane.showInputDialog("Digite o nome do produto:\n"));
					prod.setVl_produto(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de venda do produto\n")));
					prod.setQt_estoque_produto(0);
					p.add(prod);
				}
				
				prod = p.get(prod.getCd_produto() - 1);
				
				compra.setProdutoCompra(prod);
				
				compra.setVl_compra(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da compra do produto\n")));
				compra.setQt_comprada_compra(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade comprada\n")));
				
				prod.setQt_estoque_produto(prod.getQt_estoque_produto() + compra.getQt_comprada_compra());
				
				p.set(prod.getCd_produto() - 1, prod);
				c.add(compra);
				
			} else if (op == 2) {
				
				Vendas venda = new Vendas();
				Produtos prodVenda = new Produtos();
				
				prodVenda.setCd_produto(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto:")));
				
				if (p.size() < prodVenda.getCd_produto()) {
					JOptionPane.showMessageDialog(null, "Produto inexistente");
				} else {
					prodVenda = p.get(prodVenda.getCd_produto() - 1);
					venda.setQt_vendida_venda(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade vendida")));
					if (venda.getQt_vendida_venda() > prodVenda.getQt_estoque_produto()) {
						JOptionPane.showMessageDialog(null, "Quantidade indisponível: " + prodVenda.getQt_estoque_produto());
					} else {
						venda.setVl_produto_venda(prodVenda.getVl_produto());
						prodVenda.setQt_estoque_produto(prodVenda.getQt_estoque_produto() - venda.getQt_vendida_venda());
						venda.setProdutoVenda(prodVenda);
						p.set(prodVenda.getCd_produto() - 1, prodVenda);
						v.add(venda);					
					}
				}
				
			} else if (op == 3) {
				
				String valoresCompra = "Compras:";
				for (int j = 0; j < c.size(); j++) {
					valoresCompra += "\n\nCompra: " + (j + 1) + "\n"
							+ "Valor por Unidade: " + c.get(j).getVl_compra() + "\n"
							+ "Quantidade: " + c.get(j).getQt_comprada_compra() + "\n"
							+ "Valor total: " + c.get(j).getVl_compra() * c.get(j).getQt_comprada_compra() + "\n"
							+ "Código do produto: " + c.get(j).getProdutoCompra().getCd_produto() + "\n"
							+ "Nome do produto: " + c.get(j).getProdutoCompra().getNm_produto() + "\n";
				}
				JOptionPane.showMessageDialog(null, valoresCompra);
				
			} else if (op == 4) {
				
				String valoresVenda = "Vendas:";
				for (int j = 0; j < v.size(); j++) {
					valoresVenda += "\n\nVenda: " + (j + 1) + "\n"
							+ "Código do Produto: " + v.get(j).getProdutoVenda().getCd_produto() + "\n"
							+ "Nome do Produto: " + v.get(j).getProdutoVenda().getNm_produto() + "\n"
							+ "Valor Unitário: " + v.get(j).getVl_produto_venda() + "\n"
							+ "Quantidade Comprada: " + v.get(j).getQt_vendida_venda() + "\n"
							+ "Valor total: " + v.get(j).getVl_produto_venda() * v.get(j).getQt_vendida_venda() + "\n";
				}
				JOptionPane.showMessageDialog(null, valoresVenda);
				
			} else if (op == 5) {
				
				double gastos = 0;
				
				for (int j = 0; j < c.size(); j++) {
					gastos += c.get(j).getVl_compra() * c.get(j).getQt_comprada_compra();
				}
				
				double lucroBruto = 0;
				
				for (int j = 0; j < v.size(); j++) {
					lucroBruto += v.get(j).getVl_produto_venda() * v.get(j).getQt_vendida_venda();
				}
				
				String analise = "Gastos: \n"
						+ gastos + "\nGanhos:\n"
								+ lucroBruto + "\nLucro Limpo:\n"
										+ (lucroBruto - gastos);
				
				JOptionPane.showMessageDialog(null, "Análise de vendas:\n" + analise);
				
			} else if (op == 6) {
				
				Produtos prod = new Produtos();
				
				prod.setCd_produto(Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto")));
				
				if (p.size() < prod.getCd_produto()) {
					JOptionPane.showMessageDialog(null, "Produto Inexistente");
				} else {
					prod = p.get(prod.getCd_produto() - 1);
					prod.setVl_produto(Double.parseDouble(JOptionPane.showInputDialog("Digite o novo valor do produto")));
					p.set(prod.getCd_produto() - 1, prod);
				}
				
			} else {
				i = 1;
			}
		
		}
	}
}
