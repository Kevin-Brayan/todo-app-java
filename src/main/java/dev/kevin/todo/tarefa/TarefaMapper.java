package dev.kevin.todo.tarefa;

public class TarefaMapper {
    public Tarefa map(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();

        tarefa.setId(tarefaDTO.getId());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setConcluida(tarefaDTO.isConcluida());

        return tarefa;
    }

    public TarefaDTO map(Tarefa tarefa) {
        TarefaDTO tarefaDTO = new TarefaDTO();

        tarefaDTO.setId(tarefa.getId());
        tarefaDTO.setDescricao(tarefa.getDescricao());
        tarefaDTO.setConcluida(tarefa.isConcluida());

        return tarefaDTO;
    }

}
