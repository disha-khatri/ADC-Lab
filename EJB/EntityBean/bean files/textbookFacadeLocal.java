/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persist;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Phoenix
 */
@Local
public interface textbookFacadeLocal {

    void create(textbook textbook);

    void edit(textbook textbook);

    void remove(textbook textbook);

    textbook find(Object id);

    List<textbook> findAll();

    List<textbook> findRange(int[] range);

    int count();
    
}
