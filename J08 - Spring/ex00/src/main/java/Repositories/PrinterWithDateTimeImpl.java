package Repositories;

import java.util.Date;

public class PrinterWithDateTimeImpl implements Printer {
	
	private final String dateTimeString;
	private final Renderer renderer;

	public PrinterWithDateTimeImpl(Renderer renderer) {
		this.renderer = renderer;
		this.dateTimeString = "[" + (new Date()).toString() + "] ";
	}

	@Override
	public void print(String string) {
		renderer.sendToProcessor(dateTimeString + string);
	}
}
