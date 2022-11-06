package br.com.georgefms.processosweb.controllers;

import br.com.georgefms.processosweb.models.DTOTipodeProcesso;
import br.com.georgefms.processosweb.models.TipodeProcesso;
import br.com.georgefms.processosweb.repositories.TipodeProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TpProcessoController {

    //Acessando o Repositorio
    @Autowired
    private TipodeProcessoRepository tipodeProcessoRepository;
    //Mapeando a lista  de tipos
    @GetMapping("/tipos")
    public ModelAndView index(){
        List<TipodeProcesso> tipos = tipodeProcessoRepository.findAll();
        ModelAndView mv = new ModelAndView("tipos/index");
        mv.addObject("tipos", tipos);
        return mv;
    }

    //Inicio da criacao de um novo registro
    @GetMapping("/tipos/new")
    public ModelAndView newTipo(){
        return new ModelAndView("tipos/new");

    }

    //Submissão do registro
    @PostMapping("/tipos")
    public String Create(@Valid DTOTipodeProcesso dtoTipodeProcesso, BindingResult bindingResult){
        System.out.println(dtoTipodeProcesso);
        if (bindingResult.hasErrors()){
            System.out.println("###### EXISTE ERRO NO CAMPO #####");
            return "redirect:/tipos/new";
        }
        TipodeProcesso tipodeProcesso = dtoTipodeProcesso.toTipoProcesso();
        this.tipodeProcessoRepository.save(tipodeProcesso);
        return "redirect:/tipos";
    }

}
