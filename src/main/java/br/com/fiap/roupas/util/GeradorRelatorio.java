package br.com.fiap.roupas.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.fiap.roupas.roupasfiap.model.Cliente;
import br.com.fiap.roupas.roupasfiap.model.Empresa;
import br.com.fiap.roupas.roupasfiap.model.Item;
import br.com.fiap.roupas.roupasfiap.model.Pedido;


public class GeradorRelatorio {

	private int numeroitem = 0;
	private int qtdpedido = 0;
	
	public void gerarCupom(Pedido pedido) {
		Document document =  new  Document();
		
		try {
			PdfWriter write = PdfWriter.getInstance(document, new FileOutputStream("C:\\relatorios\\relatorioPedido"));
			document.open();
			
			document.add(new Paragraph("                          " + pedido.getEmpresa().getNome() + "                     "));
			document.add(new Paragraph("                          " + pedido.getEmpresa().getEndereco() + "                 "));
			document.add(new Paragraph("                              SÃO PAULO / SP                    "));
			document.add(new Paragraph("                                                                                    "));
	
			document.add(new Paragraph("CNPJ: " + pedido.getEmpresa().getCpnj()));			
			document.add(new Paragraph("IE: " + pedido.getEmpresa().getIncricaoEstadual()));
			document.add(new Paragraph("IM: " + pedido.getEmpresa().getInscricaoMunicipal()));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));
			document.add(new Paragraph(pedido.getDataPedido() + "CCF: 010333" +                     "COO: 123456"));
			document.add(new Paragraph("                                                                                    "));
			document.add(new Paragraph("CUPOM FISCAL"));
			document.add(new Paragraph("                                                                                    "));
			document.add(new Paragraph("ITEM   CODIGO   DESCRIÇÃO    QTD.  UN.    VL UNIT(R$)  ST  VL  ITEM(R$)"));
			document.add(new Paragraph("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));
			
			
			pedido.getProdutoList().entrySet().forEach(item -> {
			    //System.out.println("Key : " + entry.getKey(). + " Value : " + entry.getValue());
			    try {
					document.add(new Paragraph(numeroitem + "  " + item.getKey().getId() + "  " +  item.getKey().getDescricao() +
													"  " + item.getValue() + "   " + item.getKey().getValor()));
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}); 
			
			pedido.getProdutoList().forEach((key, value) -> {
				numeroitem++;
				
			});
			
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Empresa empresafake = new Empresa(); 
		Cliente clientefake =  new Cliente();
		Pedido pedidofake = new Pedido();
		Item item1 =  new Item();
		Item item2 =  new Item();
		
		Map<Item,Double> itens =  new HashMap<Item,Double>();
				
		clientefake.setCpf("999.999.999-99");
		clientefake.setNome("Zé Pelintram");
		
		empresafake.setCpnj("999.999.999/0001-99");
		empresafake.setNome("Bugigangas Ltda");
		empresafake.setEndereco("Rua do Zé Ruela");
		empresafake.setIncricaoEstadual("11.1111.111-99");
		empresafake.setInscricaoMunicipal("11.1111.111-99");
		
		item1.setDescricao("Celular Iphone");
		item1.setValor(new BigDecimal(800.00));
		
		item2.setDescricao("Celular Iphone");
		item2.setValor(new BigDecimal(800.00));	
		
		itens.put(item1, 2d);
		itens.put(item2, 4d);
		
		pedidofake.setCco(123456L);				
	}

}
