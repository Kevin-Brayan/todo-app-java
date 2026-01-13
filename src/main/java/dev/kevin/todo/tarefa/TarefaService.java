package dev.kevin.todo.tarefa;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper;

    public TarefaService(TarefaRepository tarefaRepository, TarefaMapper tarefaMapper) {
        this.tarefaRepository = tarefaRepository;
        this.tarefaMapper = tarefaMapper;
    }

    //    Criar tarefa
    public TarefaDTO criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.map(tarefaDTO);
        tarefaRepository.save(tarefa);
        return tarefaMapper.map(tarefa);
    }

//    Listar tarefas
    public List<TarefaDTO> listarTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();

        return tarefas.stream()
                .map(tarefaMapper::map)
                .collect(Collectors.toList());

    }

//    Listar por id
    public TarefaDTO listarPorId(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(tarefaMapper::map).orElse(null);
    }


//    Editar tarefa
    public TarefaDTO editarTarefa(Long id, TarefaDTO tarefaDTO) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if(tarefa.isPresent()) {
            Tarefa tarefaEdit = tarefaMapper.map(tarefaDTO);
            tarefaEdit.setId(id);
            tarefaRepository.save(tarefaEdit);

            return tarefaMapper.map(tarefaEdit);
        }

        return null;
    }

//    Deletar tarefa
    public void deletarTarefa(Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);

        if (tarefa.isPresent()) {
            tarefaRepository.deleteById(id);
        }
    }

//    Marcar como concluída
    @Transactional
    public void atualizarStatus(Long id, boolean concluida) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

        tarefa.setConcluida(concluida);
    }

}
