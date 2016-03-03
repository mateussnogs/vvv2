/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CidadeDAO;
import daos.EscalaDAO;
import daos.ModalDAO;
import daos.ViagemDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.Escala;
import model.Viagem;

/**
 *
 * @author mateus
 */
public class ViagemCtrl {
    //True se todos os modais da viagem tiverem pelo menos 1 vaga
    //False caso contrário.
    public boolean checkVagasDisponiveis(int viagemId) {
        List resultList = ViagemDAO.getVagasTotaisViagem(viagemId);
        if (resultList != null) {            
            for (int i = 0; i < resultList.size(); i++) {
                int vagas = (int)resultList.get(i);
                if (vagas == 0)
                    return false;
            }
        }
        else {
            return false;
        }
        return true;
        
    }
    
    public void displayViagemSelected(Viagem v, javax.swing.JTable viagemSelectedRow) {        
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("IdViagem");
        tableHeaders.add("DataSaída");
        tableHeaders.add("DataChegada");
        tableHeaders.add("CidadeOrigem");
        tableHeaders.add("CidadeChegada");
        tableHeaders.add("Valor");

        Vector<Object> oneRow = new Vector<Object>();
        oneRow.add(v.getId());
        oneRow.add(v.getSaida());
        oneRow.add(v.getChegada());

        oneRow.add(CidadeDAO.getNomeCidadeById(v.getCidadeByCidadeOrigemId().getId()));
        oneRow.add(CidadeDAO.getNomeCidadeById(v.getCidadeByCidadeDestinoId().getId()));
        oneRow.add(v.getValor());
        tableData.add(oneRow);

        viagemSelectedRow.setModel(new DefaultTableModel(tableData, tableHeaders));
        
        //return viagemSelectedRow;
    }
    
    public void displayEscalasViagem(Viagem viagemSelecionada, javax.swing.JTable escalasTable) {
        
        List escalas = EscalaDAO.getEscalasByViagemId(viagemSelecionada.getId());
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Modal");
        tableHeaders.add("DataSaída");
        tableHeaders.add("DataChegada");
        tableHeaders.add("CidadeOrigem");
        tableHeaders.add("CidadeChegada");

        for (Object o : escalas) {
            Escala e = (Escala) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(ModalDAO.getNomeModalById(e.getModal().getIdModal()));
            oneRow.add(e.getSaida());
            oneRow.add(e.getChegada());

            oneRow.add(CidadeDAO.getNomeCidadeById(e.getCidadeByCidadeId().getId()));
            oneRow.add(CidadeDAO.getNomeCidadeById(e.getCidadeByCidadeId1().getId()));
            tableData.add(oneRow);
        }

        escalasTable.setModel(new DefaultTableModel(tableData, tableHeaders));       
    }
    
    public void displayViagens(List resultList, javax.swing.JTable table) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("IdViagem");
        tableHeaders.add("DataSaída");
        tableHeaders.add("DataChegada");
        tableHeaders.add("CidadeOrigem");
        tableHeaders.add("CidadeChegada");
        tableHeaders.add("Valor");

        for (Object o : resultList) {
            Viagem v = (Viagem) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(v.getId());
            oneRow.add(v.getSaida());
            oneRow.add(v.getChegada());

            oneRow.add(CidadeDAO.getNomeCidadeById(v.getCidadeByCidadeOrigemId().getId()));
            oneRow.add(CidadeDAO.getNomeCidadeById(v.getCidadeByCidadeDestinoId().getId()));
            oneRow.add(v.getValor());
            tableData.add(oneRow);

        }
        table.setModel(new DefaultTableModel(tableData, tableHeaders));

    }
}
