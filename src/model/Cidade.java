package model;
// Generated Mar 2, 2016 5:55:12 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cidade generated by hbm2java
 */
public class Cidade  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private String uf;
     private String pais;
     private Set viagemsForCidadeDestinoId = new HashSet(0);
     private Set viagemsForCidadeOrigemId = new HashSet(0);
     private Set escalasForCidadeId1 = new HashSet(0);
     private Set escalasForCidadeId = new HashSet(0);

    public Cidade() {
    }

    public Cidade(String nome, String uf, String pais, Set viagemsForCidadeDestinoId, Set viagemsForCidadeOrigemId, Set escalasForCidadeId1, Set escalasForCidadeId) {
       this.nome = nome;
       this.uf = uf;
       this.pais = pais;
       this.viagemsForCidadeDestinoId = viagemsForCidadeDestinoId;
       this.viagemsForCidadeOrigemId = viagemsForCidadeOrigemId;
       this.escalasForCidadeId1 = escalasForCidadeId1;
       this.escalasForCidadeId = escalasForCidadeId;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(String uf) {
        this.uf = uf;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Set getViagemsForCidadeDestinoId() {
        return this.viagemsForCidadeDestinoId;
    }
    
    public void setViagemsForCidadeDestinoId(Set viagemsForCidadeDestinoId) {
        this.viagemsForCidadeDestinoId = viagemsForCidadeDestinoId;
    }
    public Set getViagemsForCidadeOrigemId() {
        return this.viagemsForCidadeOrigemId;
    }
    
    public void setViagemsForCidadeOrigemId(Set viagemsForCidadeOrigemId) {
        this.viagemsForCidadeOrigemId = viagemsForCidadeOrigemId;
    }
    public Set getEscalasForCidadeId1() {
        return this.escalasForCidadeId1;
    }
    
    public void setEscalasForCidadeId1(Set escalasForCidadeId1) {
        this.escalasForCidadeId1 = escalasForCidadeId1;
    }
    public Set getEscalasForCidadeId() {
        return this.escalasForCidadeId;
    }
    
    public void setEscalasForCidadeId(Set escalasForCidadeId) {
        this.escalasForCidadeId = escalasForCidadeId;
    }




}


