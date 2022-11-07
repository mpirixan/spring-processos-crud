package br.com.georgefms.processosweb.controllers;

import br.com.georgefms.processosweb.models.DtoProcesso;
import br.com.georgefms.processosweb.models.Processo;
import br.com.georgefms.processosweb.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/processos")
public class ProcessoController {

    @Autowired
    private ProcessoRepository repository;

    //Lista de todos os processos
    @GetMapping("")
    public ModelAndView index(){
        List<Processo> listaProcessos = repository.findAll();
        ModelAndView mv = new ModelAndView("processos/index");
        mv.addObject("processos", listaProcessos);
        return mv;
    }

    //Chamando a criação de um novo
    @GetMapping("/new")
    public ModelAndView newProcesso(DtoProcesso requisicao){
        return new ModelAndView("processos/new");
    }

    //Submetendo a criação
    @PostMapping("")
    public ModelAndView create(@Valid DtoProcesso requisicao, BindingResult bindingResult){
        System.out.println(requisicao);
        if (bindingResult.hasErrors()){
            return new ModelAndView("processos/new");
        }
        Processo processo = requisicao.toProcesso();
        this.repository.save(processo);
        return new ModelAndView("redirect:/processos");
    }


}
