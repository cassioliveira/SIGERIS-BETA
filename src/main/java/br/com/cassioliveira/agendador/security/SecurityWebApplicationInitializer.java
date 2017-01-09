package br.com.cassioliveira.agendador.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author cassio
 */
public class SecurityWebApplicationInitializer  extends AbstractSecurityWebApplicationInitializer{
    
    public SecurityWebApplicationInitializer(){
        super(SecurityConfig.class);
    }
    
}
