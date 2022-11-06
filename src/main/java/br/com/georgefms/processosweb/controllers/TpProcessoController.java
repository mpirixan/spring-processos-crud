package br.com.georgefms.processosweb.controllers;

import br.com.georgefms.processosweb.models.TipodeProcesso;
import br.com.georgefms.processosweb.repositories.TipodeProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TpProcessoController {

    //Acessando o Repositorio
    @Autowired
    private TipodeProcessoRepository tipodeProcessoRepository;

    @GetMapping("/tipos")
    public ModelAndView index(){
        List<TipodeProcesso> tipos = tipodeProcessoRepository.findAll();
        ModelAndView mv = new ModelAndView("tipos/index");
        mv.addObject("tipos", tipos);
        return mv;
    }

}
