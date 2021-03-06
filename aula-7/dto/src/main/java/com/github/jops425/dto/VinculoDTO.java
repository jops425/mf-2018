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

import com.github.jops425.dto.collections.Vinculos;
import com.github.jops425.dto.models.Vinculo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe VinculoDTO.
 *
 * @author aluno
 *
 */
public class VinculoDTO {

    /**
     * Método fromJson.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de vínculos.
     */
    public final Vinculos fromJson(final String arquivo) {
        Gson gson = new Gson();
        Vinculos vinculos = gson.fromJson(arquivo, Vinculos.class);
        return vinculos;
    }

    /**
     * Método toJson.
     *
     * @param vincs Lista de vínculos.
     * @param caminho Caminho do arquivo.
     */
    public final void toJson(
            final Vinculos vincs, final String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(vincs, writer);
        } catch (Exception e) { }
    }

    /**
     * Método fromXML.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de vínculos.
     * @throws FileNotFoundException Exceção.
     * @throws JAXBException Exceção.
     */
    public final Vinculos fromXML(final String arquivo)
            throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Vinculos.class);
        Unmarshaller un = context.createUnmarshaller();
        Vinculos vinculos = (Vinculos) un.unmarshal(new FileReader(arquivo));
        return vinculos;
    }

    /**
     * Método toXML.
     *
     * @param v1 Objeto de Vinculo.
     * @throws JAXBException Exceção.
     */
    public final void toXML(final Vinculo v1) throws JAXBException {
        ArrayList<Vinculo> vinculo = new ArrayList<Vinculo>();
        vinculo.add(v1);
        Vinculos vinculos = new Vinculos();
        vinculos.setVincs(vinculo);
        JAXBContext context = JAXBContext.newInstance(Vinculos.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(vinculos, System.out);
    }

}
