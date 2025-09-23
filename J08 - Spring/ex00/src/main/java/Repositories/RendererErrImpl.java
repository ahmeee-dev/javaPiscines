package Repositories;


public class RendererErrImpl implements Renderer {
	
	PreProcessor prePro;

	public RendererErrImpl(PreProcessor preProcessor) { this.prePro = preProcessor; } 

	@Override
	public void sendToProcessor(String string) {
		if (prePro instanceof PreProcessorToUpperImpl) {
			System.err.println(string.toUpperCase());
		} else if (prePro instanceof  PreProcessorToLowerImpl) {
			System.err.println(string.toLowerCase());
		} else {
			throw new IllegalArgumentException("Wrong type of PreProcessor!");
		}
		
	}

}
