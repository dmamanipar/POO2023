/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.app.dao;

import java.util.List;
import pe.edu.upeu.app.modelo.CategoriaTO;
import pe.edu.upeu.app.modelo.MarcaTO;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
public interface CategoriaDaoI {
        public int create(CategoriaTO d);

    public int update(CategoriaTO d);

    public int delete(String id) throws Exception;

    public List<CategoriaTO> listCmb(String filter);

    public List<CategoriaTO> listarCategoria();
}
