package com.snapdeal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snapdeal.dao.ProductDao;
import com.snapdeal.model.PromotionDto;
import com.snapdeal.service.PromotionDtoService;

@Service
public class PromotionDtoServiceImpl implements PromotionDtoService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<PromotionDto> loadPromotionDtos() {
		List<PromotionDto> promotionDtos = new ArrayList<PromotionDto>();
		promotionDtos.add(new PromotionDto("http://i4.sdlcdn.com/img/storefront/02/Cs_Infous_1280_3rdFeb.jpg",
				"Focus.Flash.Shoot", "NEW SPECIAL OFFER", "Sign up today", "/sign/up/today"));
		promotionDtos.add(new PromotionDto("http://i4.sdlcdn.com/img/storefront/02/at_1280_SamsungA7A5_register_01.jpg",
				"Another example headline", "NEW SPECIAL OFFER", "Learn more", "/learn/more"));
		promotionDtos.add(new PromotionDto("http://i4.sdlcdn.com/img/storefront/02/at_1280_Nexus_5x_6P_01.jpg",
				"Example headline 2", "NEW SPECIAL OFFER", "Sign up today", "/sign/up/today"));
		promotionDtos
				.add(new PromotionDto("http://i3.sdlcdn.com/img/storefront/02/VD_panasonic_eluga_ver_1_1280_21Jan0.jpg",
						"One more for good measure", "@@$", "Buy Now", "/product/aaa"));
		return promotionDtos;
	}

}
