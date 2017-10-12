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
package co.edu.uniandes.isis2503.nosqljpa.logic;

import co.edu.uniandes.isis2503.nosqljpa.interfaces.ISensorLogic;
import static co.edu.uniandes.isis2503.nosqljpa.model.dto.converter.SensorConverter.CONVERTER;
import co.edu.uniandes.isis2503.nosqljpa.model.dto.model.SensorDTO;
import co.edu.uniandes.isis2503.nosqljpa.persistence.SensorPersistence;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author ca.mendoza968
 */
public class SensorLogic implements ISensorLogic {

    private final SensorPersistence persistence;

    public SensorLogic() {
        this.persistence = new SensorPersistence();
    }

    @Override
    public SensorDTO add(SensorDTO dto) {
        if (dto.getId() == null) {
            dto.setId(UUID.randomUUID().toString());
        }
        SensorDTO result = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public SensorDTO update(SensorDTO dto) {
        SensorDTO result = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return result;
    }

    @Override
    public SensorDTO find(String id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }
    
    @Override
    public SensorDTO findCode(String code) {
        return CONVERTER.entityToDto(persistence.findCode(code));
    }

    @Override
    public List<SensorDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(String id) {
        return persistence.delete(id);
    }
}
