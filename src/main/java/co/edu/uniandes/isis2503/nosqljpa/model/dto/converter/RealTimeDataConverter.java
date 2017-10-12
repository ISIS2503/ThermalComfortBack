/*
 * The MIT License
 *
 * Copyright 2017 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.nosqljpa.model.dto.converter;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IRealTimeDataConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.RealTimeDataDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.RealTimeDataEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.mendoza968
 */
public class RealTimeDataConverter implements IRealTimeDataConverter {

    public static IRealTimeDataConverter CONVERTER = new RealTimeDataConverter();

    public RealTimeDataConverter() {
    }

    @Override
    public RealTimeDataDTO entityToDto(RealTimeDataEntity entity) {
        RealTimeDataDTO dto = new RealTimeDataDTO();
        dto.setId(entity.getId());
        dto.setDataValue(entity.getDataValue());
        dto.setIdSensor(entity.getIdSensor());
        dto.setSamplingTime(entity.getSamplingTime());
        return dto;
    }

    @Override
    public RealTimeDataEntity dtoToEntity(RealTimeDataDTO dto) {
        RealTimeDataEntity entity = new RealTimeDataEntity();
        entity.setId(dto.getId());
        entity.setDataValue(dto.getDataValue());
        entity.setIdSensor(dto.getIdSensor());
        entity.setSamplingTime(dto.getSamplingTime());
        return entity;
    }

    @Override
    public List<RealTimeDataDTO> listEntitiesToListDTOs(List<RealTimeDataEntity> entities) {
        ArrayList<RealTimeDataDTO> dtos = new ArrayList<>();
        for (RealTimeDataEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<RealTimeDataEntity> listDTOsToListEntities(List<RealTimeDataDTO> dtos) {
        ArrayList<RealTimeDataEntity> entities = new ArrayList<>();
        for (RealTimeDataDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
