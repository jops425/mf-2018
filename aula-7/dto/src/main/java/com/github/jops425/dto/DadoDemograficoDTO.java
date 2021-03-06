package com.github.jops425.dto;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.jops425.dto.collections.Comunicacoes;
import com.github.jops425.dto.collections.Dados;
import com.github.jops425.dto.models.DadoDemografico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe DadoDemograficoDTO.
 *
 * @author joaopedro
 *
 */
public class DadoDemograficoDTO {

    /**
     * Método fromJson.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de Dados.
     */
    public final Dados fromJson(final String arquivo) {
        Gson gson = new Gson();
        Dados dados = gson.fromJson(arquivo, Dados.class);
        return dados;
    }

    /**
     * Método toJson.
     *
     * @param dados Lista de Dados.
     * @param caminho Caminho do arquivo.
     */
    public final void toJson(final Dados dados, final String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(dados, writer);
        } catch (Exception e) { }
    }

    /**
     * Método fromXML.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de dados.
     * @throws FileNotFoundException Exceção.
     * @throws JAXBException Exceção.
     */
    public final Dados fromXML(final String arquivo)
            throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Comunicacoes.class);
        Unmarshaller un = context.createUnmarshaller();
        Dados dados = (Dados) un.unmarshal(new FileReader(arquivo));
        return dados;
    }

    /**
     * Método toXML.
     * @param d1 Objeto DadoDemografico.
     * @throws JAXBException Exceção.
     */
    public final void toXML(final DadoDemografico d1) throws JAXBException {
        ArrayList<DadoDemografico> dado = new ArrayList<DadoDemografico>();
        dado.add(d1);
        Dados dados = new Dados();
        dados.setDados(dado);
        JAXBContext context = JAXBContext.newInstance(Comunicacoes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(dados, System.out);
    }

}
