
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente") //Esta entidad Cliente se utiliza para crear las variables y las acciones del sistema (en la parte de Cliente) que la base de datos almacenara. (Atributos y metodos)
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="IdCliente")
    int id; //Este es la variable para el id de la tabla Cliente en el BD. 
    @Column(name="Dni")
    String dni;
    @Column(name="Nombres")
    String nom;
    @Column(name="Telefono")
    String tel;
    @Column(name="Direccion")
    String dir;
    @Column(name="Estado")
    String estado; 

    public Cliente() {
    }

    public Cliente(int id, String dni, String nom, String tel, String dir, String estado) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.dir = dir;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return this.nom; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

