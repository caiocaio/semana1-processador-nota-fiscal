package br.com.alura.oobj;

import java.util.List;

public class ArquivoParser {

private ProcessadorXml processadorXML;
private ProcessadorCsv processadorCSV;

    public ArquivoParser() {
        this.processadorXML = new ProcessadorXml();
        this.processadorCSV = new ProcessadorCsv();
    }

    public  List<ItemPedido> listarItensPedido(String arquivo){

        if(arquivo.endsWith(".csv")){
            return this.processadorCSV.lerItensArquivo(arquivo);
        }else if(arquivo.endsWith(".xml")){
            return this.processadorXML.lerItensArquivo(arquivo);
        }else{
            throw new IllegalArgumentException("Formato de arquivo inválido: " + arquivo);
        }
    }




}
