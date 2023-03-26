/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.app.dao;

import java.util.List;
import pe.edu.upeu.app.modelo.MarcaTO;

/**
 *
 * @author EP-Ing_Sist.-CALIDAD
 */
public interface MarcaDaoI {
    public int create(MarcaTO d);

    public int update(MarcaTO d);

    public int delete(String id) throws Exception;

    public List<MarcaTO> listCmb(String filter);

    public List<MarcaTO> listarMarca();
}
