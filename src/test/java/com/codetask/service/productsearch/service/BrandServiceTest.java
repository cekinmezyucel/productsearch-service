package com.codetask.service.productsearch.service;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.repository.BrandRepository;

@RunWith(SpringRunner.class)
public class BrandServiceTest {

  @Mock
  private BrandRepository brandRepository;

  @InjectMocks
  private BrandService brandService;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void findAllBrands() {

    Brand brand1 = new Brand(1L, "brand1");
    Brand brand2 = new Brand(2L, "brand2");
    Mockito.when(brandRepository.findAll()).thenReturn(Arrays.asList(brand1, brand2));

    BrandResponse brandResponse1 = new BrandResponse(1L, "brand1");
    BrandResponse brandResponse2 = new BrandResponse(2L, "brand2");

    List<BrandResponse> allBrands = brandService.findAllBrands();
    Assert.assertEquals(Arrays.asList(brandResponse1, brandResponse2), allBrands);
  }

  @Test
  public void addNewBrand() {

    Brand brand1 = new Brand(1L, "brand1");
    Mockito.when(brandRepository.save(brand1)).thenReturn(brand1);

    BrandResponse brandResponse1 = new BrandResponse(1L, "brand1");

    //TODO:fix
    //BrandResponse brandResponse = brandService.addNewBrand(brand1.getName());
    //Assert.assertEquals(null, brandResponse);
  }

  @After
  public void tearDown() throws Exception {}
}
