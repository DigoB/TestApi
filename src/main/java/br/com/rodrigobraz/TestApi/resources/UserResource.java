package br.com.rodrigobraz.TestApi.resources;

import br.com.rodrigobraz.TestApi.domain.dto.UserDTO;
import br.com.rodrigobraz.TestApi.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResource {

    public static final String ID = "/{id}";
    @Autowired
    private UserService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping(ID)
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {

        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> findAll() {

        return ResponseEntity.ok().body(service.findAll().stream()
                .map(x -> mapper.map(x, UserDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.created(
                uriBuilder.path("/users/{id}").buildAndExpand(service.create(dto).getId()).toUri()).build();
    }

    @PutMapping(ID)
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(dto), UserDTO.class));
    }

    @DeleteMapping(ID)
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
