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

import co.edu.uniandes.isis2503.nosqljpa.interfaces.IFloorConverter;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.FloorDTO;
import co.edu.uniandes.isis2503.nosqljpa.model.entity.FloorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ca.mendoza968
 */
public class FloorConverter implements IFloorConverter {

    public static IFloorConverter CONVERTER = new FloorConverter();

    public FloorConverter() {
    }

    @Override
    public FloorDTO entityToDto(FloorEntity entity) {
        FloorDTO dto = new FloorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setRooms(entity.getRooms());
        return dto;
    }

    @Override
    public FloorEntity dtoToEntity(FloorDTO dto) {
        FloorEntity entity = new FloorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setRooms(dto.getRooms());
        return entity;
    }

    @Override
    public List<FloorDTO> listEntitiesToListDTOs(List<FloorEntity> entities) {
        ArrayList<FloorDTO> dtos = new ArrayList<>();
        for (FloorEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<FloorEntity> listDTOsToListEntities(List<FloorDTO> dtos) {
        ArrayList<FloorEntity> entities = new ArrayList<>();
        for (FloorDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
}
