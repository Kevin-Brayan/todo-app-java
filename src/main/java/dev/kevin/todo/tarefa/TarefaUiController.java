package dev.kevin.todo.tarefa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<TarefaDTO> tarefas = tarefaService.listarTarefas();
        model.addAttribute("tarefas", tarefas);

        return "listar-tarefas";
    }

    @GetMapping("criar")
    public String criarTarefa(Model model) {
        model.addAttribute("tarefa", new Tarefa());
        return "criar-tarefa";
    }

    @PostMapping("salvar")
    public String salvarTarefa(@ModelAttribute TarefaDTO tarefaDTO) {
        tarefaService.criarTarefa(tarefaDTO);
        return "redirect:/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarTarefa(@PathVariable Long id, Model model) {
        TarefaDTO tarefa = tarefaService.listarPorId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "editar-tarefa";
        } else {
            return "listar-tarefas";
        }
    }

    @PostMapping("/alterar/{id}")
    public String alterarTarefa(@PathVariable Long id, @ModelAttribute TarefaDTO tarefa) {
        tarefaService.editarTarefa(id, tarefa);
        return "redirect:/ui/listar";
    }

    @GetMapping("/confDelete/{id}")
    public String confDelete(@PathVariable Long id, Model model) {
        TarefaDTO tarefa = tarefaService.listarPorId(id);
        if (tarefa != null) {
            model.addAttribute("tarefa", tarefa);
            return "deletar-tarefa";
        } else {
            return "listar-tarefas";
        }
    }

    @PostMapping("deletar/{id}")
    public String deletar(@PathVariable long id) {
        tarefaService.deletarTarefa(id);
        return "redirect:/ui/listar";
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
