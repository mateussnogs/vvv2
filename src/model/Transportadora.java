package model;
// Generated 13-Mar-2016 14:26:24 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Transportadora generated by hbm2java
 */
@Entity
@Table(name="transportadora"
    ,catalog="vvv"
)
public class Transportadora  implements java.io.Serializable {


     private Integer id;
     private String nome;
     private Set<Modal> modals = new HashSet<Modal>(0);

    public Transportadora() {
    }

	
    public Transportadora(String nome) {
        this.nome = nome;
    }
    public Transportadora(String nome, Set<Modal> modals) {
       this.nome = nome;
       this.modals = modals;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nome", nullable=false, length=45)
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="transportadora")
    public Set<Modal> getModals() {
        return this.modals;
    }
    
    public void setModals(Set<Modal> modals) {
        this.modals = modals;
    }




}


