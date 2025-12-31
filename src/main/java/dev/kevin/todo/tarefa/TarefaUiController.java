package dev.kevin.todo.tarefa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ui/")
public class TarefaUiController {

    private final TarefaService tarefaService;

    public TarefaUiController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("listar")
    public String listarTarefas(Model model) {
        List<Tarefa> tarefas = tarefaService.listarTarefas();
        model.addAttribute("tarefas", tarefas);

        return "listar-tarefas";
    }

    @GetMapping("/concluir/{id}")
    public String concluir(@PathVariable Long id) {
        tarefaService.atualizarStatus(id, true);
        return "redirect:/ui/listar";
    }

    @GetMapping("/desmarcar/{id}")
    public String desmarcar(@PathVariable Long id) {
        tarefaService.atualizarStatus(id, false);
        return "redirect:/ui/listar";
    }

}
