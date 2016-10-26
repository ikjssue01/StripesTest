/*
 * Copyright (C) 2008-2012 Freddy Daoud
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. * 
 */

package org.ms.rrhh.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class BaseActionBean implements ActionBean {
    private ActionBeanContext context;

    @Override
    public ActionBeanContext getContext() {
        return context;
    }
    @Override
    public void setContext(ActionBeanContext context) {
        this.context = context;
    }
}
