package de.noah.mcfutta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.noah.mcfutta.controller.list.MFOrderListController;

@SpringBootApplication
public class McFuttaWebApplication {

	public static void main(String[] args) {
		
//		JFrame jf = new JFrame("McFuttaWeb");
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jf.setVisible(true);
		
		new MFOrderListController();
		
		SpringApplication.run(McFuttaWebApplication.class, args);
	}
}
