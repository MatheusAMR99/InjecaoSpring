package com.projeto.injecaoDependecia;
import com.projeto.injecaoDependecia.entities.Order;
import com.projeto.injecaoDependecia.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class InjecaoDependeciaApplication  implements CommandLineRunner{

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {

		SpringApplication.run(InjecaoDependeciaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		double basicValue = sc.nextDouble();
		double percentage = sc.nextDouble();

		Order order = new Order(n,basicValue,percentage);
		System.out.printf("Pedido código %d%nValor total: R$ %.2f",n,orderService.total(order));
	}
}
