package br.com.alura.oobj;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ProcessadorXml {

    public ProcessadorXml() {

    }

    public List<ItemPedido> lerItensArquivo (String arquivo){
        try {
        Reader reader = new FileReader(arquivo);
        XmlMapper mapper = new XmlMapper();
        Pedido pedido = mapper.readValue(reader, Pedido.class);
        return pedido.getItens();
      } catch (IOException ex) {
        throw new IllegalStateException(ex);
      }

    }

}
