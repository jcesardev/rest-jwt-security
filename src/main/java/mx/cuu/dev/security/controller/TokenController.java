package mx.cuu.dev.security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.cuu.dev.security.jwtconf.JwtGenerator;
import mx.cuu.dev.security.model.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    private JwtGenerator jwtGenerator;
    
    
    public TokenController(JwtGenerator jwtGenerator) {
        super();
        this.jwtGenerator = jwtGenerator;
    }


    @PostMapping
    public String generate(@RequestBody final JwtUser jwtUser) {
        
        return jwtGenerator.generate(jwtUser);
    }
    
}
