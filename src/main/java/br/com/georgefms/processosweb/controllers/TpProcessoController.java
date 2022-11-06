package br.com.georgefms.processosweb.controllers;

import br.com.georgefms.processosweb.models.DtoTipodeProcesso;
import br.com.georgefms.processosweb.models.TipodeProcesso;
import br.com.georgefms.processosweb.repositories.TipodeProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ModelAndView newTipo(DtoTipodeProcesso dtoTipodeProcessoRequisicao){
        return new ModelAndView("tipos/new");

    }

    //Submissão do registro
    @PostMapping("/tipos")
    public ModelAndView Create(@Valid DtoTipodeProcesso dtoTipodeProcessoRequisicao, BindingResult bindingResult){
        System.out.println(dtoTipodeProcessoRequisicao);
        if (bindingResult.hasErrors()){
            System.out.println("###### EXISTE ERRO NO CAMPO #####");
            return new ModelAndView("tipos/new");
        }
        TipodeProcesso tipodeProcesso = dtoTipodeProcessoRequisicao.toTipoProcesso();
        this.tipodeProcessoRepository.save(tipodeProcesso);
        return new ModelAndView( "redirect:/tipos");
    }

    @GetMapping("/tipos/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<TipodeProcesso> opcional = this.tipodeProcessoRepository.findById(id);
        if(opcional.isPresent()){
            TipodeProcesso tipodeProcesso = opcional.get();
            ModelAndView mv = new ModelAndView("/tipos/show");
            mv.addObject("tipodeprocesso",tipodeProcesso);
            return mv;
        }
        return new ModelAndView("redirect:/tipos");
    }

}
