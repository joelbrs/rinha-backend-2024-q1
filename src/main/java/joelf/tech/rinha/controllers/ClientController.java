package joelf.tech.rinha.controllers;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import joelf.tech.rinha.dtos.response.ExtractDtoResponse;
import joelf.tech.rinha.services.ClientService;

@RestController
@RequestMapping(value = "/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<ExtractDtoResponse> getExtract(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getExtractByClientId(id));
    }
}
