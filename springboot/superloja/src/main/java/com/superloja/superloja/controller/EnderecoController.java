package com.superloja.superloja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.superloja.superloja.model.endereco.CepDTO;
import com.superloja.superloja.model.endereco.Endereco;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    private String apiURL = "https://viacep.com.br/ws";
    private String dataFormat = "json";

    @GetMapping("/consulta")
    @ResponseBody
    public String consultaCep (String cep){
        RestTemplate rt = new RestTemplate();
        String urlconsulta = apiURL + "/" + cep + "/" + dataFormat;
        CepDTO dados = rt.getForObject(urlconsulta, CepDTO.class);
        Endereco e = new Endereco(dados);
        String resposta = "Resultado da busca" + e;
        return resposta;
    }


}
