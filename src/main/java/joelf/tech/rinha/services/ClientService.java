package joelf.tech.rinha.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import joelf.tech.rinha.dtos.request.TransactionDtoRequest;
import joelf.tech.rinha.dtos.response.*;
import joelf.tech.rinha.enums.TransactionType;
import joelf.tech.rinha.models.Transaction;
import joelf.tech.rinha.repositories.*;

@Service
public class ClientService {

    private final ModelMapper modelMapper;

    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;

    public ClientService(ModelMapper modelMapper, TransactionRepository transactionRepository,
            BalanceRepository balanceRepository) {
        this.modelMapper = modelMapper;
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
    }

    public ExtractDtoResponse getExtractByClientId(Long id) {
        var balance = balanceRepository.getBalanceByClientId(id);
        var transactions = transactionRepository.getTransactionByClientId(id);

        return new ExtractDtoResponse(modelMapper.map(balance, BalanceDtoResponse.class),
                transactions.stream().map(t -> modelMapper.map(t, TransactionDtoResponse.class)).toList());
    }

    public BalanceSimpleDtoResponse createTransaction(TransactionDtoRequest request, Long id) {
        validateTransactionCreation(id, request.getValor());
        transactionRepository.save(modelMapper.map(request, Transaction.class));

        if (request.getTipo().equals(TransactionType.CREDIT)) {
            var balance = balanceRepository.sumBalanceByClientId(id, request.getValor());

            return modelMapper.map(balance, BalanceSimpleDtoResponse.class);
        }
        var balance = balanceRepository.subtractBalanceByClientId(id, request.getValor());

        return modelMapper.map(balance, BalanceSimpleDtoResponse.class);
    }

    public void validateTransactionCreation(Long userId, Integer value) {
        if (balanceRepository.findBalanceWithValueAboveLimite(userId, value) == null) {
            throw new RuntimeException();
        }
    }
}
