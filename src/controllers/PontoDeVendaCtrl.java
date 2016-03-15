package controllers;

import daos.PontoDeVendaDAO;
import VVV.ErroValidacao;
import VVV.MensagemValidacao;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.validation.Validation;
import javax.validation.Validator;
import model.Pontodevenda;

public class PontoDeVendaCtrl {
    private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();
    
    public static Pontodevenda encontrarPontoDeVendaPorCnpj(String cnpj) {
        List query = PontoDeVendaDAO.encontrarPontoDeVendaPorCnpj(cnpj);
        return query == null? null : (Pontodevenda)(query.get(0));
    }
    
    public static boolean verificarExistenciaPontoDeVenda(String cnpj) {
        List resultList = PontoDeVendaDAO.encontrarPontoDeVendaPorCnpj(cnpj);
        return !(resultList != null && resultList.isEmpty());
    }
    
    public static void cadastrarPontoDeVenda(String nome, String cnpj, String telefone, String endereco) throws ErroValidacao {
        Pontodevenda pontodevenda = new Pontodevenda(endereco, nome, cnpj, telefone);
        
        MensagemValidacao.assertValidacao(VALIDATOR.validate(pontodevenda));
        
        if(PontoDeVendaCtrl.verificarExistenciaPontoDeVenda(cnpj)){
            MensagemValidacao.Cnpj.throwErroValidacao("Unico");
        }
        
        PontoDeVendaDAO.salvar(pontodevenda);
    }
    
    public static DefaultComboBoxModel<String> comboBoxDePontosDeVendas(){
        List l = PontoDeVendaDAO.pegarListaDePontosDeVendas();
        if(l == null || l.isEmpty()){
            return null;
        }
        
        return PontoDeVendaCtrl.construirComboBoxViagem(l);
    }
    
    private static DefaultComboBoxModel<String> construirComboBoxViagem(List<Pontodevenda> listaPontoDeVenda) {      
        String[] dados = new String[listaPontoDeVenda.size()];

        int counter = 0;
        for (Pontodevenda pontoDeVenda : listaPontoDeVenda) {            
            dados[counter] = String.format("%s - %s", pontoDeVenda.getNome(), pontoDeVenda.getEndereco());
                        
            counter++;            
        }
        
        return new DefaultComboBoxModel<>(dados);
    }
}
