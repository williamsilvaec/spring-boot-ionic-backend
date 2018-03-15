package com.williamsilva.cursomc.cursomc.services.validation;

import com.williamsilva.cursomc.cursomc.dto.ClienteNewDTO;
import com.williamsilva.cursomc.cursomc.model.enums.TipoCliente;
import com.williamsilva.cursomc.cursomc.resources.handler.FieldMessage;
import com.williamsilva.cursomc.cursomc.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Override
    public void initialize(ClienteInsert clienteInsert) {

    }

    @Override
    public boolean isValid(ClienteNewDTO clienteNewDTO, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAFISICA.getCodigo()) && !BR.isValidCPF(clienteNewDTO.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if (clienteNewDTO.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCodigo()) && !BR.isValidCNPJ(clienteNewDTO.getCpfOuCnpj())) {
            list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}
