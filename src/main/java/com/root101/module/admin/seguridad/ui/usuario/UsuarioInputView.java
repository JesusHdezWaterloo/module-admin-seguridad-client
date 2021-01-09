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
package com.root101.module.admin.seguridad.ui.usuario;

import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.admin.seguridad.ui.module.SeguridadSwingModule;
import com.root101.module.admin.seguridad.ui.rol.RolICBS;
import com.root101.swing.material.components.container.layout.VerticalLayoutContainer;
import com.root101.swing.material.components.passwordfield.MaterialPasswordFieldFactory;
import com.root101.swing.material.components.passwordfield.MaterialPasswordFieldIcon;
import com.root101.swing.material.components.textarea.MaterialTextArea;
import com.root101.swing.prepared.textarea.MaterialPreparedTextAreaFactory;
import com.root101.swing.material.components.textfield.MaterialTextFactory;
import com.root101.swing.material.components.textfield.*;
import com.root101.swing.material.standards.MaterialIcons;
import com.root101.swing.models.clean.CleanCRUDInputView;
import java.util.Map;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UsuarioInputView extends CleanCRUDInputView<UsuarioDomain> {

    public static UsuarioInputView from() {
        return new UsuarioInputView(null);
    }

    public static UsuarioInputView fromModel(UsuarioDomain model) {
        return new UsuarioInputView(model);
    }

    private UsuarioInputView(UsuarioDomain model) {
        super(model, SeguridadSwingModule.usuarioUC, UsuarioDomain.class);
        initComponents();
        update();
    }

    private void initComponents() {
        setHeader("Crear Usuario", "Editar Usuario");

        textFieldNombre = MaterialTextFactory.buildIcon();
        textFieldNombre.setHint("Nombre de usuario");
        textFieldNombre.setLabel("Usuario");
        textFieldNombre.setIcon(MaterialIcons.PRIORITY_HIGH);

        textFieldEmail = MaterialTextFactory.buildIcon();
        textFieldEmail.setHint("Email de contacto");
        textFieldEmail.setLabel("Email");
        textFieldEmail.setIcon(MaterialIcons.EMAIL);

        passwordField = MaterialPasswordFieldFactory.buildIcon();
        passwordField.setHint("Contraseña");
        passwordField.setLabel("Contraseña");
        passwordField.setIcon(MaterialIcons.VPN_KEY);

        passwordFieldCheck = MaterialPasswordFieldFactory.buildIcon();
        passwordFieldCheck.setHint("Confirmación de contraseña");
        passwordFieldCheck.setLabel("Confirmación");
        passwordFieldCheck.setIcon(MaterialIcons.VPN_KEY);

        rolICBS = new RolICBS();

        textAreaDescripcion = MaterialPreparedTextAreaFactory.buildDescripcion();

        VerticalLayoutContainer.builder vlc = VerticalLayoutContainer.builder();

        vlc.add(textFieldNombre);
        vlc.add(textFieldEmail);
        vlc.add(passwordField);
        vlc.add(rolICBS);
        vlc.add(textAreaDescripcion, true);

        this.setComponent(vlc.build());
    }

    // Variables declaration - do not modify
    private MaterialTextFieldIcon textFieldNombre;
    private MaterialTextFieldIcon textFieldEmail;
    private MaterialPasswordFieldIcon passwordField;
    private MaterialPasswordFieldIcon passwordFieldCheck;
    private RolICBS rolICBS;
    private MaterialTextArea textAreaDescripcion;
    // End of variables declaration

    @Override
    public void update() {
        super.update();
        passwordField.setObject("");
    }

    @Override
    public Map<String, Object> bindFields() {
        Map<String, Object> map = super.bindFields();
        map.put("username", textFieldNombre);
        map.put("email", textFieldEmail);
        map.put("password", passwordField);
        map.put("rolFk", rolICBS);
        map.put("descripcion", textAreaDescripcion);
        return map;
    }

}
