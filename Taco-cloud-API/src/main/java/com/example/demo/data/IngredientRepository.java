package com.example.demo.data;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	
}
