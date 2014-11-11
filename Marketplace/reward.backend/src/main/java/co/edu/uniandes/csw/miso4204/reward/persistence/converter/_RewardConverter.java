/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.miso4204.reward.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.miso4204.reward.logic.dto.RewardDTO;
import co.edu.uniandes.csw.miso4204.reward.persistence.entity.RewardEntity;

public abstract class _RewardConverter {

	public static RewardDTO entity2PersistenceDTO(RewardEntity entity){
		if (entity != null) {
			RewardDTO dto = new RewardDTO();
					dto.setId(entity.getId());
					dto.setPoints(entity.getPoints());
					dto.setName(entity.getName());
					dto.setPurchaseId(entity.getPurchaseId());
					dto.setBuyerId(entity.getBuyerId());
			return dto;
		}else{
			return null;
		}
	}
	
	public static RewardEntity persistenceDTO2Entity(RewardDTO dto){
		if(dto!=null){
			RewardEntity entity=new RewardEntity();
					entity.setId(dto.getId());
			
					entity.setPoints(dto.getPoints());
			
					entity.setName(dto.getName());
			
					entity.setPurchaseId(dto.getPurchaseId());
			
					entity.setBuyerId(dto.getBuyerId());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<RewardDTO> entity2PersistenceDTOList(List<RewardEntity> entities){
		List<RewardDTO> dtos=new ArrayList<RewardDTO>();
		for(RewardEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<RewardEntity> persistenceDTO2EntityList(List<RewardDTO> dtos){
		List<RewardEntity> entities=new ArrayList<RewardEntity>();
		for(RewardDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}