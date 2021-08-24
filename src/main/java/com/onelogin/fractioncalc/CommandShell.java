package com.onelogin.fractioncalc;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.onelogin.fractioncalc.misc.InvalidCommandException;
import com.onelogin.fractioncalc.model.MixedNum;
import com.onelogin.fractioncalc.processor.CommandProcessor;

public class CommandShell {
	
	Logger log = Logger.getLogger(CommandShell.class);

	CommandProcessor cp = new CommandProcessor();

	private ScannerWrapper scanner;
	
	public  CommandShell(ScannerWrapper s) {
		this.scanner = s;
	}

	// This is to enable mocking
	// System scanner cant be mocked since it is a final class.
	// Need a wrapper class that wraps the Scanner.
	public static class ScannerWrapper {
		private Scanner scanner;

		public ScannerWrapper() {
			this.scanner = new Scanner(System.in);
		}

		public boolean hasNextLine() {
			return scanner.hasNextLine();
		}

		public String nextLine() {
			return scanner.nextLine();
		}

		public void close() {
			scanner.close();
		}
	}

	public static void main(String[] args) {
		//Launch the command prompt
		new CommandShell(new ScannerWrapper()).run();
	}

	public void run() {

		try {
			showPrompt();

			//Read and process user input to evaluate expressions until quit command is run.
			while (scanner.hasNextLine()) {

				try {
					String command = scanner.nextLine();

					//Ignore spaces and empty commands and show the prompt.
					if (command.trim().equals("")) {
						showPrompt();
						continue;
					} else if (command.equals("quit")) {
						break;
					}

					MixedNum res = cp.evaluate(command);
					System.out.println("=" + res);

				} catch (InvalidCommandException e) {
					//Error displayed to the user
					System.out.println(e.getMessage());
				} catch (Exception e) {
					//Error shown to the user
					System.out.println("Something went wrong..");

					//TODO Log the error trace to a log file.
				}
				showPrompt();

			}
		} finally {
			scanner.close();
		}
	}

	private static void showPrompt() {
		System.out.print("?");
	}

}
