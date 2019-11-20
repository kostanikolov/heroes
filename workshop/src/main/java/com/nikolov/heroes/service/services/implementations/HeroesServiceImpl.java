package com.nikolov.heroes.service.services.implementations;

import com.nikolov.heroes.data.models.Hero;
import com.nikolov.heroes.data.models.Item;
import com.nikolov.heroes.data.models.enums.SlotType;
import com.nikolov.heroes.data.repositories.HeroRepository;
import com.nikolov.heroes.service.factories.HeroFactory;
import com.nikolov.heroes.service.models.HeroCreateServiceModel;
import com.nikolov.heroes.service.models.HeroDetailsServiceModel;
import com.nikolov.heroes.service.models.HeroItemServiceModel;
import com.nikolov.heroes.service.services.HeroesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroesServiceImpl implements HeroesService {

	private final HeroRepository heroRepository;
	private final HeroFactory heroFactory;
	private final ModelMapper mapper;

	public HeroesServiceImpl(HeroRepository heroRepository, HeroFactory heroFactory, ModelMapper mapper) {
		this.heroRepository = heroRepository;
		this.heroFactory = heroFactory;
		this.mapper = mapper;
	}

	@Override
	public HeroDetailsServiceModel getByName(String name) {
		Optional<Hero> heroOptional = this.heroRepository.getByNameIgnoreCase(name);
		if (heroOptional.isEmpty()) {
			throw new NullPointerException("No such hero");
		}

		Hero hero = heroOptional.get();
		HeroDetailsServiceModel serviceModel = this.mapper.map(hero, HeroDetailsServiceModel.class);

		serviceModel.setWeapon(getItemBySlot(hero.getItems(), SlotType.WEAPON));
		serviceModel.setGauntlets(getItemBySlot(hero.getItems(), SlotType.GAUNTLETS));
		serviceModel.setHelmet(getItemBySlot(hero.getItems(), SlotType.HELMET));
		serviceModel.setPads(getItemBySlot(hero.getItems(), SlotType.PADS));
		serviceModel.setPauldrons(getItemBySlot(hero.getItems(), SlotType.PAULDRON));

		return serviceModel;
	}

	@Override
	public Hero create(HeroCreateServiceModel serviceModel) {
		Hero hero = this.heroFactory.create(serviceModel.getName(), serviceModel.getGender());
		this.heroRepository.save(hero);
		return hero;
	}

	private HeroItemServiceModel getItemBySlot(List<Item> items, SlotType slot) {
		Optional<Item> item = items.stream()
				.filter(x -> x.getSlot() == slot)
				.findFirst();

		return item.isPresent()
				? this.mapper.map(item, HeroItemServiceModel.class)
				: null;
	}
}
