package Modelo;

import Controlador.PersistanceController;
import java.util.List;

public class ClienteDAO {

    public ClienteDAO() {

    }

    //Listar Clientes
    public List<Cliente> getListaClientes() {
        return PersistanceController.buscarPorClase(Cliente.class);
    }

    //Guardar Cliente 
    public boolean guardarCliente(Cliente cliente) {
        return PersistanceController.guardar(cliente);
    }

    //Editar Cliente
    public Cliente getEditarCliente(int idCliente) {
        return (Cliente) PersistanceController.buscarPorId(Cliente.class, idCliente);
    }

    //Actualizar Cliente
    public boolean actualizarCliente(Cliente cliente) { 
        return PersistanceController.actualizar(cliente);
    }
   
    //Eliminar Cliente 
    public boolean eliminarCliente(int idCliente) {
        return PersistanceController.<Cliente>eliminarPorId(idCliente, Cliente.class);
    }

}
