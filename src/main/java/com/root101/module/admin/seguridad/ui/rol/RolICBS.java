/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.admin.seguridad.ui.rol;

import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.ui.module.SeguridadModuleNavigator;
import com.root101.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.models.input.icbs.InputComboBoxSelection;
import com.jhw.swing.models.input.panels.ModelPanel;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RolICBS extends InputComboBoxSelection<RolDomain> {

    public RolICBS() {
        setLabel("Rol");
        setIcon(SeguridadModuleNavigator.ICON_ROL);
    }

    @Override
    public List<RolDomain> getList() throws Exception {
        return SeguridadSwingModule.rolUC.findAll();
    }

    @Override
    public ModelPanel<RolDomain> inputPanel() {
        return RolInputView.from();
    }

    @Override
    protected void addPropertyChange() {
        SeguridadSwingModule.rolUC.addPropertyChangeListener(this);
    }
}
