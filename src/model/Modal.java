package model;
// Generated 14-Mar-2016 19:47:15 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Modal generated by hbm2java
 */
@Entity
@Table(name="modal"
    ,catalog="vvv"
)
public class Modal  implements java.io.Serializable {


     private Integer id;
     private Transportadora transportadora;
     private String tipo;
     private int capacidade;
     private String modelo;
     private Date anoFab;
     private boolean manutencao;
     private int vagasDisponiveis;
     private Set<Escala> escalas = new HashSet<Escala>(0);

    public Modal() {
    }

	
    public Modal(Transportadora transportadora, String tipo, int capacidade, String modelo, Date anoFab, boolean manutencao, int vagasDisponiveis) {
        this.transportadora = transportadora;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.anoFab = anoFab;
        this.manutencao = manutencao;
        this.vagasDisponiveis = vagasDisponiveis;
    }
    public Modal(Transportadora transportadora, String tipo, int capacidade, String modelo, Date anoFab, boolean manutencao, int vagasDisponiveis, Set<Escala> escalas) {
       this.transportadora = transportadora;
       this.tipo = tipo;
       this.capacidade = capacidade;
       this.modelo = modelo;
       this.anoFab = anoFab;
       this.manutencao = manutencao;
       this.vagasDisponiveis = vagasDisponiveis;
       this.escalas = escalas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Transportadora_id", nullable=false)
    public Transportadora getTransportadora() {
        return this.transportadora;
    }
    
    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    
    @Column(name="tipo", nullable=false)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="capacidade", nullable=false)
    public int getCapacidade() {
        return this.capacidade;
    }
    
    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    
    @Column(name="modelo", nullable=false)
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="ano_fab", nullable=false, length=10)
    public Date getAnoFab() {
        return this.anoFab;
    }
    
    public void setAnoFab(Date anoFab) {
        this.anoFab = anoFab;
    }

    
    @Column(name="manutencao", nullable=false)
    public boolean isManutencao() {
        return this.manutencao;
    }
    
    public void setManutencao(boolean manutencao) {
        this.manutencao = manutencao;
    }

    
    @Column(name="vagasDisponiveis", nullable=false)
    public int getVagasDisponiveis() {
        return this.vagasDisponiveis;
    }
    
    public void setVagasDisponiveis(int vagasDisponiveis) {
        this.vagasDisponiveis = vagasDisponiveis;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="modal")
    public Set<Escala> getEscalas() {
        return this.escalas;
    }
    
    public void setEscalas(Set<Escala> escalas) {
        this.escalas = escalas;
    }




}


