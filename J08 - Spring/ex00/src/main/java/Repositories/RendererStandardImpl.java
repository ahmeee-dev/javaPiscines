package Repositories;

public class RendererStandardImpl implements Renderer {
	
	PreProcessor prePro;

	public RendererStandardImpl(PreProcessor preProcessor) { this.prePro = preProcessor; }

	@Override
	public void sendToProcessor(String string) {
		if (prePro instanceof PreProcessorToUpperImpl) {
			System.out.println(string.toUpperCase());
		} else if (prePro instanceof  PreProcessorToLowerImpl) {
			System.out.println(string.toLowerCase());
		} else {
			throw new IllegalArgumentException("Wrong type of PreProcessor!");
		}
	}
}
