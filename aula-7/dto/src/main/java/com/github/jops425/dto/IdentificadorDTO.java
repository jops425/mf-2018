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
import com.github.jops425.dto.collections.Identificadores;
import com.github.jops425.dto.models.Identificador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Classe IdentificadorDTO.
 *
 * @author aluno
 *
 */
public class IdentificadorDTO {

    /**
     * Método fromJson.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de identificadores.
     */
    public final Identificadores fromJson(final String arquivo) {
        Gson gson = new Gson();
        Identificadores coms = gson.fromJson(arquivo, Identificadores.class);
        return coms;
    }

    /**
     * Método toJson.
     *
     * @param idens Lista de identificadores.
     * @param caminho Caminho do arquivo.
     */
    public final void toJson(
            final Identificadores idens, final String caminho) {
        try (Writer writer = new FileWriter(caminho)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(idens, writer);
        } catch (Exception e) { }
    }

    /**
     * Método fromXML.
     *
     * @param arquivo Caminho do arquivo.
     * @return Lista de identificadores.
     * @throws FileNotFoundException Exceção.
     * @throws JAXBException Exceção.
     */
    public final Identificadores fromXML(final String arquivo)
            throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Identificadores.class);
        Unmarshaller un = context.createUnmarshaller();
        Identificadores inds = (Identificadores)
                un.unmarshal(new FileReader(arquivo));
        return inds;
    }

    /**
     * Método toXML.
     *
     * @param id1 Objeto Identificador.
     * @throws JAXBException Exceção.
     */
    public final void toXML(final Identificador id1) throws JAXBException {
        ArrayList<Identificador> idn = new ArrayList<Identificador>();
        idn.add(id1);
        Identificadores idns = new Identificadores();
        idns.setIdentificadores(idn);
        JAXBContext context = JAXBContext.newInstance(Comunicacoes.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(idns, System.out);
    }

}
