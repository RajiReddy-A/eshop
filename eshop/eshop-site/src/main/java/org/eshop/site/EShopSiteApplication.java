package org.eshop.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"org.eshop.core.*","org.eshop.site.*"})
@EntityScan("org.eshop.core.entities")
@EnableJpaRepositories("org.eshop.core.*")
public class EShopSiteApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(EShopSiteApplication.class, args);
    }
}
