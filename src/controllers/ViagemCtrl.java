/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.ViagemDAO;
import java.util.List;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import model.Escala;
import model.Viagem;

/**
 *
 * @author mateus
 */
public class ViagemCtrl {    
    public DefaultTableModel tabelaDeViagens(){
        return this.construirTabelaViagem(ViagemDAO.pegarListaDeViagens());
    }
    
    private DefaultTableModel construirTabelaEscala(Viagem viagem) {
        Set<Escala> escalas = viagem.getEscalas();
        
        String[] cabecalho = {"Modal", "Data Saída", "Data Chegada", "Cidade Origem", "Cidade Chegada"};
        String[][] dados = new String[escalas.size()][5];
        
        int counter = 0;
        for (Escala e : escalas) {
            dados[counter][0] = e.getModal().getTipoModal();
            dados[counter][1] = e.getSaida().toString();
            dados[counter][2] = e.getChegada().toString();
            dados[counter][3] = e.getCidadeByCidadeOrigemId().getNome();
            dados[counter][4] = e.getCidadeByCidadeDestinoId().getNome();
            
            counter++;
        }

        return new DefaultTableModel(dados, cabecalho);       
    }
    
    private DefaultTableModel construirTabelaViagem(List<Viagem> listaViagens) {        
        String[] cabecalho = {"Id", "Data Saída", "Data Chegada", "Cidade Origem", "Cidade Chegada", "Valor"};
        String[][] dados = new String[listaViagens.size()][6];

        int counter = 0;
        for (Viagem viagem : listaViagens) {
            dados[counter][0] = viagem.getId().toString();
            dados[counter][1] = viagem.getSaida().toString();
            dados[counter][2] = viagem.getChegada().toString();
            dados[counter][3] = viagem.getCidadeByCidadeOrigemId().getNome();
            dados[counter][4] = viagem.getCidadeByCidadeDestinoId().getNome();
            dados[counter][5] = Float.toString(viagem.getValor());
                        
            counter++;            
        }
        
        return new DefaultTableModel(dados, cabecalho);
    }
}
