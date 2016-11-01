/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.org.isis.api;

import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;

/**
 *
 * @author edcracken
 */
public class ValidationRequestContext {

    @Getter
    private Map<String, Object> attributes = new LinkedHashMap<String, Object>();

}
