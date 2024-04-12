
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public class Empleado implements Serializable { //Esta clase Empleado se utiliza para crear las variables y las acciones del sistema (en la parte de Empleado) que la base de datos almacenara. (Atributos y metodos)

    @Id    
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="IdEmpleado")
    int id; //Este es la variable para el id de la tabla Empleado en el BD. 
    @Column(name="Dni")
    String dni;
    @Column(name="Nombres")
    String nom;
    @Column(name="Telefono")
    String tel;
    @Column(name="Estado")
    String estado;
    @Column(name="User")
    String user; 
    
    public Empleado() {
    }

    public Empleado(int id, String dni, String nom, String tel, String estado, String user) {
        this.id = id;
        this.dni = dni;
        this.nom = nom;
        this.tel = tel;
        this.estado = estado;
        this.user = user;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    /*@Override
    public String toString() {
        return this.nom; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }*/
    
}
