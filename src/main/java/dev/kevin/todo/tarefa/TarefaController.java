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
    public List<TarefaDTO> listarTarefas() {
        return tarefaService.listarTarefas();
    }

    @PostMapping("criar")
    public TarefaDTO criarTarefa(@RequestBody TarefaDTO tarefaDTO) {
        return tarefaService.criarTarefa(tarefaDTO);
    }

    @PutMapping("editar/{id}")
    public TarefaDTO editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaEdit) {
        return tarefaService.editarTarefa(id, tarefaEdit);
    }

    @DeleteMapping("deletar/{id}")
    public void deletarTarefa(@PathVariable Long id) {
        tarefaService.deletarTarefa(id);
    }


}
