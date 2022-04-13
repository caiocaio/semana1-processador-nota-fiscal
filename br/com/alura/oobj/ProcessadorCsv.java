package br.com.alura.oobj;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ProcessadorCsv {

    public ProcessadorCsv() {

    }
    public List<ItemPedido> lerItensArquivo(String arquivo) {
        try {
            Reader reader = new FileReader(arquivo);
            CsvToBean<ItemPedido> csvToBean = new CsvToBeanBuilder<ItemPedido>(reader)
                    .withSeparator(';')
                    .withType(ItemPedido.class)
                    .build();
            return  csvToBean.parse();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }

}

