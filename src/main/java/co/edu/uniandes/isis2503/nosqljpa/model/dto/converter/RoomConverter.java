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

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IRoomConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.RoomDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.RoomEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.mendoza968
 */
public class RoomConverter implements IRoomConverter {

    public static IRoomConverter CONVERTER = new RoomConverter();

    public RoomConverter() {
    }

    @Override
    public RoomDTO entityToDto(RoomEntity entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setConsolidatedData(entity.getConsolidatedData());
        dto.setSensors(entity.getSensors());
        return dto;
    }

    @Override
    public RoomEntity dtoToEntity(RoomDTO dto) {
        RoomEntity entity = new RoomEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setSensors(dto.getSensors());
        entity.setConsolidatedData(dto.getConsolidatedData());
        return entity;
    }

    @Override
    public List<RoomDTO> listEntitiesToListDTOs(List<RoomEntity> entities) {
        ArrayList<RoomDTO> dtos = new ArrayList<>();
        for (RoomEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<RoomEntity> listDTOsToListEntities(List<RoomDTO> dtos) {
        ArrayList<RoomEntity> entities = new ArrayList<>();
        for (RoomDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

}
