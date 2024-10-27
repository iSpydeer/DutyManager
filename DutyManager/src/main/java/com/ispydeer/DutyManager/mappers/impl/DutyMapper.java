package com.ispydeer.DutyManager.mappers.impl;

import com.ispydeer.DutyManager.duty.Duty;
import com.ispydeer.DutyManager.duty.DutyCommand;
import com.ispydeer.DutyManager.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DutyMapper implements Mapper<DutyCommand, Duty> {

    private ModelMapper modelMapper;

    public DutyMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Duty map(DutyCommand dutyCommand) {
        return modelMapper.map(dutyCommand, Duty.class);
    }

    @Override
    public DutyCommand unmap(Duty duty) {
        return modelMapper.map(duty, DutyCommand.class);
    }
}
