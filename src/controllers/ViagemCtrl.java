/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CidadeDAO;
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
    public void visualizarViagemSelecionada(Viagem viagem, javax.swing.JTable viagemSelectedRow) {        
        String[] cabecalho = {"Id", "DataSaída", "DataChegada", "CidadeOrigem", "CidadeChegada", "Valor"};
        String[][] dados = {
            {
                viagem.getId().toString(),
                viagem.getSaida().toString(),
                viagem.getChegada().toString(),
                viagem.getCidadeByCidadeOrigemId().getNome(),
                viagem.getCidadeByCidadeDestinoId().getNome(),
                Float.toString(viagem.getValor())
            }
        };

        viagemSelectedRow.setModel(new DefaultTableModel(dados, cabecalho));
    }
    
    public void visualizarEscalasViagem(Viagem viagem, javax.swing.JTable escalasTable) {
        Set<Escala> escalas = viagem.getEscalas();
        
        String[] cabecalho = {"Modal", "DataSaída", "DataChegada", "CidadeOrigem", "CidadeChegada"};
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

        escalasTable.setModel(new DefaultTableModel(dados, cabecalho));       
    }
    
    public void displayViagens(List<Viagem> listaViagens, javax.swing.JTable table) {        
        String[] cabecalho = {"Id", "DataSaída", "DataChegada", "CidadeOrigem", "CidadeChegada", "Valor"};
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
        table.setModel(new DefaultTableModel(dados, cabecalho));

    }
}
