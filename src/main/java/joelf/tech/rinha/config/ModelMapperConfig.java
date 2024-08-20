package joelf.tech.rinha.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import joelf.tech.rinha.dtos.response.BalanceDtoResponse;
import joelf.tech.rinha.dtos.response.BalanceSimpleDtoResponse;
import joelf.tech.rinha.dtos.response.TransactionDtoResponse;
import joelf.tech.rinha.models.Balance;
import joelf.tech.rinha.models.Transaction;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper config() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        modelMapper.createTypeMap(Balance.class, BalanceDtoResponse.class)
                .addMapping(src -> src.getValue(), BalanceDtoResponse::setTotal);

        modelMapper.createTypeMap(Transaction.class, TransactionDtoResponse.class)
                .addMapping(src -> src.getDescription(), TransactionDtoResponse::setDescricao)
                .addMapping(src -> src.getType(), TransactionDtoResponse::setTipo)
                .addMapping(src -> src.getValue(), TransactionDtoResponse::setValor)
                .addMapping(src -> src.getCreatedAt(), TransactionDtoResponse::setRealizado_em);

        modelMapper.createTypeMap(Balance.class, BalanceSimpleDtoResponse.class)
                .addMapping(src -> src.getValue(), BalanceSimpleDtoResponse::setSaldo)
                .addMapping(src -> src.getClient().getLimit(), BalanceSimpleDtoResponse::setLimite);

        return modelMapper;
    }
}