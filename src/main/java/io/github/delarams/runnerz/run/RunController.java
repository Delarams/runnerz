package io.github.delarams.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
// RestController annotation so we expect the response body to be a JSON
public class RunController {


    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    // @RequestMapping: to map this controller to an end-point. when somebody accesses a specific end point, here's the method I want you to execute
    // @GetMapping annotation which takes both the path and the request method (in this case a Get)

    @GetMapping("")
    List<Run> findAll(){
        // return all the runs in the system
        return runRepository.findAll();
    }
    @GetMapping("/{id}")
    // @PathVariable annotation takes the id that is put in the path and pass it to runById()
    Run findById(@PathVariable Integer id){

        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()){
            throw new RunNotFoundException();
        }
        return run.get();
    }

    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }
    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }
    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }
}
