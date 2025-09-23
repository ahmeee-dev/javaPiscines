package Repositories;

public class PrinterWithPrefixImpl implements Printer {

	private final Renderer renderer;
	private String prefix;

	public PrinterWithPrefixImpl(Renderer renderer) {
		this.renderer = renderer;
	}

	@Override
	public void print(String string) {
		renderer.sendToProcessor(prefix + string);
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
}
