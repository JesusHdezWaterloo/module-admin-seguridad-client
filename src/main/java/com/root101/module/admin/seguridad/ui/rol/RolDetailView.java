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

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.ui.module.SeguridadModuleNavigator;
import com.root101.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.jhw.swing.models.detail._MaterialPanelDetail;
import com.jhw.swing.material.components.table.Column;
import com.jhw.swing.models.input.dialogs.DialogModelInput;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RolDetailView extends _MaterialPanelDetail<RolDomain> {

    private static final String COL_NOMBRE = "Nombre";

    public RolDetailView() {
        super(
                Column.builder().name(COL_NOMBRE).build()
        );

        this.personalize();
    }

    private void personalize() {
        //addActionsExtra();

        this.setHeaderText("Roles");
        this.setIcon(SeguridadModuleNavigator.ICON_ROL);

        this.setActionColumnButtonsVisivility(true, true, false);//no pone el view, no esta implementado todavia
    }

    @Override
    public void update() {
        try {
            setCollection(SeguridadSwingModule.rolUC.findAll());
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

    @Override
    public Object[] getRowObject(RolDomain obj) {
        return new Object[]{
            obj.getNombreRol()
        };
    }

    @Override
    protected void buttonNuevoActionListener() {
        new DialogModelInput(this, RolInputView.from());
    }

    @Override
    protected RolDomain deleteAction(RolDomain obj) {
        try {
            return SeguridadSwingModule.rolUC.destroy(obj);
        } catch (Exception ex) {
            ExceptionHandler.handleException(ex);
        }
        return null;
    }

    @Override
    protected void editAction(RolDomain obj) {
        new DialogModelInput(this, RolInputView.fromModel(obj));
    }

    @Override
    protected void viewAction(RolDomain obj) {
        System.out.println("NO NECESARIO TODAVÍA.");
    }
}
