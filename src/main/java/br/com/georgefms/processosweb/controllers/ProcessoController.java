package br.com.georgefms.processosweb.controllers;

import br.com.georgefms.processosweb.models.DtoProcesso;
import br.com.georgefms.processosweb.models.Processo;
import br.com.georgefms.processosweb.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    //Mostrar um registro
    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id){
        Optional<Processo> opcional = this.repository.findById(id);
        if(opcional.isPresent()){
            Processo processo = opcional.get();
            ModelAndView mv = new ModelAndView("processos/show");
            mv.addObject("processo", processo);
            return mv;
        }
        return new ModelAndView("redirect:/processoss");
    }

    //Editar o Registro
    @GetMapping("/{id}/edit" )
    public ModelAndView edit(@PathVariable long id, DtoProcesso requisicao){
        Optional<Processo> opcional = this.repository.findById(id);
        if (opcional.isPresent()){
            Processo processo = opcional.get();
            requisicao.fromProcesso(processo);

            ModelAndView mv = new ModelAndView("processos/edit");
            mv.addObject("processoId", processo.getNumero());
            return mv;
        }
        return new ModelAndView("redirect:/processos");
    }

    //Atualiza o registro editado
    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid DtoProcesso requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("processos/edit");
            mv.addObject("processoId", id);
            return mv;

        }
        else {
            Optional<Processo> opcional = this.repository.findById(id);
            if (opcional.isPresent()){
                Processo processo = requisicao.toProcesso(opcional.get());
                this.repository.save(processo);
                return new ModelAndView("redirect:/processos/" + processo.getNumero());

            }
            return new ModelAndView("redirect:/processos");


        }
    }

    //Excluindo um registro
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        try {
            this.repository.deleteById(id);
            return "redirect:/processos";
        }
        catch (EmptyResultDataAccessException e){
            return "redirect:/processos";
        }
    }


}
