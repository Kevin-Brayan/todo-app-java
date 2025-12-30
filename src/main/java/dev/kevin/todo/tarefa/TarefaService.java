package dev.kevin.todo.tarefa;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }


//    Criar tarefa
    public Tarefa criarTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

//    Listar tarefas
    public List<Tarefa> listarTarefas() {
        List<Tarefa> tarefas = new ArrayList<>();
        tarefas.addAll(tarefaRepository.findAll());

        return tarefas;
    }

    public Tarefa editarTarefa(Long id, Tarefa tarefaEdit) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if(tarefa.isPresent()) {
            tarefaEdit.setId(id);
            tarefaRepository.save(tarefaEdit);
        }

        return null;
    }

    public void deletarTarefa(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isPresent()) {
            tarefaRepository.deleteById(id);
        }
    }
}
