package br.com.larimaia.bo;

import br.com.larimaia.dao.EstadoDAO;
import br.com.larimaia.entity.Estado;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Kennedy on 07/12/2015.
 */
@Dependent
public class EstadoBO {

    private EstadoDAO dao = new EstadoDAO();


    public EstadoBO() {
    }

    public void salvar(Estado e){
        dao.Salvar(e);
    }

    public List<Estado> listar() {
        return dao.Listar();
    }

    public void excluir(int c) {
        dao.Excluir(c);
    }

    public Estado Editar(int id) {
        return dao.Editar(id);
    }
}
