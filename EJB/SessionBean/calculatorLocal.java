/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmatic;

import javax.ejb.Local;

/**
 *
 * @author Phoenix
 */
@Local
public interface calculatorLocal {

    int add(int a, int b);

    int sub(int a, int b);

    int multiply(int a, int b);

    int divide(int a, int b);

}
