package ee.tkasekamp.ltlminer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import org.junit.Test;

public class StarterTest {

	@Test
	public double test(File arquivoXES) throws Exception {
		LTLMinerStarter starter = new LTLMinerStarter(getProps(arquivoXES));
		return starter.mine();
	}

	private Properties getProps(File ArquivoXes) {
		Properties props = new Properties();
		props.setProperty("logPath", ArquivoXes.toString());
		props.setProperty("considerEventTypes", "false");
		props.setProperty("minSupport", "0.0");
		props.setProperty("outputFormat", "retorno");
		String queries = "\"<>((?x{4} /\\ _O(?y{5})))\"";
		props.setProperty("queries", queries);

		return props;
	}

}
