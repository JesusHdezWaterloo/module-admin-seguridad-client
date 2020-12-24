/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.admin.seguridad.consume.repo_impl;

import com.jhw.module.admin.seguridad.consume.usecase_def.RolUseCaseConsume;
import static com.jhw.module.admin.seguridad.core.ModuleAdminSeguridadConstants.*;
import com.jhw.module.admin.seguridad.core.domain.*;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.utils.spring.client.ConsumerRepoTemplate;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RolRepoImpl extends ConsumerRepoTemplate<RolDomain> implements RolUseCaseConsume {

    public RolRepoImpl() {
        super(RolDomain.class, RESTHandler.urlActualREST() + ROL_GENERAL_PATH);
    }

    @Override
    protected RestOperations template() {
        return RESTHandler.OAuth2RestTemplate();
    }

}
