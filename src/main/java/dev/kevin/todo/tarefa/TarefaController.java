package dev.kevin.todo.tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @GetMapping("home")
    public String teste() {
        return "teste rota home";
    }

    @GetMapping("listar")
    public List<Tarefa> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @PostMapping("criar")
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaService.criarTarefa(tarefa);
    }

//    @PutMapping("editar/{id}")
//    public Tarefa editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaEdit) {
//
//    }

}
