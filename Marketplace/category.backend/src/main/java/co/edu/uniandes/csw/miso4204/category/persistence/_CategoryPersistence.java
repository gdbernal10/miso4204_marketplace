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

package co.edu.uniandes.csw.miso4204.category.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.uniandes.csw.miso4204.category.logic.dto.CategoryDTO;
import co.edu.uniandes.csw.miso4204.category.logic.dto.CategoryPageDTO;
import co.edu.uniandes.csw.miso4204.category.persistence.converter.CategoryConverter;
import co.edu.uniandes.csw.miso4204.category.persistence.entity.CategoryEntity;

public abstract class _CategoryPersistence{

  	protected EntityManager entityManager;
	
	public CategoryDTO createCategory(CategoryDTO category) {
		CategoryEntity entity=CategoryConverter.persistenceDTO2Entity(category);
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		return CategoryConverter.entity2PersistenceDTO(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<CategoryDTO> getCategorys() {
		entityManager.getTransaction().begin();
		Query q = entityManager.createQuery("select u from CategoryEntity u");
		List<CategoryDTO> result = CategoryConverter.entity2PersistenceDTOList(q.getResultList());
		entityManager.getTransaction().commit();
		return result;
		
	}

	@SuppressWarnings("unchecked")
	public CategoryPageDTO getCategorys(Integer page, Integer maxRecords) {
		entityManager.getTransaction().begin();
		Query count = entityManager.createQuery("select count(u) from CategoryEntity u");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		Query q = entityManager.createQuery("select u from CategoryEntity u");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		CategoryPageDTO response = new CategoryPageDTO();
		response.setTotalRecords(regCount);
		response.setRecords(CategoryConverter.entity2PersistenceDTOList(q.getResultList()));
		entityManager.getTransaction().commit();
		return response;
	}

	public CategoryDTO getCategory(Long id) {
		entityManager.getTransaction().begin();
		CategoryDTO result = CategoryConverter.entity2PersistenceDTO(entityManager.find(CategoryEntity.class, id));
		entityManager.getTransaction().commit();
		return result;
	}

	public void deleteCategory(Long id) {
		entityManager.getTransaction().begin();
		CategoryEntity entity=entityManager.find(CategoryEntity.class, id);
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	public void updateCategory(CategoryDTO detail) {
		entityManager.getTransaction().begin();
		CategoryEntity entity=entityManager.merge(CategoryConverter.persistenceDTO2Entity(detail));
		CategoryConverter.entity2PersistenceDTO(entity);
		entityManager.getTransaction().commit();
	}

}