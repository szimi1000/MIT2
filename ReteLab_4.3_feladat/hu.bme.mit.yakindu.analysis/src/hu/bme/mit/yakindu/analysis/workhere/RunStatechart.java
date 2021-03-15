package hu.bme.mit.yakindu.analysis.workhere;

import java.io.IOException;
import java.util.Scanner;

import hu.bme.mit.yakindu.analysis.RuntimeService;
import hu.bme.mit.yakindu.analysis.TimerService;
import hu.bme.mit.yakindu.analysis.example.ExampleStatemachine;
import hu.bme.mit.yakindu.analysis.example.IExampleStatemachine;

public class RunStatechart {
	
	public static void main(String[] args) throws IOException {
		ExampleStatemachine s = new ExampleStatemachine();
		s.setTimer(new TimerService());
		RuntimeService.getInstance().registerStatemachine(s, 200);
		s.init();
		s.enter();
		s.runCycle();
		
		Scanner in = new Scanner (System.in);
		while (in.hasNext())
		{
			String row = in.nextLine();
			switch(row) {
			case "start":
				s.raiseStart();
				break;
			case "white":
				s.raiseWhite();
				break;
			case "black":
				s.raiseBlack();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.err.println("Error");
				break;
			}
			s.runCycle();
			print(s);
			System.out.println("Ido: ");
		}
		// print(s);
		// s.raiseStart();
		// s.runCycle();
		// System.in.read();
		// s.raiseWhite();
		// s.runCycle();
		// print(s);
		// System.exit(0);
	}

	public static void print(IExampleStatemachine s) {
		System.out.println("W = " + s.getSCInterface().getWhiteTime());
		System.out.println("B = " + s.getSCInterface().getBlackTime());
	}
}
