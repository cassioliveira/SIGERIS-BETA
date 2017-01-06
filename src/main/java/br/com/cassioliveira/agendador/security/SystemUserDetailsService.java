package br.com.cassioliveira.agendador.security;

import br.com.cassioliveira.agendador.model.GroupType;
import br.com.cassioliveira.agendador.model.Subject;
import br.com.cassioliveira.agendador.services.SubjectService;
import br.com.cassioliveira.agendador.util.cdi.CDIServiceLocator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author cassio
 */
public class SystemUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SubjectService subjectService;
        subjectService = CDIServiceLocator.getBean(SubjectService.class);
        Subject subject = subjectService.byUser(userName);
        SystemUser systemUser = null;

        if (subject != null) {
            systemUser = new SystemUser(subject, getGroups(subject));
        }

        return systemUser;
    }

    private Collection<? extends GrantedAuthority> getGroups(Subject subject) {
        List<SimpleGrantedAuthority> groups = new ArrayList<>();
        for (GroupType group : subject.getGroups()) {
            groups.add(new SimpleGrantedAuthority(group.getName().toUpperCase()));
        }
        return groups;
    }

}
