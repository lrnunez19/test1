package com.pruebadinamicarea.pruebatecnica;

import com.pruebadinamicarea.pruebatecnica.controller.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@SpringBootApplication
@RestController

public class PruebatecnicaApplication{



	private static List<Item> Articulos = new ArrayList<>();
	//private Item Articulo = new Item(1 , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-15 00:00:00"), new Date(), 1,  3545, 0,  35.50, "EUR" );

	public PruebatecnicaApplication() throws ParseException {
	}


	public static void main(String[] args) throws ParseException {
		SpringApplication.run(PruebatecnicaApplication.class, args);
		Articulos.add(new Item(1 , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-14 00:00:01"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-31 23:59:59"), 1,  35455, 0,  35.50, "EUR" ));
		Articulos.add(new Item(1 , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-14 15:00:00"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-14 18:30:00"), 1,  35455, 0,  35.50, "EUR" ));
		Articulos.add(new Item(1 , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-15 00:00:01"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-15 11:00:00"), 1,  35455, 0,  35.50, "EUR" ));
		Articulos.add(new Item(1 , new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-06-15 16:00:00"), new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse("2020-12-31 23:59:59"), 1,  35455, 0,  35.50, "EUR" ));

	}



	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/id")
	public List<Item> getArticulos(@RequestParam(value = "Id") long Id) {

		List<Item> ArticulosDevueltos = new ArrayList<>();
		for (Item i:this.Articulos){
			if(i.getProductId()==Id) {
				ArticulosDevueltos.add(i);
			}
		}
		return ArticulosDevueltos;
	}
	@GetMapping("/fecha")
	public List<Item> getArticulosFecha(@RequestParam(value = "FechaStart") String FechaStart) throws ParseException {


		List<Item> ArticulosDevueltos = new ArrayList<>();
		for (Item i:this.Articulos){

			//System.out.println(i.SDate);
			Date f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(FechaStart);
			//System.out.println(f);
			if(Objects.equals(i.SDate, f)) {
				ArticulosDevueltos.add(i);
			}
		}
		return ArticulosDevueltos;
	}
}


