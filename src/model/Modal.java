package model;
// Generated Mar 2, 2016 5:55:12 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Modal generated by hbm2java
 */
public class Modal  implements java.io.Serializable {


     private Integer idModal;
     private Transportadora transportadora;
     private String tipoModal;
     private Integer capacidade;
     private String modelo;
     private Date anoFab;
     private Boolean manutencao;
     private Integer vagasDisponiveis;
     private Set escalas = new HashSet(0);

    public Modal() {
    }

    public Modal(Transportadora transportadora, String tipoModal, Integer capacidade, String modelo, Date anoFab, Boolean manutencao, Integer vagasDisponiveis, Set escalas) {
       this.transportadora = transportadora;
       this.tipoModal = tipoModal;
       this.capacidade = capacidade;
       this.modelo = modelo;
       this.anoFab = anoFab;
       this.manutencao = manutencao;
       this.vagasDisponiveis = vagasDisponiveis;
       this.escalas = escalas;
    }
   
    public Integer getIdModal() {
        return this.idModal;
    }
    
    public void setIdModal(Integer idModal) {
        this.idModal = idModal;
    }
    public Transportadora getTransportadora() {
        return this.transportadora;
    }
    
    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }
    public String getTipoModal() {
        return this.tipoModal;
    }
    
    public void setTipoModal(String tipoModal) {
        this.tipoModal = tipoModal;
    }
    public Integer getCapacidade() {
        return this.capacidade;
    }
    
    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Date getAnoFab() {
        return this.anoFab;
    }
    
    public void setAnoFab(Date anoFab) {
        this.anoFab = anoFab;
    }
    public Boolean getManutencao() {
        return this.manutencao;
    }
    
    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }
    public Integer getVagasDisponiveis() {
        return this.vagasDisponiveis;
    }
    
    public void setVagasDisponiveis(Integer vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }
    public Set getEscalas() {
        return this.escalas;
    }
    
    public void setEscalas(Set escalas) {
        this.escalas = escalas;
    }




}


