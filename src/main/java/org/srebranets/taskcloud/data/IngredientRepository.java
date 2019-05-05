package org.srebranets.taskcloud.data;

import org.springframework.data.repository.CrudRepository;
import org.srebranets.taskcloud.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
