package br.com.larimaia.bo;

import br.com.larimaia.dao.CerimonialDAO;
import br.com.larimaia.entity.Cerimonial;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Kennedy on 02/12/2015.
 */
@Dependent
public class CerimonialBO {

    CerimonialDAO dao = new CerimonialDAO();

    public CerimonialBO() {
    }

    public void salvar(Cerimonial c){
        dao.Salvar(c);
    }
    

    public List<Cerimonial> listar(){
        return dao.Listar();
    }

    public void excluir (int c){
        dao.Excluir(c);
    }

    public Cerimonial Editar(int id) {
        return dao.Editar(id);
    }
}
