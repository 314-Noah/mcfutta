package de.noah.mcfutta;

import javax.swing.JFrame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.noah.mcfutta.collections.Repositories;
import de.noah.mcfutta.controller.list.MFOrderListController;
import de.noah.mcfutta.unused.Socket;

@SpringBootApplication
public class McFuttaWebApplication {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("McFuttaWeb");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		new MFOrderListController();
		
		SpringApplication.run(McFuttaWebApplication.class, args);
	}

}
