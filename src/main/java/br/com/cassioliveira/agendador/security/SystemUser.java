package br.com.cassioliveira.agendador.security;

import br.com.cassioliveira.agendador.model.Subject;
import java.util.Collection;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * Provedor de autenticação customizado para o Spring Security
 *
 * @author cassio
 */
public class SystemUser extends User {

    @Getter
    private final Subject subject;

    public SystemUser(Subject subject, Collection<? extends GrantedAuthority> authorities) {
        super(subject.getUser(), subject.getPassword(), authorities);
        this.subject = subject;
    }
}
