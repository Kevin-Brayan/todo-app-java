package dev.kevin.todo.tarefa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarefaDTO {

    private Long id;
    private String descricao;
    private boolean concluida;


}
