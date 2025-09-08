package com.example.projeto_api.Controller;
import com.example.projeto_api.Model.Tarefa;
import com.example.projeto_api.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // 1. CONSULTAR TODAS AS TAREFAS CADASTRADAS
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll();
    }

    // 2. CONSULTAR TAREFA ESPECÍFICA PELO ID 
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        if (tarefa.isPresent()) {
            return ResponseEntity.ok(tarefa.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    // 3. ATUALIZAR UMA TAREFA EXISTENTE
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);
        
        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setNome(tarefaAtualizada.getNome());
            tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
            tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
            return ResponseEntity.ok(tarefaRepository.save(tarefa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4. REMOVER UMA TAREFA
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        if (tarefaRepository.existsById(id)) {
            tarefaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
