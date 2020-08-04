package com.ghost.csbstoreapi.services.validation;

import com.ghost.csbstoreapi.dto.ClientNewDTO;
import com.ghost.csbstoreapi.models.enums.ClientType;
import com.ghost.csbstoreapi.resources.exception.FieldMessage;
import com.ghost.csbstoreapi.services.validation.utils.BR;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {
    @Override
    public void initialize(ClientInsert ann) {
    }
    @Override
    public boolean isValid(ClientNewDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(objDto.getType().equals(ClientType.PHYSICALPERSON.getCod()) && !BR.isValidCPF(objDto.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj", "Invalid CPF"));
        }
        if(objDto.getType().equals(ClientType.JURIDICPERSON.getCod()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())){
            list.add(new FieldMessage("cpfOrCnpj", "Invalid CNPJ"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}