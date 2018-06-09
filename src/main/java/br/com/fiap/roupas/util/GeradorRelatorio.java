package br.com.fiap.roupas.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.fiap.roupas.model.Pedido;

@Service
public class GeradorRelatorio {

	private String extension = ".pdf";

	@Autowired
	private Environment env;

	private AtomicInteger index = new AtomicInteger();

	private StringBuilder getFileName(Pedido pedido) {
		StringBuilder fileName = new StringBuilder();
		fileName.append(pedido.getCoo()).append(extension);
		return fileName;
	}

	public void gerarPdf(Pedido pedido) {
		Document document = new Document();

		try {
			File fileName = new File(env.getProperty("path.coupon") + this.getFileName(pedido));
			if (!new File(fileName.getParent()).exists()) {
				new File(fileName.getParent()).mkdirs();
			}
			PdfWriter.getInstance(document, new FileOutputStream(fileName));
			document.open();

			document.add(new Paragraph("                          						  "
					+ pedido.getEmpresa().getNome() + "                     "));
			document.add(new Paragraph("                                                  "
					+ pedido.getEmpresa().getEndereco() + "                 "));
			document.add(new Paragraph("                              SÃO PAULO / SP                    "));
			document.add(new Paragraph(
					"                                                                                    "));
			document.add(new Paragraph("CNPJ: " + pedido.getEmpresa().getCpnj()));
			document.add(new Paragraph("IE: " + pedido.getEmpresa().getIncricaoEstadual()));
			document.add(new Paragraph("IM: " + pedido.getEmpresa().getInscricaoMunicipal()));
			document.add(new Paragraph(
					"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));
			document.add(new Paragraph(pedido.getDataPedido() + "CCF: 010333" + "COO: 123456"));
			document.add(new Paragraph(
					"                                                                                    "));
			document.add(new Paragraph("CUPOM FISCAL"));
			document.add(new Paragraph(
					"                                                                                    "));
			document.add(new Paragraph("ITEM   CODIGO   DESCRIÇÃO    QTD.  UN.    VL UNIT(R$)  ST  VL  ITEM(R$)"));
			document.add(new Paragraph(
					"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"));

			index.set(1);
			pedido.getProdutoList().entrySet().forEach(item -> {
				try {
					document.add(new Paragraph(
							index.getAndIncrement() + "  " + item.getKey().getId() + "  " + item.getKey().getDescricao()
									+ "  " + item.getValue() + "   " + item.getKey().getValor()));
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			index.set(0);

		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
	}

}
