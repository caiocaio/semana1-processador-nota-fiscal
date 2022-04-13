package br.com.alura.oobj;

import java.math.BigDecimal;
import java.util.List;


public class Main {

  public static void main(String[] args) {
    if (args.length <= 0) {
      throw new IllegalArgumentException("Forneça um nome de arquivo.");
    }

    String arquivo = args[0];

    ArquivoParser arquivoParser = new ArquivoParser();

    List<ItemPedido> itensPedido = arquivoParser.listarItensPedido(arquivo);


    BigDecimal totalPedido = BigDecimal.ZERO;
    for (ItemPedido itemPedido : itensPedido) {
      BigDecimal subtotal = itemPedido.getValorUnitario().multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
      totalPedido = totalPedido.add(subtotal);
    }

    SubTotalPorClasseFiscal subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();
    for (ItemPedido itemPedido : itensPedido) {
      BigDecimal novoSubTotal = itemPedido.getValorUnitario().multiply(BigDecimal.valueOf(itemPedido.getQuantidade()));
      String classeFiscal = itemPedido.getClasseFiscal();
      BigDecimal subTotal = subTotalPorClasseFiscal.get(classeFiscal);
      if (subTotal != null) {
        subTotalPorClasseFiscal.put(classeFiscal, subTotal.add(novoSubTotal));
      } else {
        subTotalPorClasseFiscal.put(classeFiscal, novoSubTotal);
      }
    }

    System.out.println("## Total do pedido: " + totalPedido);
    System.out.println("\n## Subtotal por classe fiscal");
    for (String classeFiscal : subTotalPorClasseFiscal.keySet()) {
      System.out.println("\n\tClasse fiscal: " + classeFiscal);
      BigDecimal subtotal = subTotalPorClasseFiscal.get(classeFiscal);
      System.out.println("\tSubtotal: " + subtotal);
    }


  }

}
