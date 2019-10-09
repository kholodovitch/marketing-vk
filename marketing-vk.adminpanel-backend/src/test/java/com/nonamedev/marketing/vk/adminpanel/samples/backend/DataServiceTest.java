package com.nonamedev.marketing.vk.adminpanel.samples.backend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.nonamedev.marketing.vk.adminpanel.samples.backend.data.Product;
import com.nonamedev.marketing.vk.adminpanel.samples.backend.mock.MockDataService;

/**
 * Simple unit test for the back-end data service.
 */
public class DataServiceTest {

	private DataService service;

	@Before
	public void setUp() throws Exception {
		service = MockDataService.getInstance();
	}

	@Test
	public void testDataServiceCanFetchProducts() throws Exception {
		assertFalse(service.getAllProducts().isEmpty());
	}

	@Test
	public void testDataServiceCanFetchCategories() throws Exception {
		assertFalse(service.getAllCategories().isEmpty());
	}

	@Test
	public void testUpdateProduct_updatesTheProduct() throws Exception {
		Product p = service.getAllProducts().iterator().next();
		p.setProductName("My Test Name");
		service.updateProduct(p);
		Product p2 = service.getAllProducts().iterator().next();
		assertEquals("My Test Name", p2.getProductName());
	}
}
