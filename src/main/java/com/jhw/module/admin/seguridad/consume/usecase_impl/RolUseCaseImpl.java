/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.consume.usecase_impl;

import com.clean.core.app.usecase.*;
import com.jhw.module.admin.seguridad.consume.module.SeguridadConsumeCoreModule;
import com.jhw.module.admin.seguridad.consume.repo_impl.*;
import com.jhw.module.admin.seguridad.consume.usecase_def.*;
import com.jhw.module.admin.seguridad.core.domain.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RolUseCaseImpl extends DefaultCRUDUseCase<RolDomain> implements RolUseCaseConsume {

    private final RolRepoImpl repoUC = SeguridadConsumeCoreModule.getInstance().getImplementation(RolRepoImpl.class);

    public RolUseCaseImpl() {
        setRepo(repoUC);
    }

}
