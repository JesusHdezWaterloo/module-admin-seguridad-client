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
import com.root101.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.textarea.MaterialTextArea;
import com.root101.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.root101.swing.material.components.textfield.MaterialTextFactory;
import com.root101.swing.material.components.textfield.*;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.models.clean.CleanCRUDInputView;
import com.root101.swing.prepared.textfield.MaterialPreparedTextFactory;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RolInputView extends CleanCRUDInputView<RolDomain> {

    public static RolInputView from() {
        return new RolInputView(null);
    }

    public static RolInputView fromModel(RolDomain model) {
        return new RolInputView(model);
    }

    private RolInputView(RolDomain model) {
        super(model, SeguridadSwingModule.rolUC, RolDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Rol", "Editar Rol");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre del rol");
        textFieldNombre.setLabel("Rol");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldNivelAcceso = MaterialPreparedTextFactory.buildIntegerIcon();
        textFieldNivelAcceso.setHint("Nivel de acceso del rol");
        textFieldNivelAcceso.setLabel("Nivel de acceso");
        textFieldNivelAcceso.setIcon(MaterialIcons.VPN_LOCK);

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldNivelAcceso);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldNivelAcceso;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("nombreRol", textFieldNombre);
        map.put("nivelAcceso", textFieldNivelAcceso);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
