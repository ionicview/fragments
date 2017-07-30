package csvdemo;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	private static final String rootCsvPathNm = "src/main/java/csv";

	public static void main(String[] args) {

		Path path = Paths.get(rootCsvPathNm, "generic" + CsvSample.CSV);

		CsvSample<?> csvSample = new CsvSample<>();
		csvSample.runGeneric().accept(path);

	}

}
