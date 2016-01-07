package common.factories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;

import common.DBException;
import common.DBMissingException;
import database.DataService;
import database.DataStrategy;
import model.Customer;
import model.Item;
import model.Uitlening;



public class UitleningFactory {

	
	
	public static Uitlening getUitlening () throws DBMissingException, DBException{
	
		Random rand = new Random();
		final Uitlening uitlening = new Uitlening();
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1*rand.nextInt(31));
		DateTime dateTime = new DateTime(calendar);
		uitlening.setBeginVerhuurDatum(dateTime);
		
		uitlening.setVerhuurPeriodeInDagen(rand.nextInt(7));
		
		DataService <Item> dataBaseItem = DataStrategy.getDataService(Item.class);
		List<Item>allItems = dataBaseItem.getAll();
		List<Item>nietUitgeleendeItems = new ArrayList<>();
		for (Item item : allItems) {
			if(!item.getisUitgeleend()){
			nietUitgeleendeItems.add(item);
			}
		}
		uitlening.setUitgeleendItem(allItems.get(rand.nextInt(allItems.size())));
		
		DataService <Customer> dataBaseCustomer = DataStrategy.getDataService(Customer.class);
		List<Customer> allCustomer = dataBaseCustomer.getAll();
		uitlening.setKlantDieUitleent(allCustomer.get(rand.nextInt(allCustomer.size())));

		return uitlening;
	}
}
