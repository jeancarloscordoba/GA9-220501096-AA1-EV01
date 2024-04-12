package Controlador;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistanceController implements Serializable {

    public static EntityManagerFactory emf = null;
    public static EntityManager em = null;
    public static String puName = "SistemaVentasTaniaSoftPU";

    public static void makeEntitiMF() throws RuntimeException {
        try {
            emf = Persistence.createEntityManagerFactory(puName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    public static void closeEntitiMF() {
        if (emf != null) {
            if (emf.isOpen()) {
                emf.close();
            }
        }

    }

    public static void initEM() {
        makeEntitiMF();
        em = emf.createEntityManager();
    }

    public PersistanceController() {
        makeEntitiMF();
    }

    //Listar Clientes
    public static <T> List<T> buscarPorClase(Class<T> clase) {
        initEM();
        List<T> lista = null;
        try {
            em.getTransaction().begin();
            lista = em.createQuery("select p from " + clase.getSimpleName() + " p").getResultList();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
            emf.close();
            return lista;
        }
        //return lista;
    }
    
    
    /***************OPERACIONES CRUD*********************/
    //Guardar Cliente (CREATE)
    public static <T> boolean guardar(T entidad) {
        initEM();
        try {
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Actualizar Cliente (UPDATE)    
    public static <T> boolean actualizar(T entidad) { //AUTOR: Señor Tomas 
        initEM();
        em.getTransaction().begin();
        try {
            em.merge(entidad);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            //em.close();
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    /*public static <T> void actualizarEntidades(T entidadActualizada) {
        initEM();
        try {
            em.getTransaction().begin();
            // Recuperar la entidad existente de la base de datos
            T entidadExistente = (T) em.find(entidadActualizada.getClass(), obtenerId(entidadActualizada));
            // Actualizar los campos de la entidadExistente con los valores de entidadActualizada
            actualizarCampos(entidadExistente, entidadActualizada);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
    
    public static <T> boolean actualizar(T entidadActualizada) {
        initEM();
        try {
            em.getTransaction().begin();
            //em.refresh(entidadActualizada);
            actualizarEntidades(entidadActualizada); // Llamar al método genérico para preparar la entidad actualizada
            em.merge(entidadActualizada); // Realizar la operación de merge con la entidad actualizada
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }

    private static <T> Serializable obtenerId(T entidad) {
        try {
            Method getIdMethod = entidad.getClass().getMethod("getId");
            return (Serializable) getIdMethod.invoke(entidad);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static <T> void actualizarCampos(T entidadExistente, T entidadActualizada) throws IllegalAccessException {
        Field[] campos = entidadActualizada.getClass().getDeclaredFields();
        for (Field campo : campos) {
            campo.setAccessible(true);
            Object valor = campo.get(entidadActualizada);
            if (valor != null) {
                campo.set(entidadExistente, valor);
            }
        }
    }*/
    
    //Buscar Cliente por Id (Usado para editar un cliente) (READ: Leer o Consultar)
    public static <T> Object buscarPorId(Class<T> clase, int id) {
        initEM();
        try {
            em.getTransaction().begin();
            return em.find(clase, id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Eliminar Cliente por Id (DELETE)
    public static <T> boolean eliminarPorId(int id, Class<T> clase) {
        initEM();
        try {
            em.getTransaction().begin();
            T objeto = em.find(clase, id);
            if (objeto != null) {
                em.remove(objeto);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
    
}
