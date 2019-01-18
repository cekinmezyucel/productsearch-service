package com.codetask.service.productsearch.api.resolver;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;

import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.BrandRepository;

public class ModelResolver implements GraphQLResolver<Model> {

  private BrandRepository brandrepository;

  public ModelResolver(BrandRepository brandrepository) {
    this.brandrepository = brandrepository;
  }

  /**
   * {@link Brand} resolver for model.
   *
   * @param model
   * @return @{@link Brand}
   */
  public Brand getBrand(Model model) {
    Optional<Brand> optionalBrand = brandrepository.findById(model.getBrand().getId());

    if (!optionalBrand.isPresent()) {
      throw new RuntimeException();
    }

    return optionalBrand.get();
  }
}
