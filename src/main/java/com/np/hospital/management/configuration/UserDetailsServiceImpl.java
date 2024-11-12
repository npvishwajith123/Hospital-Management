package com.np.hospital.management.configuration;

import com.np.hospital.management.entities.Roles;
import com.np.hospital.management.entities.Users;
import com.np.hospital.management.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userDetail = userRepository.findByUserName(username).orElse(null);
        if(userDetail!=null) {
            return new User(userDetail.getUserName(), userDetail.getPassword(), getAuthorities(userDetail.getRole()));
        } else {
            throw new BadCredentialsException("User not found for: "+username);
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Roles role) {
        GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
        return List.of(authority);
    }
}
