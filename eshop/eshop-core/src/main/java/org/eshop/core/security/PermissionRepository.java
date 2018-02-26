package org.eshop.core.security;

import org.eshop.core.entities.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Integer>
{

}
