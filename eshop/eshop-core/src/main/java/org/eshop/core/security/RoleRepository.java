package org.eshop.core.security;

import org.eshop.core.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Integer>
{

	Role findByName(String name);

}
