package com.hieucodeg.service;

import com.hieucodeg.model.Role;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
