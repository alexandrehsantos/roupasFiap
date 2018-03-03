package br.com.fiap.roupas.roupasfiap;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.fiap.roupas.roupasfiap.model.Item;
import br.com.fiap.roupas.roupasfiap.repository.ItemRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private ItemRepository itemRepository;

	@Autowired
	public DataLoader(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;

	}

	@Override
	public void run(ApplicationArguments arg0) throws Exception {


		Map<String, BigDecimal> itens = new HashMap<>();
		itens.put("Whey", new BigDecimal(99));
		itens.put("Feijão", new BigDecimal(5.99));
		itens.put("Arroz", new BigDecimal(11));
		itens.put("Batata", new BigDecimal(3.45));
		itens.put("RedBul", new BigDecimal(9.99));

		Set<Entry<String, BigDecimal>> entrySet = itens.entrySet();
		for (Entry<String, BigDecimal> entry : entrySet) {
			Item item2 = new Item();
			item2.setDescricao(entry.getKey());
//			item2.setValor(entry.getValue());
			itemRepository.save(item2);

		}

	}

}