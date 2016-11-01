/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.api;

/**
 *
 * @author edcracken
 * @param <T>
 */
public interface IValidationRequest<T> {

    public void validate(T parameter, ValidationRequestContext ctx);
}
