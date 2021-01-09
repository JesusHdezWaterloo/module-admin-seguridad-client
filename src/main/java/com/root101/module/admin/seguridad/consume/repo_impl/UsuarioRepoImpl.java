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
package com.root101.module.admin.seguridad.consume.repo_impl;

import com.root101.module.admin.seguridad.consume.usecase_def.UsuarioUseCaseConsume;
import static com.root101.module.admin.seguridad.rest.ModuleAdminSeguridadRESTConstants.*;
import com.root101.module.admin.seguridad.core.domain.*;
import com.root101.module.util.rest_config.services.RESTHandler;
import com.root101.spring.client.ConsumerRepoTemplate;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class UsuarioRepoImpl extends ConsumerRepoTemplate<UsuarioDomain> implements UsuarioUseCaseConsume {

    public UsuarioRepoImpl() {
        super(UsuarioDomain.class, RESTHandler.urlActualREST() + USUARIO_GENERAL_PATH);
    }

    @Override
    protected RestOperations template() {
        return RESTHandler.OAuth2RestTemplate();
    }

    @Override
    public UsuarioDomain loadUserByUsername(String username) throws Exception {
        return template().getForObject(urlGeneral + USUARIO_FIND_BY_USERNAME, UsuarioDomain.class);
    }

}
