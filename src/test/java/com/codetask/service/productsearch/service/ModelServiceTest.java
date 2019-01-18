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
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.ModelRepository;

@RunWith(SpringRunner.class)
public class ModelServiceTest {

  @Mock
  private ModelRepository modelRepository;

  @InjectMocks
  private ModelService modelService;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void findAllModels() {

    Model model1 = new Model(1L, "model1", new Brand(1L, "brand1"));
    Model model2 = new Model(2L, "model2", new Brand(2L, "brand2"));
    Mockito.when(modelRepository.findAll()).thenReturn(Arrays.asList(model1, model2));

    ModelResponse modelResponse1 = new ModelResponse(1L, "model1", new BrandResponse(1L, "brand1"));
    ModelResponse modelResponse2 = new ModelResponse(2L, "model2", new BrandResponse(1L, "brand2"));

    List<ModelResponse> allModels = modelService.findAllModels();
    Assert.assertEquals(Arrays.asList(modelResponse1, modelResponse2), allModels);

  }

  @Test
  public void addNewModel() {}

  @After
  public void tearDown() throws Exception {}
}
