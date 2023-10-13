package br.com.beatrizchalegre.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Pegar a autenticação (usuário e senha)
        var authorization = request.getHeader("Authorization");

        //Remove a palavra "Basic" para ficar apenas o código de autenticação que será decodificado
        var authEncoded = authorization.substring("Basic".length()).trim();

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);

        var authString = new String(authDecode);

        String[] credentials = authString.split(":");
        String username = credentials[0];
        String password = credentials[1];

        System.out.println("Authorization");
        System.out.println(authorization);
        System.out.println(authEncoded);
        System.out.println(authDecode);
        System.out.println(authString);
        System.out.println(username);
        System.out.println(password);

        

        //Validar usuário
        //Validar senha
        //"Segue Viagem"
        filterChain.doFilter(request, response);
    }

}